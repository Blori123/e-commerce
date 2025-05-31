package com.e_commerce.Inventory.Management.system.Repository;

import com.e_commerce.Inventory.Management.system.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
