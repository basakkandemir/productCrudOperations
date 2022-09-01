package com.example.productCRM.controller;

import com.example.productCRM.model.dto.ProductDTO;
import com.example.productCRM.model.entity.Product;
import com.example.productCRM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductDTO productDTO){
        this.productService.addProduct(productDTO);
        return new ResponseEntity
                ("Başarılı", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateProduct
            (@RequestBody ProductDTO productDTO){
        this.productService.updateProduct(productDTO);
        return new ResponseEntity("Başarılı Kayıt",
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteProduct(@RequestParam(name="id")
                                            Long id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok("Silindi");
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getListProduct(){
       return ResponseEntity.ok(
               this.productService.getProductList());
    }

    @GetMapping("/sumProducts")
    public ResponseEntity<Long> sumProducts(){
        return ResponseEntity.ok(
                this.productService.sumProducts());
    }

    @GetMapping("/sumProductsFilterByName/{name}")
    public ResponseEntity<Long> sumProductsFilterByName(
            @PathVariable(name="name") String name
    ){
        return ResponseEntity.ok(
                this.productService.sumProductsFilterByName(name));
    }

    @GetMapping("/filterPrice")
    public ResponseEntity<List<Product>> filterPrice(
            @RequestParam(name="price") Long price
    ){
        return ResponseEntity.ok(
                this.productService.filterPrice(price));
    }

    @GetMapping("/average")
    public ResponseEntity<Double>averageProduct(){
        return ResponseEntity.ok(
                this.productService.averageProduct()
        );
    }
}
