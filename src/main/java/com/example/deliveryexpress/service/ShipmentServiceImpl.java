package com.example.deliveryexpress.service;

import com.example.deliveryexpress.controller.ShipmentForm;
import com.example.deliveryexpress.model.Shipment;
import com.example.deliveryexpress.model.ShipmentStatus;
import com.example.deliveryexpress.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        // логика создания отправления, например, сохранение в репозитории
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment updateShipmentStatus(Long shipmentId, ShipmentStatus newStatus) {
        return null;
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getShipmentById(Long shipmentId) {
        return shipmentRepository.findById(shipmentId).orElse(null);
    }

    @Override
    public Shipment findShipmentByTrackingNumber(String trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber);
    }

    @Override
    public void createShipmentFromForm(ShipmentForm shipmentForm) {
        Shipment newShipment = new Shipment();
        newShipment.setTrackingNumber(shipmentForm.getTrackingNumber());
        newShipment.setSenderAddress(shipmentForm.getSenderAddress());
        newShipment.setDestinationAddress(shipmentForm.getDestinationAddress());
        //
    }
}
