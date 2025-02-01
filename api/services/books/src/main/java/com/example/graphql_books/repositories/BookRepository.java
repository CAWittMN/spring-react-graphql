package com.example.graphql_books.repositories;

import com.example.graphql_books.dtos.requests.FilterParams;
import com.example.graphql_books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    // find all by like title with no case sensitivity
    Optional<List<Book>> findByTitleContainingIgnoreCase(String title);

    // build a query based on the filter parameters. Some params may be null, so check if the param is not null before adding it to the query.
    // also note that author, genre, and publisher are other tables so a join is needed for these fields
    @Query("SELECT b FROM Book b " +
            "LEFT JOIN b.genre g " +
            "WHERE (:#{#params.title} IS NULL OR b.title LIKE %:#{#params.title}%) " +
            "AND (:#{#params.genre} IS NULL OR g.name LIKE %:#{#params.genre}%) " +
            "AND (:#{#params.pageCount} IS NULL OR b.pageCount = :#{#params.pageCount})")
    Optional<List<Book>> findByFilter(FilterParams params);

    Optional<List<Book>> findByAuthorId(Long authorId);

    Optional<List<Book>> findByGenreName(String genre);

    Optional<List<Book>> findByPublisherId(Long publisherId);

    // find by like title not case sensitive
    Optional<List<Book>> findByTitle(String title);

}
