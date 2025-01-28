package com.example.graphql_authors.mappers;

import com.example.graphql_authors.dtos.AuthorDTO;
import com.example.graphql_authors.models.Author;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO toDTO(Author source);

    List<AuthorDTO> toDTOList(List<Author> source);

    Author toEntity(AuthorDTO source);
}
