package com.example.graphql_gateway.services;

import com.example.graphql_gateway.types.Purchase;
import com.example.graphql_gateway.types.PurchaseInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PurchaseService {

    @Value("${microservice.purchase.url}")
    private String purchaseServiceUrl;

    private final WebClient webClient;

    @Autowired
    public PurchaseService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<Purchase> getPurchaseById(Long id) {
        return webClient.get()
                .uri(purchaseServiceUrl + "/{id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Purchase>() {});
    }

    public Flux<Purchase> getPurchasesByUserId(Long userId) {
        return webClient.get()
                .uri(purchaseServiceUrl + "/user/{userId}", userId)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Purchase>() {});
    }

    public Mono<Purchase> createPurchase(PurchaseInput purchase) {
        return webClient.post()
                .uri(purchaseServiceUrl)
                .body(Mono.just(purchase), Purchase.class)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Purchase>() {});
    }

    public Mono<Purchase> updatePurchase(Long id, Purchase purchase) {
        return webClient.put()
                .uri(purchaseServiceUrl + "/{id}", id)
                .body(Mono.just(purchase), Purchase.class)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Purchase>() {});
    }

    public Mono<Void> cancelPurchase(Long id) {
        return webClient.patch()
                .uri(purchaseServiceUrl + "cancel/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<Integer> getAmountSold(Long bookId) {
        return webClient.get()
                .uri(purchaseServiceUrl + "/book/{bookId}/soldCount", bookId)
                .retrieve()
                .bodyToMono(Integer.class);
    }

    public Flux<Long> getPurchasedBookIdsByUserId(Long userId) {
        return webClient.get()
                .uri(purchaseServiceUrl + "/user/{userId}/bookIds", userId)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Long>() {});
    }
}
