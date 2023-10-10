package com.example.deliveryexpress.repository;

import com.example.deliveryexpress.model.Shipment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ShipmentRepository {
    Shipment findByTrackingNumber(String trackingNumber);

    Shipment save(Shipment shipment);

    List<Shipment> findAll();

    Optional<Shipment> findById(Long id);
}


/*
Заметка от chatgpt
Интерфейс ShipmentRepository предоставляет абстракцию для работы с данными, но конкретная реализация будет предоставлена фреймворком Spring Data JPA. Ваше приложение будет использовать этот интерфейс для выполнения операций с данными о почтовых отправлениях, таких как поиск, сохранение и получение информации о них.
 */