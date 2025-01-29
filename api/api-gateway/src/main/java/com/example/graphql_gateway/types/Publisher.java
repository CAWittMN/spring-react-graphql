package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    private Long id;

    private String name;

    private String address;

    private String city;

    private String state;

    private String zip;

    private String country;

    private String phoneNumber;

    private String email;

}
