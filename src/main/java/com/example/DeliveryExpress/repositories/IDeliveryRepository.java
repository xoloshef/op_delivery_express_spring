package com.example.DeliveryExpress.repositories;

import com.example.DeliveryExpress.models.Delivery;

import java.util.ArrayList;

public interface IDeliveryRepository {
    Delivery getById(Long id);
    ArrayList<Delivery> getAll();
    boolean create(Delivery deliver);
    boolean update(Delivery delivery);
    boolean delete(Long id);

}
