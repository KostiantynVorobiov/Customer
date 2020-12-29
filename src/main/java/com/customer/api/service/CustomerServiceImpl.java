package com.customer.api.service;

import com.customer.api.entity.Customer;
import com.customer.api.entity.dto.CustomerUpdateRequestDto;
import com.customer.api.exception.DataProcessingException;
import com.customer.api.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
        customer.setCreated(System.currentTimeMillis());
        customer.setUpdated(System.currentTimeMillis());
        return repository.save(customer);
    }

    @Override
    public List<Customer> get() {
        return repository.findAll().stream()
                .filter(customer -> !customer.isDeleted())
                .collect(Collectors.toList());
    }

    @Override
    public Customer getById(Long id) {
        Optional<Customer> customer = repository.findById(id);
        if (customer.isEmpty()) {
            throw new DataProcessingException("There are no such customer with id: "
                    + id + " in DB");
        }
        if (customer.get().isDeleted()) {
            throw new DataProcessingException("Customer with id: " + id + " is deleted");
        }
        return customer.get();
    }

    @Override
    public Customer update(Long id, CustomerUpdateRequestDto customerUpdateRequestDto) {
        if (id.equals(customerUpdateRequestDto.getId())) {
            Customer customer = getById(id);
            customer.setId(customerUpdateRequestDto.getId());
            customer.setFullName(customerUpdateRequestDto.getFullName());
            customer.setPhone(customerUpdateRequestDto.getPhone());
            customer.setUpdated(System.currentTimeMillis());
            return repository.save(customer);
        }
        throw new DataProcessingException("You can't update customer with id: "
                + id + ", id in url and in body must be equals");

    }

    @Override
    public void delete(Long id) {
        Customer customer = getById(id);
        customer.setDeleted(true);
        repository.save(customer);
    }
}
