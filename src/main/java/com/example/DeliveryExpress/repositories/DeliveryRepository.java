package com.example.DeliveryExpress.repositories;

import com.example.DeliveryExpress.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByTitle(String title);
}
