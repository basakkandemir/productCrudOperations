package com.example.productCRM.controller;

import com.example.productCRM.model.dto.SaleDTO;
import com.example.productCRM.model.dto.SaleRequestDTO;
import com.example.productCRM.model.entity.Sale;
import com.example.productCRM.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @PostMapping("/add")
    public ResponseEntity addSale(@RequestBody SaleRequestDTO saleRequestDTO){
        this.saleService.addSale(saleRequestDTO.getCustomerId(),
                saleRequestDTO.getProductsId(),
                saleRequestDTO.getSaleId());
        return new ResponseEntity("Başarılı Kayıt",
                HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<SaleDTO>> getSales(){
        return new ResponseEntity
                (this.saleService.getSales(),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateSale(@RequestBody SaleRequestDTO saleRequestDTO){
        this.saleService.updateSale(saleRequestDTO.getCustomerId()
                ,saleRequestDTO.getProductsId(),saleRequestDTO.getSaleId());
        return new ResponseEntity("Başarılı Güncelleme",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteSale(@RequestParam(name="id") Long id){
        this.saleService.deleteSale(id);
        return new ResponseEntity("Başarılı Silindi",HttpStatus.OK);
    }
}
