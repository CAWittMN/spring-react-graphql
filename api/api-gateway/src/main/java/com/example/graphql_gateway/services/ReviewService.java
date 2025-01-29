package com.example.graphql_gateway.services;

import com.example.graphql_gateway.types.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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
}
