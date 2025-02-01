package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private List<Review> reviews;

    private List<Purchase> purchases;

    private List<Long> purchasedBookIds;

    private List<ReviewLike> reviewLikes;

}
