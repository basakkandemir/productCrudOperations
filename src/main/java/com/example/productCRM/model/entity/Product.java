package com.example.productCRM.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
//electronic devices
//dress
//furniture

@Entity
@NamedNativeQuery(name="Product.filterPrice"
, query ="select p.* from Product p where p.price>:price"
        ,resultClass = Product.class)
@NamedQuery(name="Product.averageProduct",
        query = "select avg(p.price) from Product p")
@Table(name="product")
public class Product extends BaseEntity{

    @Column(name="name")
    private String name;
    @Column(name="price")
    private Double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="sale_id", insertable = false, updatable = false)
    private Sale sale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
