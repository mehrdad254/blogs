package com.example.demo.data.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.category.model.Category;
import com.example.demo.data.category.service.CategoryService;

@RestController
@RequestMapping("/api/Category")
public class CategoryApi {

	private CategoryService categoryService;

	@Autowired
	public CategoryApi(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping(value = "/listCategory")
	public List<Category> findAllCategory(){
		return this.categoryService.findAllCategory();
	}
	
	@PostMapping(value = "/addCategory")
	public Category saveCategory(@RequestBody Category category) {
		return this.categoryService.SaveCategory(category);
	}
	
	@GetMapping(value = "/deleteCategory{id}")
	public void deleteCategory(Category category) {
		this.categoryService.deleteOneCategory(category);
	}
	
	@GetMapping(value = "/editCategory/{id}")
	public void editCategory(Category category) {
		this.categoryService.findOneCategory(category.getId());
	}
	
}
