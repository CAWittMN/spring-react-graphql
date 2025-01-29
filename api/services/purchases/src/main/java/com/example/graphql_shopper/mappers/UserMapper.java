package com.example.graphql_shopper.mappers;

import com.example.graphql_shopper.dtos.UserDTO;
import com.example.graphql_shopper.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User source);

    List<UserDTO> toDTOList(List<User> source);

    @Mapping(target = "password", ignore = true)
    User toEntity(UserDTO source);

    @Mapping(target = "password", ignore = true)
    List<User> toEntityList(List<UserDTO> source);
}
