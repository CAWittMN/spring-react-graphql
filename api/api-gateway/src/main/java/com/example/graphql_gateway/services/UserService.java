package com.example.graphql_gateway.services;

import com.example.graphql_gateway.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Value("${microservice.user.url}")
    private String userServiceUrl;

    private final WebClient webClient;

    @Autowired
    public UserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<User> getUserById(Long id) {
        return webClient.get()
                .uri(userServiceUrl + "/{id}", id)
                .retrieve()
                .bodyToMono(User.class);
    }

}
