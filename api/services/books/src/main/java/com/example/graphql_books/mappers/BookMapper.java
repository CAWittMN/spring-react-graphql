package com.example.graphql_books.mappers;

import com.example.graphql_books.dtos.BookDTO;
import com.example.graphql_books.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "publisherName", source = "publisher.name")
    @Mapping(target = "publisherId", source = "publisher.id")
    @Mapping(target = "genre", source = "genre.name")
    @Mapping(target = "genreId", source = "genre.id")
    BookDTO toDTO(Book source);

    @Mapping(target = "publisherName", source = "publisher.name")
    @Mapping(target = "publisherId", source = "publisher.id")
    @Mapping(target = "genre", source = "genre.name")
    @Mapping(target = "genreId", source = "genre.id")
    List<BookDTO> toDTOList(List<Book> source);
}
