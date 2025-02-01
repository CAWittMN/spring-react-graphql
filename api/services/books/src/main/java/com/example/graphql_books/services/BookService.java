package com.example.graphql_books.services;

import com.example.graphql_books.dtos.BookDTO;
import com.example.graphql_books.dtos.requests.FilterParams;
import com.example.graphql_books.mappers.BookMapper;
import com.example.graphql_books.models.Book;
import com.example.graphql_books.repositories.BookRepository;
import com.example.graphql_books.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, GenreRepository genreRepository,
                        BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDTO> getBooks() {
        return bookMapper.toDTOList(bookRepository.findAll());
    }

    public BookDTO getBookById(Long id) {
        return bookMapper.toDTO(bookRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Book not found")));
    }

    public List<BookDTO> getBooksByAuthor(Long authorId) {
        return bookMapper.toDTOList(bookRepository.findByAuthorId(authorId).orElseThrow(() ->
                new RuntimeException("No books found for the given author")));
    }

    public List<BookDTO> getBooksByGenre(String genre) {
        return bookMapper.toDTOList(bookRepository.findByGenreName(genre).orElseThrow(() ->
                new RuntimeException("No books found for the given genre")));
    }

    public List<BookDTO> getBooksByPublisher(Long publisherId) {
        return bookMapper.toDTOList(bookRepository.findByPublisherId(publisherId).orElseThrow(() ->
                new RuntimeException("No books found for the given publisher")));
    }

    public List<BookDTO> getBooksByTitle(String title) {
        return bookMapper.toDTOList(bookRepository.findByTitle(title).orElseThrow(() ->
                new RuntimeException("No books found for the given title")));
    }

    public List<BookDTO> getBooksByIds(List<Long> ids) {
        return bookMapper.toDTOList(bookRepository.findAllById(ids));
    }


    public List<BookDTO> getBooksByFilter(FilterParams params) {
        return bookMapper.toDTOList(bookRepository.findByFilter(params).orElseThrow(() ->
                new RuntimeException("No books found with the given filter")));
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        book.setGenre(genreRepository.findById(bookDTO.getGenre().getId()).orElseThrow(() ->
                new RuntimeException("Genre not found")));
        return bookMapper.toDTO(bookRepository.save(book));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookDTO updateBook(BookDTO bookDTO) {
        Book book = bookRepository.findById(bookDTO.getId()).orElseThrow(() ->
                new RuntimeException("Book not found"));
        book = bookMapper.toEntity(bookDTO);
        book.setGenre(genreRepository.findById(bookDTO.getGenre().getId()).orElseThrow(() ->
                new RuntimeException("Genre not found")));
        return bookMapper.toDTO(bookRepository.save(book));
    }

}
