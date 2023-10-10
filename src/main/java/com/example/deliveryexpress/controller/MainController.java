package com.example.deliveryexpress.controller;

import com.example.deliveryexpress.model.Shipment;
import com.example.deliveryexpress.service.ShipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    private final ShipmentService shipmentService;

    public MainController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }


    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String trackingNumber, Model model) {
        Shipment shipment = shipmentService.findShipmentByTrackingNumber(trackingNumber);
        model.addAttribute("shipment", shipment);
        return "result";
    }

    @GetMapping("/create")
    public String showCreatePage() {
        return "create"; // Вернет шаблон create.html
    }

    @PostMapping("/create")
    public String createShipment(@ModelAttribute ShipmentForm shipmentForm) {
        // Извлеките данные из shipmentForm и сохраните их в YAML-файле
        shipmentService.createShipmentFromForm(shipmentForm);
        return "redirect:/"; // Перенаправьте пользователя на главную страницу после создания трек-номера
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
