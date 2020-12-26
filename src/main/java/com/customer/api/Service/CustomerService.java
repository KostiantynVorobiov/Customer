package com.customer.api.Service;

import com.customer.api.entity.dto.CustomerRequestDto;
import com.customer.api.entity.dto.CustomerResponseDto;
import com.customer.api.entity.dto.CustomerUpdateRequestDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto create(CustomerRequestDto customerRequestDto);

    List<CustomerResponseDto> get();

    CustomerResponseDto getById(Long id);

    CustomerResponseDto update(CustomerUpdateRequestDto customerUpdateRequestDto);

    void delete(Long id);

}
