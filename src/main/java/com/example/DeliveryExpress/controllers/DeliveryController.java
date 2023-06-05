package com.example.DeliveryExpress.controllers;

import com.example.DeliveryExpress.services.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping("/")
    public String delivery() {
        return "delivery";

    }
}
