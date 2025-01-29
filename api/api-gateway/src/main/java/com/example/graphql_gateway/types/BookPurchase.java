package com.example.graphql_gateway.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPurchase {

    private Long id;

    private Long purchaseId;

    private Long bookId;

    private Book book;

    private Long quantity;

    private Double totalPrice;

}
