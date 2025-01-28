package com.example.graphql_authors.services;

import com.example.graphql_authors.dtos.AuthorDTO;
import com.example.graphql_authors.mappers.AuthorMapper;
import com.example.graphql_authors.models.Author;
import com.example.graphql_authors.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorMapper.toDTOList(authorRepository.findAll());
    }

    public AuthorDTO getAuthorById(Long id) {
        return authorMapper.toDTO(authorRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Author with id " + id + " not found")));
    }

    public List<AuthorDTO> getAuthorsByName(String name) {
        return authorMapper.toDTOList(authorRepository.findByName(name));
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        return authorMapper.toDTO(authorRepository.save(authorMapper.toEntity(authorDTO)));
    }

    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Author existingAuthor = authorRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Author with id " + id + " not found"));
        existingAuthor.setFirstName(authorDTO.getFirstName());
        existingAuthor.setLastName(authorDTO.getLastName());
        return authorMapper.toDTO(authorRepository.save(existingAuthor));
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
