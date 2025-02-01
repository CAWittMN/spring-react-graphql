package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookFilterInput {
    private String title;
    private String authorName;
    private String publisherName;
    private String genre;
    private String isbn;
    private String language;
    private Integer minPages;
    private Integer maxPages;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer minAmountSold;
    private Integer maxAmountSold;
    private Float minOverallRating;
    private Float maxOverallRating;
    private LocalDate minPublishedDate;
    private LocalDate maxPublishedDate;
    private String sortBy;
    private String sortOrder;
}
