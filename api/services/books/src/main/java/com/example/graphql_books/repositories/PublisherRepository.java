package com.example.graphql_books.repositories;

import com.example.graphql_books.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
