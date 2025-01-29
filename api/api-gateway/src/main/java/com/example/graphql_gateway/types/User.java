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

    private String email;

    private String phoneNumber;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private String country;

    private String role;

    private List<Review> reviews;

    private List<Purchase> purchases;

    private List<Long> purchasedBookIds;

}
