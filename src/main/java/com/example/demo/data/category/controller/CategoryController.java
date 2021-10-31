package com.example.demo.data.category.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.category.model.Category;
import com.example.demo.data.category.service.CategoryService;


@Controller
@RequestMapping(value = "/category")
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping(value = "/register")
	public ModelAndView RegisterPage(ModelAndView andView) {
		andView.addObject("category",new Category());
		andView.setViewName("category/CategoryCreate");
		return andView;
	}
	
	@PostMapping(value = "/register")
	public ModelAndView Register(@Valid @RequestBody @ModelAttribute Category category,ModelAndView andView,BindingResult bindingResult) {
		categoryService.SaveCategory(category);
		andView.setViewName("redirect:/category/list");
		return andView;
	}
	
	@GetMapping(value = "/list")
	public ModelAndView showAllCategory( ModelAndView andView ,@PageableDefault(size = 6) Pageable pageable) {
		andView.addObject("categorys",categoryService.findAllCategory(pageable));
		andView.setViewName("category/Category-Manage");
		return andView;
	}
	
	@GetMapping(value = "/deleteCategory/{id}")
	public ModelAndView deleteCategory(Category category,ModelAndView andView) {
		categoryService.deleteOneCategory(category);
		andView.setViewName("redirect:/category/list");
		return andView;
	}
	
	@GetMapping(value = "/editCategory/{id}")
	public ModelAndView editCategory(ModelAndView andView,@PathVariable("id") long id) {
		andView.addObject("category", categoryService.findOneCategory(id));
		andView.setViewName("CategoryCreate");
		return andView;
	}
	
	
}
