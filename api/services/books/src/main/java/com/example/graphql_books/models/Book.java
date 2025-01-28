package com.example.graphql_books.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // always format the price with two decimal places
    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double price;

    private String title;

    private Long pageCount;

    private String synopsis;

    private String blurb;

    @Column(name = "author_id")
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;


}
