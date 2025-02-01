package com.example.graphql_shopper.dtos;

import com.example.graphql_shopper.enums.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasesDTO {

    private Long id;

    private Long userId;

    private BigDecimal totalAmount;

    private List<BookPurchaseDTO> bookPurchases;

    private LocalDateTime purchaseDate;

    private LocalDateTime lastUpdated;

    private PurchaseStatus status = PurchaseStatus.PENDING;

}
