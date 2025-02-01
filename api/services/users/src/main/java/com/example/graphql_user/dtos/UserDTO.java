package com.example.graphql_user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String phoneNumber;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private String role;
}
