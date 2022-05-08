package com.nordea.msscbrewery.web.controller;


import com.nordea.msscbrewery.services.CustomerService;
import com.nordea.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping ("/{id}")
    public ResponseEntity <CustomerDto> getCustomer(@PathVariable  String id){
        //return new ResponseEntity<>(CustomerDto.builder().id(id).name("Milind Nirve").build(), HttpStatus.OK);
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);

    }
}
