package com.example.deliveryexpress.service;

import com.example.deliveryexpress.model.Shipment;

import java.util.List;

public interface ShipmentService {

    Shipment createShipment(Shipment shipment);

    Shipment updateShipmentStatus(Long shipmentId, String newStatus);

    List<Shipment> getAllShipments();

    Shipment getShipmentById(Long shipmentId);

    // Другие методы, связанные с бизнес-логикой отправлений
}
