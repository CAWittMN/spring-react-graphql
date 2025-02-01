package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewLike {

    private Long id;

    private Long reviewId;

    private Long userId;

    private Boolean isLiked;

    private Boolean isDisliked;

}
