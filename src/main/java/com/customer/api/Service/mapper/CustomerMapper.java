package com.customer.api.Service.mapper;

import com.customer.api.entity.Customer;
import com.customer.api.entity.dto.CustomerRequestDto;
import com.customer.api.entity.dto.CustomerResponseDto;
import com.customer.api.entity.dto.CustomerUpdateRequestDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer mapToEntity(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .full_name(customerRequestDto.getFull_name())
                .email(customerRequestDto.getEmail())
                .phone(customerRequestDto.getPhone())
                .build();
    }

    public CustomerResponseDto mapToDto(Customer customer){
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .full_name(customer.getFull_name())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

    public Customer mapToEntityFromUpdateBody(CustomerUpdateRequestDto customerUpdateRequestDto){
        return Customer.builder()
                ..build();
    }
}
