package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewInput {

    private String title;

    private String body;

    private Long rating;

    private Long bookId;

    private Long userId;

    private Boolean isLiked;

    private Boolean isDisliked;

}
