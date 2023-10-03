package com.example.deliveryexpress.service;

import com.example.deliveryexpress.model.Shipment;
import com.example.deliveryexpress.model.ShipmentStatus;

import java.util.List;

public interface ShipmentService {

    Shipment createShipment(Shipment shipment);

    Shipment updateShipmentStatus(Long shipmentId, ShipmentStatus newStatus);

    List<Shipment> getAllShipments();

    Shipment getShipmentById(Long shipmentId);

    Shipment findShipmentByTrackingNumber(String trackingNumber);


    // Другие методы, связанные с бизнес-логикой отправлений
}
