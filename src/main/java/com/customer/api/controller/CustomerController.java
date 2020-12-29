package com.customer.api.controller;

import com.customer.api.entity.Customer;
import com.customer.api.entity.dto.CustomerRequestDto;
import com.customer.api.entity.dto.CustomerResponseDto;
import com.customer.api.entity.dto.CustomerUpdateRequestDto;
import com.customer.api.service.CustomerService;
import com.customer.api.service.mapper.CustomerMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;
    private final CustomerMapper mapper;

    @Autowired
    public CustomerController(CustomerService service, CustomerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public CustomerResponseDto create(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        Customer customer = mapper.mapToEntity(customerRequestDto);
        Customer customerFromDb = service.create(customer);
        return mapper.mapToDto(customerFromDb);
    }

    @GetMapping
    public List<CustomerResponseDto> allCustomers() {
        return service.get().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getCustomer(@PathVariable Long id) {
        Customer customer = service.getById(id);
        return mapper.mapToDto(customer);
    }

    @PutMapping("/{id}")
    public CustomerResponseDto update(@Valid @PathVariable Long id,
                                       @RequestBody CustomerUpdateRequestDto
                                               customerUpdateRequestDto) {
        Customer customer = service.update(id, customerUpdateRequestDto);
        return mapper.mapToDto(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
