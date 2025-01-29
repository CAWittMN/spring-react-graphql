package com.example.graphql_shopper.dtos;

import com.example.graphql_shopper.enums.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasesDTO {

    private Long id;

    private List<Long> bookIds;

    private Long userId;

    private Double total;

    private PurchaseStatus status;

}
