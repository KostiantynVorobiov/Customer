package com.customer.api.service;

import com.customer.api.entity.Customer;
import com.customer.api.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {
    private final CustomerRepository repository = Mockito.mock(CustomerRepository.class);
    private final CustomerService service = new CustomerServiceImpl(repository);

    @Test
    void create() {
        Customer bob = new Customer();
        bob.setEmail("bob@i.ua");
        bob.setFull_name("Bob Bobson");
        bob.setPhone("+380975713857");
        when(repository.save(any())).thenReturn(bob);
        Customer actual = service.create(bob);
        assertEquals(bob, actual);
    }

    @Test
    void get() {
    }

    @Test
    void getById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}