package com.example.graphql_publisher.repositories;

import com.example.graphql_publisher.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.concurrent.Flow;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
