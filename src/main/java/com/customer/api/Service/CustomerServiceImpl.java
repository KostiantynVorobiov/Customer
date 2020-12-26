package com.customer.api.Service;

import com.customer.api.Service.mapper.CustomerMapper;
import com.customer.api.entity.Customer;
import com.customer.api.entity.dto.CustomerRequestDto;
import com.customer.api.entity.dto.CustomerResponseDto;
import com.customer.api.entity.dto.CustomerUpdateRequestDto;
import com.customer.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CustomerResponseDto create(CustomerRequestDto customerRequestDto) {
        return null;
    }

    @Override
    public List<CustomerResponseDto> get() {
        return repository.findAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDto getById(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find customer by id: " + id));
        return mapper.mapToDto(customer);
    }

    @Override
    public CustomerResponseDto update(CustomerUpdateRequestDto customerUpdateRequestDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
