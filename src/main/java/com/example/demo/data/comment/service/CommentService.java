package com.example.demo.data.comment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.comment.model.Comment;
import com.example.demo.data.comment.repository.CommentRepository;

@Service
public class CommentService {

	private CommentRepository commentRepository;

	@Autowired
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	@Transactional
	public Comment PostRegister(Comment comment) {
		return this.commentRepository.save(comment);
	}
	
	public List<Comment> findAllComment(){
		return this.commentRepository.findAll();
	}
	
	@Transactional
	public Comment findOneComment(Comment comment) {
		return this.commentRepository.getOne(comment.getId());
	}
	
	public void deleteOneComment(Comment comment) {
		this.commentRepository.deleteById(comment.getId());
	}
}
