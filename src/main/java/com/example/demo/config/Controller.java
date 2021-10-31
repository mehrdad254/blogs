package com.example.demo.config;

import com.example.demo.data.category.service.CategoryService;
import com.example.demo.data.post.model.Post;
import com.example.demo.data.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
public class Controller {

    private PostService postService;
    private CategoryService categoryService;

    @Autowired
    public Controller(PostService postService, CategoryService categoryService) {
        this.postService = postService;
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/login")
    public ModelAndView LoginPage(ModelAndView modelAndView) {
        modelAndView.setViewName("Login");
        return modelAndView;
    }


    @GetMapping(value = {"/","index"})
    public ModelAndView HomePage(@ModelAttribute("p") Post post, ModelAndView modelAndView, @PageableDefault(size = 6)Pageable pageable){
        modelAndView.addObject("posts",postService.findBySearch(post,pageable));
        modelAndView.addObject("categorys",categoryService.findAllCategory());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/logining")
    public String Logining(){
        return "indexLogin";
    }

}
