package com.mprribeiro.dto;

public class ProductInputDTO {

    private final String name;

    private final Double price;

    private final Integer quantity_in_stock;


    public ProductInputDTO(String name, Double price, Integer quantityInStock) {
        this.name = name;
        this.price = price;
        quantity_in_stock = quantityInStock;
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
