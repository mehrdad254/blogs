package com.example.demo.data.post.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.data.post.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //    @Query("select p from Post p where :#{#post.title} is null or p.title like concat('%',:#{#post.title},'%')")
    @Query("select p from Post p join p.category pc where (:#{#post.title} is null or " +
            "p.title like concat('%',:#{#post.title},'%'))" +
            "and (coalesce(:#{#post.category},null) is null or " +
            "pc in (:#{#post.category})) group by p.id having count (p.id) >= :num")
    Page<Post> findBySearch(Post post, @Param("num") Long size, Pageable pageable);
}
