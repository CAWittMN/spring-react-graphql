package com.example.graphql_reviews.repositories;

import com.example.graphql_reviews.models.LikeOrDislike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeOrDislikeRepository extends JpaRepository<LikeOrDislike, Long> {
    Optional<LikeOrDislike> findByReviewIdAndUserId(Long reviewId, Long userId);
    Optional<List<LikeOrDislike>> findByUserId(Long userId);
}
