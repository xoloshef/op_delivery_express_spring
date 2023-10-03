package com.example.deliveryexpress.controller;

import com.example.deliveryexpress.model.Shipment;
import com.example.deliveryexpress.service.ShipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    private final ShipmentService shipmentService;

    public MainController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }


    @GetMapping("/")
    public String showHomePage() {
        return "index"; // Вернет шаблон index.html
    }

    @GetMapping("/search")
    public String search(@RequestParam String trackingNumber, Model model) {
        // Ваша логика поиска по trackingNumber
        Shipment shipment = shipmentService.findShipmentByTrackingNumber(trackingNumber);
        model.addAttribute("shipment", shipment);
        return "result"; // Вернет шаблон result.html
    }
}
