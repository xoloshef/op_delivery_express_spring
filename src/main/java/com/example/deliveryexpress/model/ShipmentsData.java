package com.example.deliveryexpress.model;

import java.util.ArrayList;
import java.util.List;

public class ShipmentsData {
    private List<Shipment> shipments;

    public ShipmentsData() {
        // Инициализация списка shipments
        shipments = new ArrayList<>();
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    // Добавление новой отправки в список
    public void addShipment(Shipment shipment) {
        shipments.add(shipment);
    }

    // Получение отправки по индексу
    public Shipment getShipment(int index) {
        if (index >= 0 && index < shipments.size()) {
            return shipments.get(index);
        }
        return null;
    }

    // Удаление отправки по индексу
    public void removeShipment(int index) {
        if (index >= 0 && index < shipments.size()) {
            shipments.remove(index);
        }
    }

    // Другие методы, если необходимо
}
