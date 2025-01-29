package com.example.graphql_shopper.repositories;

import com.example.graphql_shopper.models.BookPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPurchaseRepository extends JpaRepository<BookPurchase, Long> {
}
