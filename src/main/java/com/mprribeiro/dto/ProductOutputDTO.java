package com.mprribeiro.dto;

public class ProductOutputDTO {

    private final Long id;

    private final String name;

    private final Double price;

    private final Integer quantity_in_stock;


    public ProductOutputDTO(Long id, String name, Double price, Integer quantityInStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        quantity_in_stock = quantityInStock;
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
