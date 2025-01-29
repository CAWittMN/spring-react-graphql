package com.example.graphql_shopper.repositories;

import com.example.graphql_shopper.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
