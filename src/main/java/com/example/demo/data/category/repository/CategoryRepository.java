package com.example.demo.data.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
