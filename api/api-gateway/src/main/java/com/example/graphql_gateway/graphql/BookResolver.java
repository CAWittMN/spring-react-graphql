package com.example.graphql_gateway.graphql;

import com.example.graphql_gateway.services.AuthorService;
import com.example.graphql_gateway.services.BookService;
import com.example.graphql_gateway.services.PublisherService;
import com.example.graphql_gateway.services.ReviewService;
import com.example.graphql_gateway.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class BookResolver {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final ReviewService reviewService;

    @Autowired
    public BookResolver(BookService bookService, AuthorService authorService,
                        PublisherService publisherService, ReviewService reviewService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.reviewService = reviewService;
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

}
