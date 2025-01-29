package com.example.graphql_gateway.services;

import com.example.graphql_gateway.types.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PublisherService {

    @Value("${microservice.publisher.url}")
    private String publisherServiceUrl;

    private final WebClient webClient;

    @Autowired
    public PublisherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<Publisher> getPublisherById(Long id) {
        return webClient.get()
                .uri(publisherServiceUrl + "/{id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Publisher>() {});
    }

    public Flux<Publisher> getAllPublishers() {
        return webClient.get()
                .uri(publisherServiceUrl)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Publisher>() {});
    }

}
