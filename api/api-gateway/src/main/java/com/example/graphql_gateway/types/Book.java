package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;

    private String language;

    private String isbn;

    private String title;

    private LocalDate publishedDate;

    private String blurb;

    private Long authorId;

    private Author author;

    private Long publisherId;

    private Publisher publisher;

    private Double price;

    private Genre genre;

    private Long pageCount;

    private String synopsis;

    private Long likes;

    private Long dislikes;

//    private Integer amountInStock;

    private Integer amountSold;

    private Float overallRating;

    private List<Review> reviews;

}
