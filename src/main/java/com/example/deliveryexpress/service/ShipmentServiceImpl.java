package com.example.deliveryexpress.service;

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
        // Реализуйте логику создания отправления, например, сохранение в репозитории
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment updateShipmentStatus(Long shipmentId, ShipmentStatus newStatus) {
        return null;
    }

    @Override
    public List<Shipment> getAllShipments() {
        // Реализуйте логику получения всех отправлений
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getShipmentById(Long shipmentId) {
        // Реализуйте логику получения отправления по его ID
        return shipmentRepository.findById(shipmentId).orElse(null);
    }

    @Override
    public Shipment findShipmentByTrackingNumber(String trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber);
    }

    // Другие методы, связанные с бизнес-логикой отправлений
}
