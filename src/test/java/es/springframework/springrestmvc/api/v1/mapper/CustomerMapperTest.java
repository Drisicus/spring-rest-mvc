package es.springframework.springrestmvc.api.v1.mapper;

import es.springframework.springrestmvc.api.v1.model.CustomerDTO;
import es.springframework.springrestmvc.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerMapperTest {

    @Autowired
    CustomerMapper customerMapper = CustomerMapperDecorator.INSTANCE;

    @Test
    void customerToCustomerDTP() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Bob");
        customer.setLastName("Bobinson");

        CustomerDTO customerDTO = customerMapper.customerToCustomerDT0(customer);

        assertEquals(Long.valueOf(1L), customerDTO.getId());
        assertEquals("Bob", customerDTO.getFirstName());
        assertEquals("Bobinson", customerDTO.getLastName());
    }
}