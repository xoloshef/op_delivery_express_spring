package com.example.deliveryexpress.repository;

import com.example.deliveryexpress.model.Shipment;
import com.example.deliveryexpress.model.ShipmentsData;
import org.yaml.snakeyaml.constructor.Constructor;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class YamlShipmentRepository implements ShipmentRepository {

    private final String yamlFilePath = "shipments.yaml"; // Путь к файлу YAML

    @Override
    public Shipment findByTrackingNumber(String trackingNumber) {
        List<Shipment> shipments = loadShipmentsFromYamlFile();

        for (Shipment shipment : shipments) {
            if (shipment.getTrackingNumber().equals(trackingNumber)) {
                return shipment;
            }
        }

        return null;
    }


    @Override
    public Shipment save(Shipment shipment) {
        List<Shipment> shipments = findAll();
        shipments.add(shipment);
        saveAll(shipments);
        return shipment;
    }

    @Override
    public List<Shipment> findAll() {
        try (InputStream inputStream = new FileInputStream(yamlFilePath)) {
            Yaml yaml = new Yaml();
            ShipmentsData shipmentsData = yaml.loadAs(inputStream, ShipmentsData.class);
            return shipmentsData != null ? shipmentsData.getShipments() : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<Shipment> findById(Long id) {
        List<Shipment> shipments = findAll();
        return shipments.stream()
                .filter(shipment -> shipment.getId().equals(id))
                .findFirst();
    }

    private void saveAll(List<Shipment> shipments) {
        try (OutputStream outputStream = new FileOutputStream(yamlFilePath)) {
            DumperOptions options = new DumperOptions();
            options.setIndent(4);
            Yaml yaml = new Yaml(options);
            ShipmentsData shipmentsData = new ShipmentsData(shipments);
            yaml.dump(shipmentsData, new OutputStreamWriter(outputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<Shipment> loadShipmentsFromYamlFile() {
        Yaml yaml = new Yaml(new Constructor(ShipmentsData.class));
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(yamlFilePath)) {
            ShipmentsData shipmentsData = yaml.load(inputStream);
            return shipmentsData.getShipments();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}





