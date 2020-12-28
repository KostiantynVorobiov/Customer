package com.customer.api.service.mapper;

import com.customer.api.entity.Customer;
import com.customer.api.entity.dto.CustomerRequestDto;
import com.customer.api.entity.dto.CustomerResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer mapToEntity(CustomerRequestDto customerRequestDto) {
        return Customer.builder()
                .fullName(customerRequestDto.getFullName())
                .email(customerRequestDto.getEmail())
                .phone(customerRequestDto.getPhone())
                .build();
    }

    public CustomerResponseDto mapToDto(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .fullName(customer.getFullName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

}
