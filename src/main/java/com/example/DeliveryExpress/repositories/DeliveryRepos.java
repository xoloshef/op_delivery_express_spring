package com.example.DeliveryExpress.repositories;

import com.example.DeliveryExpress.models.Delivery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DeliveryRepos implements IDeliveryRepository {

    private String filePath = "/home/andrey/IdeaProjects/op_delivery_express_spring/src/main/resources/DeliveryDB.yaml";

    private ArrayList<Delivery> read() {
        return null;
    }

    private boolean write(ArrayList<Delivery> list) {
        return true;
    }

    @Override
    public Delivery getById(Long id) {
        var list = read();
        for (Delivery delivery : list) {
            if (delivery.getId() == id) {
                return delivery;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Delivery> getAll() {
        return getAll()
    }

    @Override
    public boolean create(Delivery deliver) {
        return false;
    }

    @Override
    public boolean update(Delivery delivery) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}