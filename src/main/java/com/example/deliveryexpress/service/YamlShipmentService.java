package com.example.deliveryexpress.service;

import com.example.deliveryexpress.controller.ShipmentForm;
import com.example.deliveryexpress.model.Shipment;
import com.example.deliveryexpress.model.ShipmentStatus;
import com.example.deliveryexpress.model.ShipmentsData;
import com.example.deliveryexpress.repository.ShipmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

@Service
@Primary
public class YamlShipmentService implements ShipmentService {

    private final String YAML_FILE = "shipments.yaml";

    private final ShipmentRepository shipmentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public YamlShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        shipment.setDateReceived(new Date());
        shipment.setLastStatusDate(new Date());
        List<Shipment> shipments = loadShipmentsFromYamlFile();
        shipments.add(shipment);
        saveShipmentsToYamlFile(shipments, YAML_FILE);

        return shipment;
    }

    @Override
    public Shipment updateShipmentStatus(Long shipmentId, ShipmentStatus newStatus) {
        Optional<Shipment> optionalShipment = shipmentRepository.findById(shipmentId);
        Shipment shipment;
        if (optionalShipment.isPresent()) {
            shipment = optionalShipment.get();
            System.out.println("Найдено отправление:");
            System.out.println("ID: " + shipment.getId());
        } else {
            return null;
        }
        shipment.setStatus(newStatus);

        return shipmentRepository.save(shipment);
    }


    @Override
    public List<Shipment> getAllShipments() {
        Yaml yaml = new Yaml();
        System.out.println("File path: " + getClass().getResource("/shipments.yaml"));
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(YAML_FILE)) {
            ShipmentsData shipmentsData = yaml.load(inputStream);
            return shipmentsData.getShipments();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Shipment getShipmentById(Long shipmentId) {
        return null;
    }

    @Override
    public Shipment findShipmentByTrackingNumber(String trackingNumber) {
        List<Shipment> shipments = getAllShipments();

        for (Shipment shipment : shipments) {
            if (shipment.getTrackingNumber().equals(trackingNumber)) {
                return shipment;
            }
        }

        // Если отправление не найдено, вернуть null
        return null;
    }

    private List<Shipment> loadShipmentsFromYamlFile() {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(YAML_FILE)) {
            if (inputStream != null) {
                ShipmentsData shipmentsData = yaml.load(inputStream);
                return shipmentsData.getShipments();
            } else {
                throw new RuntimeException("Failed to load YAML file");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load YAML file", e);
        }
    }


    public void createShipmentFromForm(ShipmentForm shipmentForm) {

        List<Shipment> shipments = loadShipmentsFromYamlFile();

        Shipment newShipment = new Shipment();
        newShipment.setTrackingNumber(shipmentForm.getTrackingNumber());
        newShipment.setSenderAddress(shipmentForm.getSenderAddress());
        newShipment.setDestinationAddress(shipmentForm.getDestinationAddress());
        newShipment.setStatus(shipmentForm.getStatus());

        shipments.add(newShipment);

        saveShipmentsToYamlFile(shipments, YAML_FILE);
    }

    private void saveShipmentsToYamlFile(List<Shipment> shipments, String filePath) {
        Yaml yaml = new Yaml();
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            yaml.dump(new ShipmentsData(shipments), fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
