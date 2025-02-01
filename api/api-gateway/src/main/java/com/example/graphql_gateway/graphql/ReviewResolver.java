package com.example.graphql_gateway.graphql;

import com.example.graphql_gateway.services.BookService;
import com.example.graphql_gateway.services.ReviewService;
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

import java.util.List;

@Controller
public class ReviewResolver {

    private final ReviewService reviewService;
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public ReviewResolver(ReviewService reviewService, BookService bookService,
                          UserService userService) {
        this.reviewService = reviewService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @QueryMapping
    public Flux<Review> reviewsByBookId(@Argument Long bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }

    @QueryMapping
    public Flux<Review> userReviews(@Argument Long userId) {
        return reviewService.getReviewsByUserId(userId);
    }

    @SchemaMapping(typeName = "Review", field = "book")
    public Mono<Book> getBook(Review review) {
        return bookService.getBookById(review.getBookId());
    }

    @SchemaMapping(typeName = "Review", field = "user")
    public Mono<User> getUser(Review review) {
        return userService.getUserById(review.getUserId());
    }

    @SchemaMapping(typeName = "Review", field = "likesAndDislikes")
    public List<ReviewLike> getLikesAndDislikes(Review review) {
        return review.getLikesAndDislikes();
    }

    @SchemaMapping(typeName = "Review", field = "totalLikes")
    public Long getTotalLikes(Review review) {
        return review.getLikesAndDislikes().stream().filter(ReviewLike::getIsLiked).count();
    }

    @SchemaMapping(typeName = "Review", field = "totalDislikes")
    public Long getTotalDislikes(Review review) {
        return review.getLikesAndDislikes().stream().filter(like -> !like.getIsLiked()).count();
    }


    @MutationMapping
    public Mono<Review> postReview(@Argument ReviewInput reviewInput) {
        // print reviewInput
        System.out.println(reviewInput);
        return reviewService.postReview(reviewInput);
    }

    @MutationMapping
    public Mono<Boolean> likeOrDislikeReview(@Argument ReviewLike likeOrDislike) {
        return reviewService.likeOrDislikeReview(likeOrDislike);
    }
}
