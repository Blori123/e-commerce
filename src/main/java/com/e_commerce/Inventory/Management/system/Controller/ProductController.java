package com.e_commerce.Inventory.Management.system.Controller;

import com.e_commerce.Inventory.Management.system.Dto.ProductDto;
import com.e_commerce.Inventory.Management.system.Entity.Product;
import com.e_commerce.Inventory.Management.system.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService ;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDto productDto){
        Product product = productService.createProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping("/add-multiple")
    public ResponseEntity<List<Product>> createMultiple(@RequestBody List<ProductDto> productDtoList){
        List<Product> productList= productService.createMultipleProducts(productDtoList);
        return new ResponseEntity<>(productList, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product= productService.getProductById(id);
    return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/category-{id}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Long id){
        List<Product> productList= productService.getProductsByCategoryId(id);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public Product update(@RequestBody ProductDto productDto, @PathVariable Long id){
       return productService.updateProduct(productDto, id);
    }

    @GetMapping(value="low-stock")
    public  ResponseEntity<List<Product>> lowStock(@RequestParam(name="limit")Integer limit){
        List<Product> products = this.productService.getLowStrockproducts(limit);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value="stock")
    public  ResponseEntity<List<Product>> stock(@RequestParam(name="limit")Integer limit) {
        List<Product> products = this.productService.getStrockproducts(limit);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping
    public Page<Product> getProductsPaginated(@RequestParam(defaultValue ="0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable= PageRequest.of(page, size);
        return productService.getProductsPaginated(pageable);

    }






}
