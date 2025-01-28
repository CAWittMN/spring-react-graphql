package com.example.graphql_reviews.mappers;

import com.example.graphql_reviews.dtos.ReviewDTO;
import com.example.graphql_reviews.models.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDTO toDTO(Review source);

    List<ReviewDTO> toDTOList(List<Review> source);

    Review toEntity(ReviewDTO source);

    List<Review> toEntityList(List<ReviewDTO> source);
}
