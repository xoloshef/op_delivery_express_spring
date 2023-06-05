package com.example.DeliveryExpress.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    private Long id;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;
}