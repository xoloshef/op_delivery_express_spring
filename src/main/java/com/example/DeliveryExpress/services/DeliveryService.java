package com.example.DeliveryExpress.services;

import com.example.DeliveryExpress.models.Delivery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService {
    private List<Delivery> delivers = new ArrayList<>();
    private long ID = 0;

    {
        delivers.add(new Delivery(++ID, "PlayStation 5", "Simple description", 67000, "Krasnoyarsk", "tomas"));
        delivers.add(new Delivery(++ID, "Iphone 8", "Simple description", 24000, "Moscow", "artmcoder"));
    }

    public List<Delivery> listDelivers() {return delivers; }

    public void saveDelivery(Delivery delivery) {
        delivery.setId(++ID);
        delivers.add(delivery);
    }

    public void deleteDelivery(long id) {
        delivers.removeIf(delivery -> delivery.getId().equals(id));
    }

    public Delivery getProductById(Long id) {
        for (Delivery delivery : delivers) {
            if (delivery.getId().equals(id)) return delivery;
        }
        return null;
    }

}
