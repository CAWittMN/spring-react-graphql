package com.example.graphql_user.mappers;

import com.example.graphql_user.dtos.UserDTO;
import com.example.graphql_user.dtos.UserGraphql;
import com.example.graphql_user.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User source);

    User toEntity(UserDTO source);

    UserGraphql toGraphql(User source);
}
