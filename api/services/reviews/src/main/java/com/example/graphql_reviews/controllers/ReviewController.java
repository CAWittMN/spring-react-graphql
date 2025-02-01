package com.example.graphql_reviews.controllers;

import com.example.graphql_reviews.dtos.LikeOrDislikeDTO;
import com.example.graphql_reviews.dtos.ReviewDTO;
import com.example.graphql_reviews.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
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

    @GetMapping("/user/{userId}")
    public List<ReviewDTO> getReviewsByUserId(@PathVariable Long userId) {
        return reviewService.getReviewsByUserId(userId);
    }

    @GetMapping("/user/{userId}/likes")
    public List<LikeOrDislikeDTO> getReviewLikesByUserId(@PathVariable Long userId) {
        return reviewService.getReviewLikesByUserId(userId);
    }

    @GetMapping("/book/{bookId}/rating")
    public Double getOverallBookRating(@PathVariable Long bookId) {
        return reviewService.getOverallBookRating(bookId);
    }

    @GetMapping("/book/{bookId}/likes")
    public Long getTotalBookLikesById(@PathVariable Long bookId) {
        return reviewService.getTotalBookLikesById(bookId);
    }

    @GetMapping("/book/{bookId}/dislikes")
    public Long getTotalBookDislikesById(@PathVariable Long bookId) {
        return reviewService.getTotalBookDislikesById(bookId);
    }

    @PostMapping
    public ReviewDTO createReview(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.createReview(reviewDTO);
    }

    @PutMapping
    public ReviewDTO updateReview(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.updateReview(reviewDTO);
    }

    @PostMapping("/likes-dislikes")
    public void adjustLikesOrDislikes(@RequestBody LikeOrDislikeDTO like) {
        reviewService.adjustLikesOrDislikes(like);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }


}
