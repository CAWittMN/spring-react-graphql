package com.example.graphql_reviews.services;

import com.example.graphql_reviews.dtos.LikeOrDislikeDTO;
import com.example.graphql_reviews.dtos.ReviewDTO;
import com.example.graphql_reviews.mappers.LikeOrDislikeMapper;
import com.example.graphql_reviews.mappers.ReviewMapper;
import com.example.graphql_reviews.models.LikeOrDislike;
import com.example.graphql_reviews.models.Review;
import com.example.graphql_reviews.repositories.LikeOrDislikeRepository;
import com.example.graphql_reviews.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final LikeOrDislikeRepository likeRepository;
    private final ReviewMapper reviewMapper;
    private final LikeOrDislikeMapper likeMapper;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, LikeOrDislikeRepository likeRepository,
                         ReviewMapper reviewMapper, LikeOrDislikeMapper likeMapper) {
        this.reviewRepository = reviewRepository;
        this.likeRepository = likeRepository;
        this.reviewMapper = reviewMapper;
        this.likeMapper = likeMapper;
    }

    public List<ReviewDTO> getReviews() {
        return reviewMapper.toDTOList(reviewRepository.findAll());
    }

    public List<ReviewDTO> getReviewsByBookId(Long bookId) {
        return reviewMapper.toDTOList(reviewRepository.findByBookId(bookId));
    }

    public Double getOverallBookRating(Long bookId) {
        List<Review> reviews = reviewRepository.findByBookId(bookId);
        return reviews.stream().mapToDouble(Review::getRating).average().orElse(0);
    }

    public List<ReviewDTO> getReviewsByUserId(Long userId) {
        return reviewMapper.toDTOList(reviewRepository.findByUserId(userId));
    }

    public ReviewDTO getReviewById(Long id) {
        return reviewMapper.toDTO(reviewRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Review not found")));
    }

    public List<LikeOrDislikeDTO> getReviewLikesByUserId(Long userId) {
        return likeMapper.toDTOList(likeRepository.findByUserId(userId).orElseThrow(() ->
                new RuntimeException("Likes not found")));
    }

    public Long getTotalBookLikesById(Long bookId) {
        List<Review> reviews = reviewRepository.findByBookId(bookId);
        return reviews.stream().filter(Review::getIsLiked).count();
    }


    public Long getTotalBookDislikesById(Long bookId) {
        List<Review> reviews = reviewRepository.findByBookId(bookId);
        return reviews.stream().filter(Review::getIsDisliked).count();
    }

    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        // check if the user has already reviewed the book
        if (reviewRepository.findByUserIdAndBookId(reviewDTO.getUserId(), reviewDTO.getBookId()).isPresent()) {
            throw new RuntimeException("User has already reviewed this book");
        }
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

    public void adjustLikesOrDislikes(LikeOrDislikeDTO likeOrDislike) {
        Review existingReview = reviewRepository.findById(likeOrDislike.getReviewId()).orElseThrow(() ->
                new RuntimeException("Review not found"));
        LikeOrDislike existingLike = likeRepository.findByReviewIdAndUserId(likeOrDislike.getReviewId(),
                likeOrDislike.getUserId()).orElseGet(() -> likeRepository.save(likeMapper.toEntity(likeOrDislike)));
        // check if the existing like is the same as the incoming like, if not, then update the existing like and save
        if (existingLike.getIsLiked() != likeOrDislike.getIsLiked()) {
            existingLike.setIsLiked(likeOrDislike.getIsLiked());
            existingLike.setIsDisliked(likeOrDislike.getIsDisliked());
            likeRepository.save(existingLike);
            // update the review's likes and dislikes
        } else if (likeOrDislike.getIsLiked() == likeOrDislike.getIsDisliked()) {
            likeRepository.delete(existingLike);
        }
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
