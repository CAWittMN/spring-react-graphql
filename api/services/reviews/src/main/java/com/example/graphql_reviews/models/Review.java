package com.example.graphql_reviews.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private Long rating;

    private Long bookId;

    private Long userId;

    private Boolean isLiked;

    private Boolean isDisliked;

    @OneToMany(mappedBy = "reviewId")
    private List<LikeOrDislike> likesAndDislikes;

}
