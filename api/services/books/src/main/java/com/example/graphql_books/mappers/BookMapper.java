package com.example.graphql_books.mappers;

import com.example.graphql_books.dtos.BookDTO;
import com.example.graphql_books.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = GenreMapper.class)
public interface BookMapper {

    @Mapping(target = "genre", source = "genre")
    BookDTO toDTO(Book source);

    Book toEntity(BookDTO source);

    List<Book> toEntityList(List<BookDTO> source);


    @Mapping(target = "genre", source = "genre")
    List<BookDTO> toDTOList(List<Book> source);
}
