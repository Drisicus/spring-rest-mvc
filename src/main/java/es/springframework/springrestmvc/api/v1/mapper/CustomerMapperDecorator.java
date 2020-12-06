package es.springframework.springrestmvc.api.v1.mapper;

import es.springframework.model.CustomerDTO;
import es.springframework.springrestmvc.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class CustomerMapperDecorator implements CustomerMapper {

    @Autowired
    @Qualifier("delegate")
    private CustomerMapper delegate;

    @Override
    public CustomerDTO customerToCustomerDT0(Customer customer) {
        CustomerDTO customerDTO = delegate.customerToCustomerDT0(customer);
        customerDTO.setCustomerUrl("/api/v1/customers/" + customer.getId());
        return customerDTO;
    }
}
