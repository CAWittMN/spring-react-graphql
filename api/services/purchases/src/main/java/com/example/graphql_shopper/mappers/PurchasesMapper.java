package com.example.graphql_shopper.mappers;

import com.example.graphql_shopper.dtos.PurchasesDTO;
import com.example.graphql_shopper.dtos.requests.BookPurchaseRequest;
import com.example.graphql_shopper.dtos.requests.PurchaseRequest;
import com.example.graphql_shopper.models.BookPurchase;
import com.example.graphql_shopper.models.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = BookPurchaseMapper.class)
public interface PurchasesMapper {

    PurchasesDTO toDTO(Purchase source);

    List<PurchasesDTO> toDTOList(List<Purchase> source);

    List<Purchase> toEntityList(List<PurchasesDTO> source);

    Purchase toEntity(PurchasesDTO source);
}
