package com.example.graphql_shopper.mappers;

import com.example.graphql_shopper.dtos.PurchasesDTO;
import com.example.graphql_shopper.dtos.requests.BookPurchaseRequest;
import com.example.graphql_shopper.dtos.requests.PurchaseRequest;
import com.example.graphql_shopper.models.BookPurchase;
import com.example.graphql_shopper.models.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchasesMapper {

    @Mapping(target = "bookIds", expression = "java(source.getBookPurchases().stream().map(bookPurchase -> bookPurchase.getBookId()).toList())")
    @Mapping(target = "userId", source = "user.id")
    PurchasesDTO toDTO(Purchase source);

    @Mapping(target = "bookIds", expression = "java(source.getBookPurchases().stream().map(bookPurchase -> bookPurchase.getBookId()).toList())")
    @Mapping(target = "userId", source = "user.id")
    List<PurchasesDTO> toDTOList(List<Purchase> source);

    List<BookPurchase> toEntityListFromRequest(List<BookPurchaseRequest> source);

    @Mapping(target = "bookPurchases", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    Purchase toEntityFromRequest(PurchaseRequest source);
}
