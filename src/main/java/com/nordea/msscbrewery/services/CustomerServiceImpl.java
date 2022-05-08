package com.nordea.msscbrewery.services;

import com.nordea.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public CustomerDto getCustomerById(String id) {
        return new CustomerDto().builder()
                                .name("Milind Nirve")
                                .id(id)
                                .build();
    }
}
