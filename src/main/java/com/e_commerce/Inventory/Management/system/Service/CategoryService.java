package com.e_commerce.Inventory.Management.system.Service;


import com.e_commerce.Inventory.Management.system.Dto.CategoryDto;
import com.e_commerce.Inventory.Management.system.Entity.Category;
import com.e_commerce.Inventory.Management.system.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CategoryRepository categoryRepository;


    public Category createCategory(CategoryDto categoryDto) {
        Category category= modelMapper.map(categoryDto, Category.class);
        category.setId(null);
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }
}
