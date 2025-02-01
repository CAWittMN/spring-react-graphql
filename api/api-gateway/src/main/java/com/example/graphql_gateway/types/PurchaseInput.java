package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseInput {

    private Long userId;

    List<BookPurchaseInput> bookPurchases;

    private Double totalAmount;

}
