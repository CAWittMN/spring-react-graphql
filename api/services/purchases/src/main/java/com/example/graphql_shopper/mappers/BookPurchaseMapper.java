package com.example.graphql_shopper.mappers;

import com.example.graphql_shopper.dtos.BookPurchaseDTO;
import com.example.graphql_shopper.models.BookPurchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookPurchaseMapper {


    BookPurchaseDTO toDTO(BookPurchase source);

    List<BookPurchaseDTO> toDTOList(List<BookPurchase> source);

    BookPurchase toEntity(BookPurchaseDTO source);

    List<BookPurchase> toEntityList(List<BookPurchaseDTO> source);

}
