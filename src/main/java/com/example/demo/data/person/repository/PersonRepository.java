package com.example.demo.data.person.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.person.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select u from Person u where u.email=:email")
    Person findByQuery(@Param("email") String email);

    Person findByEmail(String email);
}
