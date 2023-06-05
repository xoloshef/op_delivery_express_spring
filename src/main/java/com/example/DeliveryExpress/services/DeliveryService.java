package com.example.DeliveryExpress.services;

import com.example.DeliveryExpress.models.Delivery;
import com.example.DeliveryExpress.repositories.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public List<Delivery> listDelivers(String title){
        //List<Delivery> delivers = deliveryRepository.findAll();
        if (title != null) deliveryRepository.findByTitle(title);
        return deliveryRepository.findAll();
    }

    public void saveDelivery(Delivery delivery) {
        log.info("Saving new {}", delivery);
        deliveryRepository.save(delivery);
    }

    public void deleteDelivery(long id) {
        deliveryRepository.deleteById(id);
    }

    public Delivery getProductById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

//    private List<Delivery> delivers = new ArrayList<>();
//    private long ID = 0;
//
//    {
//        delivers.add(new Delivery(++ID, "PlayStation 5", "Simple description", 67000, "Krasnoyarsk", "tomas"));
//        delivers.add(new Delivery(++ID, "Iphone 8", "Simple description", 24000, "Moscow", "artmcoder"));
//    }
//
//    public List<Delivery> listDelivers() {return delivers; }
}
