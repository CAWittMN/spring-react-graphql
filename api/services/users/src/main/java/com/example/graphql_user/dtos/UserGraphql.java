package com.example.graphql_user.dtos;

import com.example.graphql_user.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGraphql {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private UserRole role;
}
