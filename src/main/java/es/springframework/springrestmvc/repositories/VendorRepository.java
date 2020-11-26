package es.springframework.springrestmvc.repositories;

import es.springframework.springrestmvc.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
