package com.example.deliveryexpress.controller;

import com.example.deliveryexpress.model.Shipment;
import com.example.deliveryexpress.service.ShipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final ShipmentService shipmentService;

    public MainController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        return "index.html";
    }

    @GetMapping("/search")
    public String search(@RequestParam String trackingNumber, Model model) {
        Shipment shipment = shipmentService.findShipmentByTrackingNumber(trackingNumber);
        if (shipment != null) {
            model.addAttribute("shipment", shipment);
            return "redirect:/result.html?trackingNumber=" + trackingNumber;
        } else {
            return "redirect:/index.html";
        }
    }

    @GetMapping("/result")
    public String showResultPage(@RequestParam String trackingNumber, Model model) {
        Shipment shipment = shipmentService.findShipmentByTrackingNumber(trackingNumber);
        if (shipment != null) {
            model.addAttribute("shipment", shipment);
            return "result.html";
        } else {
            return "index.html";
        }
    }

    @GetMapping("/create")
    public String showCreatePage() {
        return "create.html";
    }

    @PostMapping("/create")
    public String createShipment(@ModelAttribute ShipmentForm shipmentForm) {

        shipmentService.createShipmentFromForm(shipmentForm);
        return "redirect:/index.html";
    }
}
