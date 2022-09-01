package com.example.productCRM.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sale extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name="sale_id")
    private List<Product> products;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
