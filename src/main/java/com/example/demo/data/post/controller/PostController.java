package com.example.demo.data.post.controller;

import com.example.demo.data.category.service.CategoryService;
import com.example.demo.data.person.service.PersonService;
import com.example.demo.data.post.model.Post;
import com.example.demo.data.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    private PostService postService;
    private CategoryService categoryService;
    private PersonService personService;

    @Autowired
    public PostController(PostService postService, CategoryService categoryService, PersonService personService) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.personService = personService;
    }

    @GetMapping("/list")
    public  ModelAndView postShow(ModelAndView model,@PageableDefault(size = 6) Pageable pageable){
        model.addObject("posts",postService.findAllPost(pageable));
        model.setViewName("post/PostManage");
        return model;
    }

    @GetMapping("/register")
    public ModelAndView postCreate(ModelAndView model){
        model.addObject("post",new Post());
        model.addObject("categorys",categoryService.findAllCategory());
        model.setViewName("post/PostCreate");
        return model;
    }

//    @GetMapping("/search")
//    public @ResponseBody List<Post> search(@ModelAttribute Post post){
//        return  postService.findBySearch(post);
//    }


    @PostMapping("/register")
    public ModelAndView register(ModelAndView model, @ModelAttribute Post post, Principal principal){
        post.setPerson(personService.findByEmail(principal.getName()));
        postService.PostRegister(post);
        model.setViewName("redirect:/post/list");
        return model;
    }

    @GetMapping("/editPost/{id}")
    public ModelAndView editPost(ModelAndView model,Post post){
        model.addObject("post",postService.findOnePost(post.getId()));
        model.addObject("categorys",categoryService.findAllCategory());
        model.setViewName("post/PostCreate");
        return model;
    }

    @GetMapping("/deletPost/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ModelAndView deletPost(ModelAndView model,Post post){
        postService.deleteOnePost(post);
        model.setViewName("redirect:/post/list");
        return model;
    }

    @GetMapping("/showPost/{id}")
    public ModelAndView showPost(ModelAndView model,Post post){
        model.addObject("post",postService.findOnePost(post.getId()));
        model.setViewName("post/postShow");
        return model;
    }
}
