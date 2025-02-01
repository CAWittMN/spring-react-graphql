package com.example.graphql_gateway.services;

import com.example.graphql_gateway.types.Book;
import com.example.graphql_gateway.types.BookFilterInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BookService {

    @Value("${microservice.book.url}")
    private String bookServiceUrl;

    private final WebClient webClient;

    @Autowired
    public BookService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Flux<Book> getAllBooks() {
        return webClient.get().
                uri(bookServiceUrl)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Book>() {});
    }

    public Mono<Book> getBookById(Long id) {
        return webClient.get()
                .uri(bookServiceUrl + "/{id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Book>() {});
    }

    public Flux<Book> getBooksByAuthor(Long authorId) {
        return webClient.get()
                .uri(bookServiceUrl + "/author/{authorId}", authorId)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Book>() {});
    }

    public Flux<Book> getBooksByGenre(String genre) {
        return webClient.get()
                .uri(bookServiceUrl + "/genre/{genre}", genre)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Book>() {});
    }

    public Flux<Book> getBooksByPublisher(Long publisherId) {
        return webClient.get()
                .uri(bookServiceUrl + "/publisher/{publisherId}", publisherId)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Book>() {});
    }

    public Flux<Book> getBooksByTitle(String title) {
        return webClient.get()
                .uri(bookServiceUrl + "/title/{title}", title)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Book>() {});
    }

    public Flux<Book> getBooksByFilter(BookFilterInput filter) {
        String urlSafeFilterParams = getUrlSafeFilterParams(filter);
        return webClient.get()
                .uri(bookServiceUrl + "/filter" + urlSafeFilterParams)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Book>() {});
    }

    public Flux<Book> getBooksByIds(List<Long> ids) {
        String urlSafeIds = getUrlSafeIds(ids);
        return webClient.get()
                .uri(bookServiceUrl + "/ids" + urlSafeIds)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Book>() {});
    }


    private String getUrlSafeFilterParams(BookFilterInput filter) {
        StringBuilder urlSafeFilterParams = new StringBuilder("?");
        if (filter.getAuthorName() != null) {
            urlSafeFilterParams.append("authorName=").append(filter.getAuthorName()).append("&");
        }
        if (filter.getGenre() != null) {
            urlSafeFilterParams.append("genre=").append(filter.getGenre()).append("&");
        }
        if (filter.getTitle() != null) {
            urlSafeFilterParams.append("title=").append(filter.getTitle()).append("&");
        }
        if (filter.getPublisherName() != null) {
            urlSafeFilterParams.append("publisherName=").append(filter.getPublisherName()).append("&");
        }
        if (filter.getMinPrice() != null) {
            urlSafeFilterParams.append("minPrice=").append(filter.getMinPrice()).append("&");
        }
        if (filter.getMaxPrice() != null) {
            urlSafeFilterParams.append("maxPrice=").append(filter.getMaxPrice()).append("&");
        }
        if (filter.getMinPublishedDate() != null) {
            urlSafeFilterParams.append("minPublishedDate=").append(filter.getMinPublishedDate()).append("&");
        }
        if (filter.getMaxPublishedDate() != null) {
            urlSafeFilterParams.append("maxPublishedDate=").append(filter.getMaxPublishedDate()).append("&");
        }
        if (filter.getMinOverallRating() != null) {
            urlSafeFilterParams.append("minRating=").append(filter.getMinOverallRating()).append("&");
        }
        if (filter.getMaxOverallRating() != null) {
            urlSafeFilterParams.append("maxRating=").append(filter.getMaxOverallRating()).append("&");
        }
        if (filter.getMaxAmountSold() != null) {
            urlSafeFilterParams.append("maxAmountSold=").append(filter.getMaxAmountSold()).append("&");
        }
        if (filter.getMinAmountSold() != null) {
            urlSafeFilterParams.append("minAmountSold=").append(filter.getMinAmountSold()).append("&");
        }
        if (filter.getIsbn() != null) {
            urlSafeFilterParams.append("isbn=").append(filter.getIsbn()).append("&");
        }
        if (filter.getSortBy() != null) {
            urlSafeFilterParams.append("sortBy=").append(filter.getSortBy()).append("&");
        }
        if (filter.getSortOrder() != null) {
            urlSafeFilterParams.append("sortOrder=").append(filter.getSortOrder()).append("&");
        }
        return urlSafeFilterParams.toString();
    }

    private String getUrlSafeIds(List<Long> ids) {
        StringBuilder urlSafeIds = new StringBuilder("?");
        for (Long id : ids) {
            urlSafeIds.append("ids=").append(id).append("&");
        }
        return urlSafeIds.toString();
    }
}
