package com.example.graphql_publisher.services;

import com.example.graphql_publisher.dtos.PublisherDTO;
import com.example.graphql_publisher.mappers.PublisherMapper;
import com.example.graphql_publisher.models.Publisher;
import com.example.graphql_publisher.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    public List<PublisherDTO> getAllPublishers() {
        return publisherMapper.toDTOList(publisherRepository.findAll());
    }

    public PublisherDTO getPublisherById(Long id) {
        return publisherMapper.toDTO(publisherRepository.findById(id).orElse(null));
    }

}
