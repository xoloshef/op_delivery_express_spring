package com.example.DeliveryExpress.services;

import com.example.DeliveryExpress.models.Delivery;
import com.example.DeliveryExpress.repositories.IDeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryService {
    private final IDeliveryRepository deliveryRepository;

    public ArrayList<Delivery> listDelivers(Long id) {
        //List<Delivery> delivers = deliveryRepository.findAll();
        if (id != null) {
            return deliveryRepository.getAll();
        } else {
            return null;
        }

    }

    public void saveDelivery(Delivery delivery) {
        log.info("Saving new {}", delivery);
        deliveryRepository.create(delivery);
    }

    public void deleteDelivery(long id) {
        log.info("Delete {}", id);
        deliveryRepository.delete(id);
    }

    public Delivery getDeliveryById(Long id) {
        log.info("Get by id {}", id);
        return deliveryRepository.getById(id);
    }
}
