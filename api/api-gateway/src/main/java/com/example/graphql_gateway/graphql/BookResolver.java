package com.example.graphql_gateway.graphql;

import com.example.graphql_gateway.services.*;
import com.example.graphql_gateway.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class BookResolver {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final ReviewService reviewService;
    private final PurchaseService purchaseService;

    @Autowired
    public BookResolver(BookService bookService, AuthorService authorService,
                        PublisherService publisherService, ReviewService reviewService,
                        PurchaseService purchaseService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.reviewService = reviewService;
        this.purchaseService = purchaseService;
    }

    @QueryMapping
    public Flux<Book> books() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Mono<Book> book(@Argument Long id) {
        return bookService.getBookById(id);
    }

    @QueryMapping
    public Flux<Book> booksByAuthor(@Argument Long authorId) {
        return bookService.getBooksByAuthor(authorId);
    }

    @QueryMapping
    public Flux<Book> booksByGenre(@Argument String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @QueryMapping
    public Flux<Book> booksByPublisher(@Argument Long publisherId) {
        return bookService.getBooksByPublisher(publisherId);
    }

    @QueryMapping
    public Flux<Book> booksByTitle(@Argument String title) {
        return bookService.getBooksByTitle(title);
    }

    @QueryMapping
    public Flux<Book> booksByFilter(@Argument BookFilterInput filter) {
        return bookService.getBooksByFilter(filter);
    }


    @SchemaMapping(typeName = "Book", field = "author")
    public Mono<Author> getAuthor(Book book) {
        return authorService.getAuthorById(book.getAuthorId());
    }

    @SchemaMapping(typeName = "Book", field = "publisher")
    public Mono<Publisher> getPublisher(Book book) {
        return publisherService.getPublisherById(book.getPublisherId());
    }

    @SchemaMapping(typeName = "Book", field = "reviews")
    public Flux<Review> getReviews(Book book) {
        return reviewService.getReviewsByBookId(book.getId());
    }

    @SchemaMapping(typeName = "Book", field = "amountSold")
    public Mono<Integer> getAmountSold(Book book) {
        return purchaseService.getAmountSold(book.getId());
    }

    @SchemaMapping(typeName = "Book", field = "overallRating")
    public Mono<Double> getOverallRating(Book book) {
        return reviewService.getOverallRating(book.getId());
    }

    @SchemaMapping(typeName = "Book", field = "genre")
    public Genre getGenre(Book book) {
        return book.getGenre();
    }

    @SchemaMapping(typeName = "Book", field = "likes")
    // get all reviews by book id and then sum the number of isLiked = true
    public Mono<Long> getLikes(Book book) {
        return reviewService.getLikesByBookId(book.getId());
    }

    @SchemaMapping(typeName = "Book", field = "dislikes")
    // get all reviews by book id and then sum the number of isLiked = false
    public Mono<Long> getDislikes(Book book) {
        return reviewService.getDislikesByBookId(book.getId());
    }
}
