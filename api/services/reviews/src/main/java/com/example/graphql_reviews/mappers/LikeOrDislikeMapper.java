package com.example.graphql_reviews.mappers;

import com.example.graphql_reviews.dtos.LikeOrDislikeDTO;
import com.example.graphql_reviews.models.LikeOrDislike;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LikeOrDislikeMapper {
    LikeOrDislikeDTO toDTO(LikeOrDislike source);

    LikeOrDislike toEntity(LikeOrDislikeDTO source);

    List<LikeOrDislikeDTO> toDTOList(List<LikeOrDislike> source);

    List<LikeOrDislike> toEntityList(List<LikeOrDislikeDTO> source);
}
