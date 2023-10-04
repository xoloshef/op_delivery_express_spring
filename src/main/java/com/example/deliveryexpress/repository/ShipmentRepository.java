package com.example.deliveryexpress.repository;

import com.example.deliveryexpress.model.Shipment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository {
    Shipment findByTrackingNumber(String trackingNumber);

    Shipment save(Shipment shipment);

    List<Shipment> findAll();

    Optional<Shipment> findById(Long id);
    // Другие методы для работы с данными YAML
}
