package com.customer.api.service;

import com.customer.api.entity.Customer;
import com.customer.api.entity.dto.CustomerUpdateRequestDto;
import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);

    List<Customer> get();

    Customer getById(Long id);

    Customer update(CustomerUpdateRequestDto customerUpdateRequestDto);

    void delete(Long id);

}
