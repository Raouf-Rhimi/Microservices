package com.example.microservices.repositories;


import com.example.microservices.entities.Bill;
import com.example.microservices.entities.ProductItem;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name="BillProjection", types = Bill.class)
interface BillProjection{
    public Long getId();
    public Date getBillingDate();
    public Long getCustomerID();
    public Collection<ProductItem> getProductItems();
}

