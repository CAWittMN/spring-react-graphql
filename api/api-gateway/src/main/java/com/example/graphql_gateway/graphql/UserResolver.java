package com.example.graphql_gateway.graphql;

import com.example.graphql_gateway.services.PurchaseService;
import com.example.graphql_gateway.services.ReviewService;
import com.example.graphql_gateway.services.UserService;
import com.example.graphql_gateway.types.Purchase;
import com.example.graphql_gateway.types.Review;
import com.example.graphql_gateway.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserResolver {

    public final UserService userService;
    public final ReviewService reviewService;
    public final PurchaseService purchaseService;

    @Autowired
    public UserResolver(UserService userService, ReviewService reviewService,
                        PurchaseService purchaseService) {
        this.userService = userService;
        this.reviewService = reviewService;
        this.purchaseService = purchaseService;
    }

    @QueryMapping
    public Mono<User> user(@Argument Long id) {
        return userService.getUserById(id);
    }

    @SchemaMapping(typeName = "User", field = "purchases")
    public Flux<Purchase> getPurchases(User user) {
        return purchaseService.getPurchasesByUserId(user.getId());
    }

    @SchemaMapping(typeName = "User", field = "reviews")
    public Flux<Review> getReviews(User user) {
        return reviewService.getReviewsByUserId(user.getId());
    }



}
