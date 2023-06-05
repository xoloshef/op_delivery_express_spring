package com.example.DeliveryExpress.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/")
    public String delivery() {
        return "delivery";

    }
}
