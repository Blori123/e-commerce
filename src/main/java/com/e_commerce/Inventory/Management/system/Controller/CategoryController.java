package com.e_commerce.Inventory.Management.system.Controller;

import com.e_commerce.Inventory.Management.system.Dto.CategoryDto;
import com.e_commerce.Inventory.Management.system.Dto.ProductDto;
import com.e_commerce.Inventory.Management.system.Entity.Category;
import com.e_commerce.Inventory.Management.system.Entity.Product;
import com.e_commerce.Inventory.Management.system.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> create( @RequestBody CategoryDto categoryDto){
        Category category= categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
