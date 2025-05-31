package com.e_commerce.Inventory.Management.system.Service;


import com.e_commerce.Inventory.Management.system.Dto.ProductDto;
import com.e_commerce.Inventory.Management.system.Entity.Category;
import com.e_commerce.Inventory.Management.system.Entity.Product;
import com.e_commerce.Inventory.Management.system.Repository.CategoryRepository;
import com.e_commerce.Inventory.Management.system.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private  ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product createProduct (ProductDto productDto){
        Product product= modelMapper.map(productDto, Product.class);
        product.setId(null);
        product.setCategory(new Category(productDto.getCategoryId()));
        return productRepository.save(product);
    }

    public Product updateProduct (ProductDto productDto){
        Product product= modelMapper.map(productDto, Product.class);
        product.setCategory(new Category(productDto.getCategoryId()));
        return productRepository.save(product);

    }
    public Product getProductById(Long id){
        Optional<Product> productOptional=  productRepository.findById(id);
        return productOptional.orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<Product> getLowStrockproducts(Integer limit) {
        return productRepository.findByStockQuantityLessThan(limit);
    }

    public List<Product> getStrockproducts(Integer limit) {
        return productRepository.findProductByStockQuantity(limit);

    }

    public List<Product> createMultipleProducts(List<ProductDto> productDtoList) {
        List<Product> productList= new ArrayList<>();

        for (ProductDto productDto:productDtoList){
            Product product= modelMapper.map(productDto, Product.class);
            product.setId(null);
            product.setCategory(new Category(productDto.getCategoryId()));
            productList.add(product);
        }
        productRepository.saveAll(productList);
        return productList;
    }

    public Page<Product> getProductsPaginated(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public List<Product> getProductsByCategoryId(Long id) {
        return productRepository.findProductByCategoryId(id);
    }
}
