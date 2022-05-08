package com.nordea.msscbrewery.services;

import com.nordea.msscbrewery.web.model.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomerById(String id);
}
