package com.example.deliveryexpress.controller;

import com.example.deliveryexpress.model.Shipment;
import com.example.deliveryexpress.model.ShipmentStatus;
import com.example.deliveryexpress.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        // Обработка HTTP POST-запроса для создания нового отправления
        return shipmentService.createShipment(shipment);
    }

    @PutMapping("/{shipmentId}/status")
    public Shipment updateShipmentStatus(@PathVariable Long shipmentId, @RequestParam ShipmentStatus newStatus) {
        // Обработка HTTP PUT-запроса для обновления статуса отправления
        return shipmentService.updateShipmentStatus(shipmentId, newStatus);
    }

    @GetMapping
    public List<Shipment> getAllShipments() {
        // Обработка HTTP GET-запроса для получения всех отправлений
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{shipmentId}")
    public Shipment getShipmentById(@PathVariable Long shipmentId) {
        // Обработка HTTP GET-запроса для получения отправления по его ID
        return shipmentService.getShipmentById(shipmentId);
    }
}


/*
- src
  - main
    - java
        - com.example.deliveryexpress
          - controller
            MainController.java
            ShipmentController.java
            ShipmentForm.java
          - model
            Shipment.java
            ShipmentsData.java
            ShipmentStatus.java
          - repository
            ShipmentRepository.java
            YamlShipmentRepository.java
          - service
            ShipmentService.java
            ShipmentServiceImpl.java
            YamlShipmentService.java
          DeliveryExpressApplication.java
    - resources
        - static
        - templates
          - create.html
          - index.html
          - result.html
        - application.properties
        - shipments.yaml

 */