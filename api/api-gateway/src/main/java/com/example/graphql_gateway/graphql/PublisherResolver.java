package com.example.graphql_gateway.graphql;

import com.example.graphql_gateway.services.PublisherService;
import com.example.graphql_gateway.types.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class PublisherResolver {

    private final PublisherService publisherService;

    @Autowired
    public PublisherResolver(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @QueryMapping
    public Mono<Publisher> publisher(@Argument Long id) {
        return publisherService.getPublisherById(id);
    }

    @QueryMapping
    public Flux<Publisher> publishers() {
        return publisherService.getAllPublishers();
    }

}
