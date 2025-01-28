package com.example.graphql_authors.repositories;

import com.example.graphql_authors.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE lower(a.firstName) LIKE lower(concat('%', :name, '%')) OR lower(a.lastName) LIKE lower(concat('%', :name, '%'))")
    List<Author> findByName(String name);
}
