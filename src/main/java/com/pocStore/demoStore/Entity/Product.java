package com.pocStore.demoStore.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String productCode;
    String name;
    int price;
    String manufacturer;
    String category;
}
