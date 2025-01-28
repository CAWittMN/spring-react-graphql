package com.example.graphql_reviews.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long id;

    private String title;

    private String body;

    private Long rating;

    private Long bookId;

    private Long userId;

    private Long likes;

    private Long dislikes;

}
