package es.springframework.springrestmvc.repositories;

import es.springframework.springrestmvc.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
