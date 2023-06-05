package com.example.DeliveryExpress.services;

import com.example.DeliveryExpress.models.Delivery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService {
    private List<Delivery> deliverys = new ArrayList<>();
    private long ID = 0;

    {
        deliverys.add(new Delivery(++ID, "PlayStation 5", "Simple description", 67000, "Krasnoyarsk", "tomas"));
        deliverys.add(new Delivery(++ID, "Iphone 8", "Simple description", 24000, "Moscow", "artmcoder"));
    }

    public List<Delivery> listDelivery() {return deliverys; }

    public void saveDelivery(Delivery delivery) {
        delivery.setId(++ID);
        deliverys.add(delivery);
    }

    public void deleteDelivery(long id) {
        deliverys.removeIf(delivery -> delivery.getId().equals(id));
    }

    public Delivery getProductById(Long id) {
        for (Delivery delivery : deliverys) {
            if (delivery.getId().equals(id)) return delivery;
        }
        return null;
    }

}
