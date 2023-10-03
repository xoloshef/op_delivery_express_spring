package com.example.deliveryexpress.service;

import com.example.deliveryexpress.model.Shipment;
import com.example.deliveryexpress.model.ShipmentStatus;
import com.example.deliveryexpress.model.ShipmentsData;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Date;
import java.util.Optional;

@Service
@Primary
public class YamlShipmentService implements ShipmentService {

    private final String YAML_FILE = "shipments.yaml";
    private SimpleJpaRepository<Shipment, Long> shipmentRepository;

    @Override
    public Shipment createShipment(Shipment shipment) {
        shipment.setDateReceived(new Date());
        shipment.setLastStatusDate(new Date());
        return shipment; // Верните созданное отправление
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

        return null; // Если отправление с указанным номером трекинга не найдено
    }

    public void saveShipmentsToYamlFile(List<Shipment> shipments, String filePath) throws IOException {
        Yaml yaml = new Yaml();
        yaml.dump(shipments, new FileWriter(filePath));
    }
}
