package com.example.graphql_books.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterParams {
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private Long pageCount;
}
