package com.example.graphql_reviews.services;

import com.example.graphql_reviews.dtos.ReviewDTO;
import com.example.graphql_reviews.mappers.ReviewMapper;
import com.example.graphql_reviews.models.Review;
import com.example.graphql_reviews.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDTO> getReviews() {
        return reviewMapper.toDTOList(reviewRepository.findAll());
    }

    public List<ReviewDTO> getReviewsByBookId(Long bookId) {
        return reviewMapper.toDTOList(reviewRepository.findByBookId(bookId));
    }

    public ReviewDTO getReviewById(Long id) {
        return reviewMapper.toDTO(reviewRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Review not found")));
    }

    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        return reviewMapper.toDTO(reviewRepository.save(reviewMapper.toEntity(reviewDTO)));
    }

    public ReviewDTO updateReview(ReviewDTO reviewDTO) {
        Review existingReview = reviewRepository.findById(reviewDTO.getId()).orElseThrow(() ->
                new RuntimeException("Review not found"));
        existingReview.setRating(reviewDTO.getRating());
        existingReview.setTitle(reviewDTO.getTitle());
        existingReview.setBody(reviewDTO.getBody());
        return reviewMapper.toDTO(reviewRepository.save(existingReview));
    }

    public void adjustLikesOrDislikes(Long id, String type, int adjustment) {
        Review existingReview = reviewRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Review not found"));
        if (type.equals("likes")) {
            existingReview.setLikes(existingReview.getLikes() + adjustment);
        } else if (type.equals("dislikes")) {
            existingReview.setDislikes(existingReview.getDislikes() + adjustment);
        } else {
            throw new RuntimeException("Invalid adjustment type");
        }
        reviewRepository.save(existingReview);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
