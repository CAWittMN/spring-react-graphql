package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    private Integer likes;

    private Integer dislikes;

    private LocalDateTime createdAt;
}
