package io.github.neferupito.hederahotel.repository.customer;

import io.github.neferupito.hederahotel.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
