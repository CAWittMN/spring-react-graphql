package com.example.graphql_shopper.services;

import com.example.graphql_shopper.dtos.PurchasesDTO;
import com.example.graphql_shopper.enums.PurchaseStatus;
import com.example.graphql_shopper.mappers.BookPurchaseMapper;
import com.example.graphql_shopper.mappers.PurchasesMapper;
import com.example.graphql_shopper.models.BookPurchase;
import com.example.graphql_shopper.models.Purchase;
import com.example.graphql_shopper.repositories.BookPurchaseRepository;
import com.example.graphql_shopper.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final BookPurchaseRepository bookPurchaseRepository;
    private final PurchasesMapper purchasesMapper;
    private final BookPurchaseMapper bookPurchaseMapper;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, BookPurchaseRepository bookPurchaseRepository,
                           PurchasesMapper purchasesMapper, BookPurchaseMapper bookPurchaseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.bookPurchaseRepository = bookPurchaseRepository;
        this.purchasesMapper = purchasesMapper;
        this.bookPurchaseMapper = bookPurchaseMapper;
    }

    public List<PurchasesDTO> getPurchases() {
        return purchasesMapper.toDTOList(purchaseRepository.findAll());
    }

    public PurchasesDTO getPurchaseById(Long id) {
        return purchasesMapper.toDTO(purchaseRepository.findById(id).orElse(null));
    }

    public List<PurchasesDTO> getPurchasesByUser(Long userId) {
        return purchasesMapper.toDTOList(purchaseRepository.findByUserId(userId));
    }

    public Long getSoldCountByBook(Long bookId) {
        // get all book purchases by book id and then sum the quantity property
        return bookPurchaseRepository.findByBookId(bookId)
                .stream()
                .map(BookPurchase::getQuantity)
                .reduce(0, Integer::sum)
                .longValue();
    }

    public PurchasesDTO createPurchase(PurchasesDTO purchaseDTO) {
        Purchase purchase = purchasesMapper.toEntity(purchaseDTO);
        System.out.println(purchase);
        return purchasesMapper.toDTO(purchaseRepository.save(purchasesMapper.toEntity(purchaseDTO)));
    }

}
