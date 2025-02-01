package com.example.graphql_shopper.dtos;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookPurchaseDTO {

    private Long id;

    private Long bookId;

    private Long quantity;

    private BigDecimal totalPrice;

}
