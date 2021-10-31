package com.example.demo.data.post.service;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.date.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.data.post.model.Post;
import com.example.demo.data.post.repository.PostRepository;

@Service
public class PostService {
	private PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@Transactional
	public Post PostRegister(Post post) {
		DateTime t1 = new DateTime();
		post.setCreateDate(t1.webDate());
		post.setCreateTime(t1.webTime());
		post.setUpdateDate(t1.webDate());
		post.setUpdateTime(t1.webTime());
		System.out.println(SecurityContextHolder.getContext());
		return this.postRepository.save(post);
	}
	
	public List<Post> findAllPost(){
		return this.postRepository.findAll();
	}

	public Page<Post> findAllPost(Pageable pageable){
		return this.postRepository.findAll(pageable);
	}

	public Post findOnePost(Long id) {
		return this.postRepository.getOne(id);
	}
	
	public void deleteOnePost(Post post) {
		this.postRepository.deleteById(post.getId());
	}

    public Page<Post> findBySearch(Post post,Pageable pageable) {
		return postRepository.findBySearch(post , (post.getCategory() != null ? (long) post.getCategory().size() : 0),pageable );
    }
}
