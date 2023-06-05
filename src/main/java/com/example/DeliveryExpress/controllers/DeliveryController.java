package com.example.DeliveryExpress.controllers;

import com.example.DeliveryExpress.models.Delivery;
import com.example.DeliveryExpress.services.DeliveryService;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping("/")
    public String deliverys(Model model) {
        model.addAttribute("deliverys", deliveryService.listDelivery() );
        return "deliverys";
    }

    @GetMapping("/delivery/{id}")
    public String deliveryInfo(@PathVariable Long id, Model model) {
        model.addAttribute("delivery", deliveryService.getProductById(id));
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
