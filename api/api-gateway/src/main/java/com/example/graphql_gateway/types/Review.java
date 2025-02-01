package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private Long id;

    private String title;

    private String body;

    private Long rating;

    private Long bookId;

    private Long userId;

    private String username;

    private List<ReviewLike> likesAndDislikes;

    private LocalDateTime createdAt;

    private Boolean isLiked;

    private Boolean isDisliked;

    private Long totalLikes;

    private Long totalDislikes;

}
