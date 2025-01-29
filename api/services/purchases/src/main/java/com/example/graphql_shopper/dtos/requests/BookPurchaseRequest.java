package com.example.graphql_shopper.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPurchaseRequest {

    private Long bookId;

    private Integer quantity;

    private Double price;

}
