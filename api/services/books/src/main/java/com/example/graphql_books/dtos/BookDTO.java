package com.example.graphql_books.dtos;

import com.example.graphql_books.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.NestingKind;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;

    private String language;

    private String isbn;

    private String title;

    private LocalDate publishedDate;

    private String blurb;

    private Long pageCount;

    private String synopsis;

    private Long authorId;

    private Long publisherId;

    private Double price;

    private GenreDTO genre;

}
