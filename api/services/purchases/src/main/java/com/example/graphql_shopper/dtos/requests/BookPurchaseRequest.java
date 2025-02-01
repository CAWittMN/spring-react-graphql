package com.example.graphql_shopper.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPurchaseRequest {

    private Long bookId;

    private Integer quantity;

    private Double totalPrice;

}
