package com.example.graphql_books.services;

import com.example.graphql_books.dtos.BookDTO;
import com.example.graphql_books.dtos.requests.FilterParams;
import com.example.graphql_books.mappers.BookMapper;
import com.example.graphql_books.models.Book;
import com.example.graphql_books.repositories.BookRepository;
import com.example.graphql_books.repositories.GenreRepository;
import com.example.graphql_books.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final PublisherRepository publisherRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, GenreRepository genreRepository,
                       PublisherRepository publisherRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.publisherRepository = publisherRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDTO> getBooks() {
        return bookMapper.toDTOList(bookRepository.findAll());
    }

    public BookDTO getBookById(Long id) {
        return bookMapper.toDTO(bookRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Book not found")));
    }


    public List<BookDTO> getBooksByFilter(FilterParams params) {
        return bookMapper.toDTOList(bookRepository.findByFilter(params).orElseThrow(() ->
                new RuntimeException("No books found with the given filter")));
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPageCount(bookDTO.getPageCount());
        book.setSynopsis(bookDTO.getSynopsis());
        book.setBlurb(bookDTO.getBlurb());
        book.setAuthorId(bookDTO.getAuthorId());
        book.setPublisher(publisherRepository.findById(bookDTO.getPublisherId()).orElseThrow(() ->
                new RuntimeException("Publisher not found")));
        book.setGenre(genreRepository.findByName(bookDTO.getGenre()).orElseThrow(() ->
                new RuntimeException("Genre not found")));
        return bookMapper.toDTO(bookRepository.save(book));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookDTO updateBook(BookDTO bookDTO) {
        Book book = bookRepository.findById(bookDTO.getId()).orElseThrow(() ->
                new RuntimeException("Book not found"));
        book.setTitle(bookDTO.getTitle());
        book.setPageCount(bookDTO.getPageCount());
        book.setSynopsis(bookDTO.getSynopsis());
        book.setBlurb(bookDTO.getBlurb());
        book.setAuthorId(bookDTO.getAuthorId());
        book.setPublisher(publisherRepository.findById(bookDTO.getPublisherId()).orElseThrow(() ->
                new RuntimeException("Publisher not found")));
        book.setGenre(genreRepository.findById(bookDTO.getGenreId()).orElseThrow(() ->
                new RuntimeException("Genre not found")));
        return bookMapper.toDTO(bookRepository.save(book));
    }

}
