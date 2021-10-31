package com.example.demo.data.comment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.comment.model.Comment;
import com.example.demo.data.comment.service.CommentService;

@RestController
@RequestMapping(value = "/api/comment")
public class CommentApi {

	private CommentService commentService;

	@Autowired
	public CommentApi(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping(value = "/ListComment")
	public List<Comment> findAllComment(){
		return this.commentService.findAllComment();
	}
	
	@PostMapping(value = "/addComment")
	public Comment addComment(@RequestBody Comment comment) {
		return this.commentService.PostRegister(comment);
	}
	
	@GetMapping(value = "/deleteComment/{id}")
	public void deleteOneComment(Comment comment) {
		this.commentService.deleteOneComment(comment);
	}
	
	@GetMapping(value = "/editComment/{id}")
	public void editComment(Comment comment) {
		this.commentService.findOneComment(comment);
	}
}
