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
