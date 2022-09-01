package com.example.productCRM.service;

import com.example.productCRM.model.dto.SaleDTO;
import com.example.productCRM.model.entity.Sale;

import java.util.List;

public interface SaleService {

    void addSale(Long customerId, List<Long> productsId,Long saleId);
    void deleteSale(Long id);
    void updateSale(Long customerId, List<Long> productsId,Long saleId);
    List<SaleDTO> getSales();
}
