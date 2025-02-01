package com.example.graphql_gateway.services;

import com.example.graphql_gateway.types.Review;
import com.example.graphql_gateway.types.ReviewInput;
import com.example.graphql_gateway.types.ReviewLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReviewService {

    @Value("${microservice.review.url}")
    private String reviewServiceUrl;

    private final WebClient webClient;

    @Autowired
    public ReviewService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Flux<Review> getReviewsByBookId(Long bookId) {
        return webClient.get()
                .uri(reviewServiceUrl + "/book/{bookId}", bookId)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Review>() {});
    }

    public Flux<Review> getReviewsByUserId(Long userId) {
        return webClient.get()
                .uri(reviewServiceUrl + "/user/{userId}", userId)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Review>() {});
    }

    public Flux<ReviewLike> getReviewLikesByUserId(Long userId) {
        return webClient.get()
                .uri(reviewServiceUrl + "/user/{userId}/likes", userId)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<ReviewLike>() {});
    }

    public Mono<Review> getReviewById(Long id) {
        return webClient.get()
                .uri(reviewServiceUrl + "/{id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Review>() {});
    }

    public Mono<Review> postReview(ReviewInput reviewInput) {
        return webClient.post()
                .uri(reviewServiceUrl)
                .bodyValue(reviewInput)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Review>() {});
    }

    public Mono<Void> deleteReview(Long id) {
        return webClient.delete()
                .uri(reviewServiceUrl + "/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<Review> updateReview(Long id, ReviewInput reviewInput) {
        return webClient.put()
                .uri(reviewServiceUrl + "/{id}", id)
                .bodyValue(reviewInput)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Review>() {});
    }

    public Mono<Boolean> likeOrDislikeReview(ReviewLike reviewLike) {
        return webClient.post()
                .uri(reviewServiceUrl + "/likes-dislikes")
                .bodyValue(reviewLike)
                .retrieve()
                .bodyToMono(Boolean.class);
    }

    public Mono<Double> getOverallRating(Long bookId) {
        return webClient.get()
                .uri(reviewServiceUrl + "/book/{bookId}/rating", bookId)
                .retrieve()
                .bodyToMono(Double.class);
    }

    public Mono<Long> getLikesByBookId(Long bookId) {
        return webClient.get()
                .uri(reviewServiceUrl + "/book/{bookId}/likes", bookId)
                .retrieve()
                .bodyToMono(Long.class);
    }

    public Mono<Long> getDislikesByBookId(Long bookId) {
        return webClient.get()
                .uri(reviewServiceUrl + "/book/{bookId}/dislikes", bookId)
                .retrieve()
                .bodyToMono(Long.class);
    }
}
