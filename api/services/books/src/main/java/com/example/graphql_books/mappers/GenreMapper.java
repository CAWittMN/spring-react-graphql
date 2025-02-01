package com.example.graphql_books.mappers;

import com.example.graphql_books.dtos.GenreDTO;
import com.example.graphql_books.models.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDTO toDTO(Genre source);

    Genre toEntity(GenreDTO source);

    List<GenreDTO> toDTOList(List<Genre> source);

    List<Genre> toEntityList(List<GenreDTO> source);
}
