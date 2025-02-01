package com.example.graphql_books.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // always format the price with two decimal places
    @Column(nullable = false, precision = 19, scale = 2) // Up to 19 digits, 4 decimal places
    private BigDecimal price;

    private String title;

    private String isbn;

    private Long pageCount;


    private Long publisherId;

    private String language;

    @Column(length = 1000)
    private String blurb;

    // format should be yyyy-MM-dd
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishedDate;

    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;


}
