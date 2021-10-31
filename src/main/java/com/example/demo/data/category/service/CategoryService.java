package com.example.demo.data.category.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.category.model.Category;
import com.example.demo.data.category.repository.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findAllCategory(){
		return this.categoryRepository.findAll();
	}

	public Page<Category> findAllCategory(Pageable pageable){
		return this.categoryRepository.findAll(pageable);
	}
	
	@Transactional
	public Category findOneCategory(Long id) {
		return this.categoryRepository.getOne(id);
	}
	
	@Transactional
	public Category SaveCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public void deleteOneCategory(Category category) {
		this.categoryRepository.deleteById(category.getId());
	}
}
