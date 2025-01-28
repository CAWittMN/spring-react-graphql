package com.example.graphql_authors.controllers;

import com.example.graphql_authors.dtos.AuthorDTO;
import com.example.graphql_authors.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    AuthorDTO getAuthorById(Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/name/{name}")
    List<AuthorDTO> getAuthorsByName(@PathVariable String name) {
        return authorService.getAuthorsByName(name);
    }

    @PostMapping
    AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.createAuthor(authorDTO);
    }

    @PutMapping("/{id}")
    AuthorDTO updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        return authorService.updateAuthor(id, authorDTO);
    }

    @DeleteMapping("/{id}")
    void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

}
