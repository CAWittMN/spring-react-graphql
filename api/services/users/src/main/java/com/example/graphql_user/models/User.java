package com.example.graphql_user.models;

import com.example.graphql_user.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"users\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String username;

    private String phoneNumber;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.CUSTOMER;

}