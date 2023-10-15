package com.mprribeiro.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer quantity_in_stock;

    private Product() {}

    public Product(Long id, String name, Double price, Integer quantity_in_stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity_in_stock = quantity_in_stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity_in_stock() {
        return quantity_in_stock;
    }
}
