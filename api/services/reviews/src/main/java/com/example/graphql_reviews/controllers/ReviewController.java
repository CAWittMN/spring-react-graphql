package com.example.graphql_reviews.controllers;

import com.example.graphql_reviews.dtos.ReviewDTO;
import com.example.graphql_reviews.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.getReviews();
    }

    @GetMapping("/book/{bookId}")
    public List<ReviewDTO> getReviewsByBookId(@PathVariable Long bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }

    @GetMapping("/{id}")
    public ReviewDTO getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public ReviewDTO createReview(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.createReview(reviewDTO);
    }

    @PutMapping
    public ReviewDTO updateReview(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.updateReview(reviewDTO);
    }

    @PatchMapping("/likes-dislikes/{id}/{type}/{adjustment}")
    public void adjustLikesOrDislikes(@PathVariable Long id, @PathVariable String type, @PathVariable int adjustment) {
        reviewService.adjustLikesOrDislikes(id, type, adjustment);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }


}
