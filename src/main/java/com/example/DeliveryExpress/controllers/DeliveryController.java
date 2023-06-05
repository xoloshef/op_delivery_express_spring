package com.example.DeliveryExpress.controllers;

import com.example.DeliveryExpress.models.Delivery;
import com.example.DeliveryExpress.services.DeliveryService;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Repository
@RestController
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping("/")
    public String delivers(@RequestParam(name = "title", required = false) Long id) {
        return "delivers";
    }

    @GetMapping("/delivery/{id}")
    public String deliveryInfo(@PathVariable Long id, Model model) {
        model.addAttribute("ID", deliveryService.getDeliveryById(id));
        //model.addAttribute("delivery", deliveryService.getDeliveryById(id));

        return "delivery-info";
    }

    @PostMapping("/delivery/create")
    public String createDelivery(Delivery delivery) {
        deliveryService.saveDelivery(delivery);
        return "redirect:/";
    }

    @PostMapping("/delivery/delete/{id}")
    public String deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return "redirect:/";
    }
}
