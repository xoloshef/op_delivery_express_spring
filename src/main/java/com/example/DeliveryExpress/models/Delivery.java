package com.example.DeliveryExpress.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Delivery {
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;

    public Delivery(){

    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrice() {
        return this.price;
    }

    public String getCity() {
        return this.city;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String toString() {
        return "Delivery(title=" + this.getTitle() + ", description" + this.getDescription() + ", price" + this.getPrice() + ", city" + this.getCity() + ", author" + this.getAuthor();
    }


    //
//    private String deliveryId;
//    private String deliveryName;
//    private String deliveryStatus;
//    private String senderAddress;
//    private String destinationAddress;
//    private Date deliveryStartDate;
//    private Date deliveryEndDate;
//    private Date deliveryUpdateStatusDate;

}
