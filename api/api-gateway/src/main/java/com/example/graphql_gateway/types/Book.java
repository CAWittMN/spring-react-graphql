package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;

    private String language;

    private String isbn;

    private String title;

    private LocalDateTime publishedDate;

    private String blurb;

    private Long authorId;

    private Author author;

    private Long publisherId;

    private Publisher publisher;

    private Double price;

    private String genre;

    private Integer amountInStock;

    private Integer amountSold;

    private Float overallRating;

    private List<Review> reviews;

}
