package com.example.productCRM.service;

import com.example.productCRM.model.dto.CustomerAgeDTO;
import com.example.productCRM.model.dto.CustomerDTO;
import com.example.productCRM.model.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long id);
    List<CustomerDTO> getCustomerList();

    ResponseEntity<CustomerDTO> getCustomerById(Long id);

    long getAllCountInCustomer();
    void addListCustomer(List<CustomerDTO> customerDTOList);

    List<CustomerDTO> getCustomerByName(String name);
    List<CustomerDTO> getCustomerByNameOrSurname(String name,String surname);
    List<CustomerDTO> getDistinctCustomerByName(String name);
    List<CustomerDTO> getGreaterThan40();
    List<CustomerDTO> getByAgeLessThanEqualAndNameIgnoreCase();
    List<CustomerDTO> getAllCustomerOrderByNameDesc();
    List<CustomerDTO> getByAgeBetweenOrNameContainingIgnoreCase();
    List<CustomerDTO> getAllCustomer();
    List<CustomerDTO> getNameOrSurnameForCustomer
            (String name,String surname);
    List<CustomerDTO> getCustomersByNameOrSurname
            (String name,String surname);

    List<CustomerDTO> getCustomersByAge(Integer start_age,Integer end_age);
    List<CustomerDTO> getCustomersFilterByName(String name);

    List<CustomerAgeDTO> groupByAge();

    List<Object> groupByAgeFilterByNameWithHql(String name);
 }
