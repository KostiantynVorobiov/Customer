package com.customer.api.service;

import com.customer.api.entity.Customer;
import com.customer.api.entity.dto.CustomerUpdateRequestDto;
import com.customer.api.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {
    private final CustomerRepository repository = Mockito.mock(CustomerRepository.class);
    private final CustomerService service = new CustomerServiceImpl(repository);
    private Customer customerBob;
    private CustomerUpdateRequestDto customerUpdateRequestDto;

    @BeforeEach
    public void init() {
        customerBob = new Customer();
        customerBob.setId(1L);
        customerBob.setCreated(System.currentTimeMillis());
        customerBob.setUpdated(System.currentTimeMillis());
        customerBob.setEmail("bob@i.ua");
        customerBob.setFullName("Bob Bobson");
        customerBob.setPhone("+380988888888");
        customerBob.setDeleted(false);

        customerUpdateRequestDto = new CustomerUpdateRequestDto();
        customerUpdateRequestDto.setId(1L);
        customerUpdateRequestDto.setFullName("David Davidson");
        customerUpdateRequestDto.setPhone("+380955555555");
    }

    @Test
    void create() {
        when(repository.save(customerBob)).thenReturn(customerBob);
        Customer actual = service.create(customerBob);
        assertEquals(customerBob, actual);
    }

    @Test
    void get() {
        Customer customerAlice = new Customer();
        customerAlice.setId(2L);
        customerAlice.setCreated(System.currentTimeMillis());
        customerAlice.setUpdated(System.currentTimeMillis());
        customerAlice.setEmail("alica@i.ua");
        customerAlice.setFullName("Alica Alison");
        customerAlice.setPhone("+380977777777");
        customerAlice.setDeleted(false);
        Customer customerTom = new Customer();
        customerTom.setId(3L);
        customerTom.setCreated(System.currentTimeMillis());
        customerTom.setUpdated(System.currentTimeMillis());
        customerTom.setEmail("tom@i.ua");
        customerTom.setFullName("Tom Tomson");
        customerTom.setPhone("+380966666666");
        customerTom.setDeleted(false);
        List<Customer> customers = new ArrayList<>();
        customers.add(customerBob);
        customers.add(customerAlice);
        customers.add(customerTom);
        when(repository.findAll()).thenReturn(customers);
        List<Customer> actual = service.get();
        assertEquals(customers, actual);
    }

    @Test
    void getById() {
        when(repository.findById(customerBob.getId())).thenReturn(Optional.of(customerBob));
        Customer actual = service.getById(1L);
        assertEquals(customerBob, actual);
    }

    @Test
    void update() {
        Customer customerUpdate = new Customer();
        customerUpdate.setId(customerUpdateRequestDto.getId());
        customerUpdate.setCreated(System.currentTimeMillis());
        customerUpdate.setUpdated(System.currentTimeMillis());
        customerUpdate.setEmail("bob@i.ua");
        customerUpdate.setFullName(customerUpdateRequestDto.getFullName());
        customerUpdate.setPhone(customerUpdateRequestDto.getPhone());
        customerUpdate.setDeleted(false);
        when(repository.findById(1L)).thenReturn(Optional.of(customerBob));
        when(repository.save(customerBob)).thenReturn(customerUpdate);
        Customer expected = service.update(1L, customerUpdateRequestDto);
        assertEquals(customerUpdate, expected);
    }

    @Test
    void delete() {
        when(repository.findById(customerBob.getId())).thenReturn(Optional.ofNullable(customerBob));
        service.delete(customerBob.getId());
        assertTrue(customerBob.isDeleted());
    }
}