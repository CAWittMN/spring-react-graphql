package com.example.graphql_reviews.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeOrDislikeDTO {

    private Long id;

    private Long reviewId;

    private Long userId;

    private Boolean isLiked;

    private Boolean isDisliked;
}
