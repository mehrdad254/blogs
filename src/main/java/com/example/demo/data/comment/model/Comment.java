package com.example.demo.data.comment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment_tbl")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String creatAt;
	private String updateAt;
	private String title;
	private String subject;
	/**
	 * 
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param creatAt
	 * @param updateAt
	 * @param title
	 * @param subject
	 */
	public Comment(String creatAt, String updateAt, String title, String subject) {
		super();
		this.creatAt = creatAt;
		this.updateAt = updateAt;
		this.title = title;
		this.subject = subject;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreatAt() {
		return creatAt;
	}
	public void setCreatAt(String creatAt) {
		this.creatAt = creatAt;
	}
	public String getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", creatAt=" + creatAt + ", updateAt=" + updateAt + ", title=" + title
				+ ", subject=" + subject + "]";
	}
	
}
