package com.example.microservices.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private Date billingDate;
    private Long customerID;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
    @Transient
    private Customer customer;

    public Bill(Long id, Date billingDate, Long customerID, Collection<ProductItem> productItems) {
        this.id = id;
        this.billingDate = billingDate;
        this.customerID = customerID;
        this.productItems = productItems;
    }
    public Bill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Collection<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(Collection<ProductItem> productItems) {
        this.productItems = productItems;
    }
}
