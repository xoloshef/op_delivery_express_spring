package com.example.deliveryexpress.repository;

import com.example.deliveryexpress.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    Shipment findByTrackingNumber(String trackingNumber);
}
