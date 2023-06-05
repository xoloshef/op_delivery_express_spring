package com.example.DeliveryExpress.services;

import com.example.DeliveryExpress.models.Delivery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService {
    private List<Delivery> delivery = new ArrayList<>();

    {
        delivery.add(new Delivery( ""));
    }
}
