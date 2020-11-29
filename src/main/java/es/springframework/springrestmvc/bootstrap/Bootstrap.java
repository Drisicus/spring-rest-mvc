package es.springframework.springrestmvc.bootstrap;

import es.springframework.springrestmvc.domain.Category;
import es.springframework.springrestmvc.domain.Customer;
import es.springframework.springrestmvc.domain.Vendor;
import es.springframework.springrestmvc.repositories.CategoryRepository;
import es.springframework.springrestmvc.repositories.CustomerRepository;
import es.springframework.springrestmvc.repositories.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {
    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository,
                     VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        log.info("Categories Loaded: {}", categoryRepository.count());

        Customer bob = new Customer();
        bob.setFirstName("Bob");
        bob.setLastName("Bobinson");

        Customer jean = new Customer();
        jean.setFirstName("Jean");
        jean.setLastName("Jeaninson");

        customerRepository.save(bob);
        customerRepository.save(jean);

        log.info("Customers Loaded: {}", customerRepository.count());

        Vendor smallShop = new Vendor();
        smallShop.setName("Small Shop");
        smallShop.setVendorUrl("smallshop.com");

        Vendor superMarket = new Vendor();
        superMarket.setName("Super Market");
        superMarket.setVendorUrl("supermarket.com");

        vendorRepository.save(smallShop);
        vendorRepository.save(superMarket);

        log.info("Vendors Loaded: {}", vendorRepository.count());

    }
}
