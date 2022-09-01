package com.example.productCRM.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SaleDTO {
    @JsonProperty(value = "sale_id")
    private Long id;
    @JsonProperty(value = "products")
    private List<ProductDTO> productDTO;
    @JsonProperty(value = "customer")
    private CustomerDTO customerDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductDTO> getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(List<ProductDTO> productDTO) {
        this.productDTO = productDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
    public SaleDTO(){};
    public SaleDTO(Long id, List<ProductDTO> productDTO, CustomerDTO customerDTO) {
        this.id = id;
        this.productDTO = productDTO;
        this.customerDTO = customerDTO;
    }

    @Override
    public String toString() {
        return "SaleDTO{" +
                "id=" + id +
                ", productDTO=" + productDTO +
                ", customerDTO=" + customerDTO +
                '}';
    }
}
