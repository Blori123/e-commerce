package com.e_commerce.Inventory.Management.system.Repository;

import com.e_commerce.Inventory.Management.system.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {

List<Product> findByStockQuantityLessThan(Integer limit);
List<Product> findProductByStockQuantity(Integer limit);
List<Product> findProductByCategoryId(Long id);
}

