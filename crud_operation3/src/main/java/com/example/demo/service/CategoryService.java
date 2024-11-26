package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
    public Page<Category> getAllCategories(int page) {
        return categoryRepository.findAll(PageRequest.of(page - 1, 10));
    }
public Category getCategoryById(int id)
{
	return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));

}
    

public Category createCategory(Category category)
{
return 	categoryRepository.save(category);
}
    


public Category updateCategory(int id, Category updatedCategory) {
    Category category = getCategoryById(id);
    category.setName(updatedCategory.getName());
    return categoryRepository.save(category);
}

public void deleteCategory(int id)
{
	 categoryRepository.deleteById(id);
	}

}
