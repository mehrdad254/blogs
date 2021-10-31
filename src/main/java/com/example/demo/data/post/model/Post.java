package com.example.demo.data.post.model;

import java.util.List;

import javax.persistence.*;

import com.example.demo.data.category.model.Category;
import com.example.demo.data.person.model.Person;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "post_tbl")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	@Column(columnDefinition = "text")
	private String subject;

	@Column(updatable = false)
	private String createTime;

	@Column(updatable = false)
	private String createDate;

	private String updateTime;

	private String updateDate;
	
	@ManyToOne
	@JoinColumn(name = "user_fk")
	private Person person;
	
	@ManyToMany
	private List<Category> category;
	
	/**
	 * 
	 */
	public Post() {
	}

	public Post(String title, String subject, String createTime, String createDate, String updateTime, String updateDate, Person person, List<Category> category) {
		this.title = title;
		this.subject = subject;
		this.createTime = createTime;
		this.createDate = createDate;
		this.updateTime = updateTime;
		this.updateDate = updateDate;
		this.person = person;
		this.category = category;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id=" + id +
				", title='" + title + '\'' +
				", subject='" + subject + '\'' +
				", createTime='" + createTime + '\'' +
				", createDate='" + createDate + '\'' +
				", updateTime='" + updateTime + '\'' +
				", updateDate='" + updateDate + '\'' +
				", person=" + person +
				", category=" + category +
				'}';
	}
}
