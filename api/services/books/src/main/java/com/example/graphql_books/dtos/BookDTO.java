package com.example.graphql_books.dtos;

import com.example.graphql_books.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;

    private Double price;

    private String title;

    private Long pageCount;

    private String synopsis;

    private String blurb;

    private Long authorId;

    private Long publisherId;

    private String publisherName;

    private String genre;

    private Long genreId;


}
