package com.example.graphql_reviews.repositories;

import com.example.graphql_reviews.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByBookId(Long bookId);

    Optional<Review> findByUserIdAndBookId(Long userId, Long bookId);

    List<Review> findByUserId(Long userId);
}
