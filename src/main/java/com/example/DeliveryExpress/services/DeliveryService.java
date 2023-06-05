package com.example.DeliveryExpress.services;

import com.example.DeliveryExpress.models.Delivery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService {
    private List<Delivery> delivery = new ArrayList<>();
    private long ID = 0;

    {
        delivery.add(new Delivery(++ID, "PlayStation 5", "Simple description", 67000, "Krasnoyarsk", "tomas"));
        delivery.add(new Delivery(++ID, "Iphone 8", "Simple description", 24000, "Moscow", "artmcoder"));
    }

    public List<Delivery> listDelivery() {return delivery; }

    public void saveDelivery(Delivery delivery) {
        delivery.setId(++ID);
        //delivery.add(delivery);
    }

    public void deleteDelivery(long id) {
        delivery.removeIf(delivery -> delivery.getId().equals(id));
    }

}
