package com.example.graphql_shopper.dtos.requests;

import com.example.graphql_shopper.enums.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {

    private Long userId;

    private List<BookPurchaseRequest> books;

    private Double total;

    private PurchaseStatus status = PurchaseStatus.PENDING;
}
