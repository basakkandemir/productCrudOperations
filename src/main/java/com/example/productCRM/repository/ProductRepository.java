package com.example.productCRM.repository;

import com.example.productCRM.model.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository
        extends CrudRepository<Product,Long> {
//name e göre sorgu
    //name veya price a göre sorgu
    @Query(value = "select sum(p.price) from Product p")
    Long sumProducts();
    @Query(value = "select sum(price) from product where name" +
            " like '%'||:name||'%'"
    ,nativeQuery = true)
    Long sumProductsFilterByName(String name);

    @Query(nativeQuery = true)
    List<Product> filterPrice(@Param(value = "price") Double price);

    Double averageProduct();
}
