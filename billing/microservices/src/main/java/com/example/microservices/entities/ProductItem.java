package com.example.microservices.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private Long productID;
    private double price;
    private double quantity;
    @ManyToOne
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    @Transient
    private Product product;

    public ProductItem(Long id, Long productID, double price, double quantity, Bill bill) {
        this.id = id;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        this.bill = bill;
    }
    public ProductItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
