package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    private Long id;

    private Long userId;

    private Double totalAmount;

    private String status;

    private List<BookPurchase> bookPurchases;

    private LocalDateTime purchaseDate;

    private LocalDateTime lastUpdated;

}
