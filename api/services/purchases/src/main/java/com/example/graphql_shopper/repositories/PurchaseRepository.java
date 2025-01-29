package com.example.graphql_shopper.repositories;

import com.example.graphql_shopper.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
