package com.example.graphql_gateway.graphql;

import com.example.graphql_gateway.services.BookService;
import com.example.graphql_gateway.services.PurchaseService;
import com.example.graphql_gateway.services.UserService;
import com.example.graphql_gateway.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class PurchaseResolver {

    private final PurchaseService purchaseService;
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public PurchaseResolver(PurchaseService purchaseService, BookService bookService,
                            UserService userService) {
        this.purchaseService = purchaseService;
        this.bookService = bookService;
        this.userService = userService;
    }

    // Queries

    @QueryMapping
    public Mono<Purchase> purchase(@Argument Long id) {
        return purchaseService.getPurchaseById(id);
    }

    @QueryMapping
    public Flux<Purchase> purchasesByUserId(@Argument Long userId) {
        return purchaseService.getPurchasesByUserId(userId);
    }

    // this needs to iterate over the purchases and in each purchase, iterate over the bookPurchases property and get the bookId
    @QueryMapping
    public Flux<Book> purchasedBooks(@Argument Long userId) {
        List<Long> uniqueIds = purchaseService.getPurchasesByUserId(userId)
                .map(Purchase::getBookPurchases)
                .flatMap(Flux::fromIterable)
                .map(BookPurchase::getBookId)
                .distinct()
                .collectList()
                .blockOptional()
                .orElse(Collections.emptyList());
        return bookService.getBooksByIds(uniqueIds);

    }

    // Schema Mappings

    @SchemaMapping(typeName = "Purchase", field = "user")
    public Mono<User> getUser(Purchase purchase) {
        return userService.getUserById(purchase.getUserId());
    }

    @SchemaMapping(typeName = "Purchase", field = "bookPurchases")
    public List<BookPurchase> getBookPurchases(Purchase purchase) {
        return purchase.getBookPurchases();
    }

    @SchemaMapping(typeName = "BookPurchase", field = "book")
    public Mono<Book> getBook(BookPurchase bookPurchase) {
        return bookService.getBookById(bookPurchase.getBookId());
    }

    // Mutations

    @MutationMapping
    public Mono<Purchase> makePurchase(@Argument PurchaseInput purchaseInput) {
        System.out.println(purchaseInput);
        return purchaseService.createPurchase(purchaseInput);
    }

}
