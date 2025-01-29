package com.example.graphql_gateway.graphql;

import com.example.graphql_gateway.services.AuthorService;
import com.example.graphql_gateway.types.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class AuthorResolver {

    private final AuthorService authorService;

    @Autowired
    public AuthorResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public Mono<Author> author(@Argument Long id) {
        return authorService.getAuthorById(id);
    }

    @QueryMapping
    public Flux<Author> authors() {
        return authorService.authors();
    }
}
