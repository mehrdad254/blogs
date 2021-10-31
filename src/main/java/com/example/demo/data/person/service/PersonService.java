package com.example.demo.data.person.service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.transaction.Transactional;

import com.example.demo.config.MyBeanCopy;
import com.example.demo.date.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.data.person.model.Person;
import com.example.demo.data.person.repository.PersonRepository;
import org.springframework.util.ResourceUtils;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	@Autowired
	public PersonService (PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Transactional
	public Person registerPerson(Person person) throws IOException, InvocationTargetException, IllegalAccessException {
	  if(!person.getFile().isEmpty()) {
		  String path = ResourceUtils.getFile("classpath:static/img").getAbsolutePath();
		  byte[] bytes = person.getFile().getBytes();
		  String name = UUID.randomUUID() + "." + Objects.requireNonNull(person.getFile().getContentType()).split("/")[1];
		  Files.write(Paths.get(path + File.separator + name), bytes);
		  person.setPicture(name);
	  }

	  if(!person.getPassword().isEmpty())
	  	  person.setPassword(new BCryptPasswordEncoder().encode(person.getPassword()));

	  if(person.getId() != null) {
	  	    Person exist = personRepository.getOne(person.getId());
			MyBeanCopy beanCopy = new MyBeanCopy();
			beanCopy.copyProperties(exist,person);
			return personRepository.save(exist);
	  }
		DateTime t1 = new DateTime();
		person.setCreatDate(t1.webDate());
		person.setCreateTime(t1.webTime());
		return this.personRepository.save(person);
	}
	
	public List<Person> findAllPerson(){
		return this.personRepository.findAll();
	}

	public Page<Person> findAllPerson(Pageable pageable){
		return this.personRepository.findAll(pageable);
	}

	public void deleteById(Person person) {
		this.personRepository.deleteById(person.getId());
	}

	@Transactional
	public Person findById(Long id) {
		return personRepository.getOne(id);
	}

	
	public Person findByEmail(String email){
		return personRepository.findByEmail(email);
	}
}
