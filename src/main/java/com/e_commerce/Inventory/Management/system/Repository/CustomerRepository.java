package com.e_commerce.Inventory.Management.system.Repository;

import com.e_commerce.Inventory.Management.system.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
