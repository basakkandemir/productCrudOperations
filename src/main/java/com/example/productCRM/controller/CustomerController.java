package com.example.productCRM.controller;

import com.example.productCRM.model.dto.CustomerAgeDTO;
import com.example.productCRM.model.dto.CustomerDTO;
import com.example.productCRM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //inject etmek için
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDTO customerDTO){
        this.customerService.addCustomer(customerDTO);
        return new ResponseEntity
                ("Başarılı",HttpStatus.CREATED);
    }

    /*
    [
    {
    "name":"Can",
    "surname":"Kemal",
    "age":40
    },{
    "name":"Can",
    "surname":"Kemal",
    "age":40
},{
    "name":"Can",
    "surname":"Kemal",
    "age":40
},{
    "name":"Can",
    "surname":"Kemal",
    "age":40
}
]
     */
    // customer veya product toplu kayıt ekleme endpointi yazılacak.
    @PostMapping("addList")
    public ResponseEntity addListCustomer(@RequestBody List<CustomerDTO>
                                                  customerDTOList){
        this.customerService.addListCustomer(customerDTOList);
        return new ResponseEntity
                ("Başarılı",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>
                ("Başarılı", HttpStatus.OK);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCustomer(@RequestBody CustomerDTO customerDTO){
        this.customerService.updateCustomer(customerDTO);
    }
    @GetMapping
    public List<CustomerDTO> getCustomerList(){
        return this.customerService.getAllCustomer();
    }

    // id ye göre customer veya product sorgulama
    // eğer id yanlış girilmişse bu kayıt yoksa
    // hata dönmenizi istiyorum.
    @GetMapping("findById")
    public ResponseEntity<CustomerDTO> getCustomerById(@RequestParam(value = "id")
                                       Long id){
        return customerService.getCustomerById(id);
    }
    // tablodaki toplam kayıt sayısı döndüren methodları yazınız.
    @GetMapping("allCount")
    public ResponseEntity<Long> getAllCountInCustomer(){
        return new ResponseEntity<>
                (customerService.getAllCountInCustomer(),HttpStatus.OK);
    }

    @GetMapping("/getByName")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getCustomerByName
            (@RequestParam(name = "name") String name){
        return this.customerService.getCustomerByName(name);
    }

    @GetMapping("/getByNameOrSurname")
    public List<CustomerDTO> getCustomerByNameOrSurname(
            @RequestParam(name="name") String name,
            @RequestParam(name="surname")String surname
    ){
        return this.customerService.getNameOrSurnameForCustomer(name,surname);
    }

    @GetMapping("/distinctByName")
    public List<CustomerDTO> getCustomerDistinctByName(
            @RequestParam(name="name") String name
    ){
        return this.customerService.getDistinctCustomerByName(name);
    }

    @GetMapping("/greaterThan40")
    public List<CustomerDTO> getCustomerGreaterThan40(){
        return this.customerService.getGreaterThan40();
    }
    @GetMapping("/ageAndNameIC")
    public List<CustomerDTO> getByAgeLessThanEqualAndNameIgnoreCase(){
        return this.customerService.getByAgeLessThanEqualAndNameIgnoreCase();
    }

    //TODO: Hatalı Çalışıyor.
    @GetMapping("/allCustomerOrderByName")
    public List<CustomerDTO> getAllCustomerOrderByNameDesc(){
        return this.customerService.getAllCustomerOrderByNameDesc();
    }
    @GetMapping("/ageOrNameContaining")
    public List<CustomerDTO> getByAgeBetweenOrNameContainingIgnoreCase(){
        return this.customerService.getByAgeBetweenOrNameContainingIgnoreCase();
    }

    @GetMapping("/findNameOrSurname")
    public List<CustomerDTO> getCustomersByNameOrSurname(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname) {
      return this.customerService.getCustomersByNameOrSurname(name,surname);
    }

    @GetMapping("/findByAge")
    public List<CustomerDTO> getCustomersByAge(
            @RequestParam(name="start_age") Integer start_age,
            @RequestParam(name="end_age") Integer end_age
    ){
        return customerService.getCustomersByAge(start_age,end_age);
    }

    @GetMapping("/filterByName/{name}")
    public List<CustomerDTO> getCustomersFilterByName(
            @PathVariable(name = "name") String name
    ){
        return customerService.getCustomersFilterByName(name);
    }

    @GetMapping("/groupByAge")
    public List<CustomerAgeDTO> groupByAge(){
        return customerService.groupByAge();
    }

    @GetMapping("/groupByAgeFilterByName/{name}")
    public List<Object> groupByAgeFilterByName(
            @PathVariable("name") String name
    ){
        return customerService.groupByAgeFilterByNameWithHql(name);
    }
}
