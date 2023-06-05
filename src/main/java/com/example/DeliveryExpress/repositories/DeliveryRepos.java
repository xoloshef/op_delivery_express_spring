package com.example.DeliveryExpress.repositories;

import com.example.DeliveryExpress.models.Delivery;

import java.util.ArrayList;

public class DeliveryRepos implements IDeliveryRepository{

    private String filePath ="C:\\Users\\prodg\\IdeaProjects\\op_delivery_express_spring\\src\\main\\resources\\DeliveryDB.yaml";
    private ArrayList<Delivery> read(){
        return null;
    }
    private boolean write(ArrayList<Delivery> list){
        return true;
    }
    @Override
    public Delivery getById(Long id) {
        return null;
    }

    @Override
    public ArrayList<Delivery> getAll() {
        return null;
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