package es.springframework.springrestmvc.api.v1.mapper;

import es.springframework.springrestmvc.api.v1.model.CustomerDTO;
import es.springframework.springrestmvc.domain.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    void customerToCustomerDTP() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Bob");
        customer.setLastName("Bobinson");

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTP(customer);

        assertEquals(Long.valueOf(1L), customerDTO.getId());
        assertEquals("Bob", customerDTO.getFirstName());
        assertEquals("Bobinson", customerDTO.getLastName());
    }
}