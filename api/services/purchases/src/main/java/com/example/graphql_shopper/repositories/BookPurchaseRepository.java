package com.example.graphql_shopper.repositories;

import com.example.graphql_shopper.models.BookPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookPurchaseRepository extends JpaRepository<BookPurchase, Long> {
    // write a query that finds each book purchase by the book id, then adds together all the quantities of the book purchases
    @Query("SELECT SUM(bp.quantity) FROM BookPurchase bp WHERE bp.bookId = :bookId")
    Long quantitySumByBookId(Long bookId);

    List<BookPurchase> findByBookId(Long bookId);
}
