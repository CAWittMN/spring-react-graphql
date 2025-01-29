package com.example.graphql_gateway.services;

import com.example.graphql_gateway.types.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorService {

    @Value("${microservice.author.url}")
    private String authorServiceUrl;

    private final WebClient webClient;

    @Autowired
    public AuthorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @QueryMapping
    public Flux<Author> authors() {
        return webClient.get()
                .uri(authorServiceUrl)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Author>() {});
    }

    public Mono<Author> getAuthorById(Long id) {
        return webClient.get()
                .uri(authorServiceUrl + "/{id}", id)
                .retrieve()
                .bodyToMono(Author.class);
    }

}
