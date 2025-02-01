package com.example.graphql_publisher.mappers;

import com.example.graphql_publisher.dtos.PublisherDTO;
import com.example.graphql_publisher.models.Publisher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDTO toDTO(Publisher source);

    Publisher toEntity(PublisherDTO source);

    List<PublisherDTO> toDTOList(List<Publisher> source);

    List<Publisher> toEntityList(List<PublisherDTO> source);
}
