package es.springframework.springrestmvc.api.v1.mapper;

import es.springframework.model.CustomerDTO;
import es.springframework.springrestmvc.domain.Customer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(CustomerMapperDecorator.class)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO customerToCustomerDT0(Customer customer);
    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
