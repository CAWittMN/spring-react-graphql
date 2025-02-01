package com.example.graphql_books.controllers;

import com.example.graphql_books.dtos.BookDTO;
import com.example.graphql_books.dtos.requests.FilterParams;
import com.example.graphql_books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/author/{authorId}")
    public List<BookDTO> getBooksByAuthor(@PathVariable Long authorId) {
        return bookService.getBooksByAuthor(authorId);
    }

    @GetMapping("/genre/{genre}")
    public List<BookDTO> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/publisher/{publisherId}")
    public List<BookDTO> getBooksByPublisher(@PathVariable Long publisherId) {
        return bookService.getBooksByPublisher(publisherId);
    }

    @GetMapping("/title/{title}")
    public List<BookDTO> getBooksByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/ids")
    public List<BookDTO> getBooksByIds(@RequestParam List<Long> ids){
        return bookService.getBooksByIds(ids);
    }

    @GetMapping("/filter")
    public List<BookDTO> getBooksByFilter(@ModelAttribute FilterParams params){
        return bookService.getBooksByFilter(params);
    }

    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping
    public BookDTO updateBook(@RequestBody BookDTO bookDTO) {
        return bookService.updateBook(bookDTO);
    }

}
