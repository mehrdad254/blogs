package com.example.demo.data.post.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.post.model.Post;
import com.example.demo.data.post.service.PostService;

@RestController
@RequestMapping(value = "/api/post")
public class PostApi {

	private PostService postService;

	public PostApi(PostService postService) {
		this.postService = postService;
	}
	
	@PostMapping(value = "/addPost")
	public Post postRegiPost(@RequestBody Post post) {
		return this.postService.PostRegister(post);
	}
	
	@GetMapping(value = "/ListPost")
	public List<Post> findAllPost(){
		return this.postService.findAllPost();
	}
	
	@GetMapping(value = "/deletePost/{id}")
	public void deleteOnePost(Post post) {
		this.postService.deleteOnePost(post);
	}
	
	@GetMapping(value = "/editePost/{id}")
	public void editOnePerson(Post post) {
		this.postService.findOnePost(post.getId());
	}
}
