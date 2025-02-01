package com.example.graphql_shopper.controllers;

import com.example.graphql_shopper.dtos.PurchasesDTO;
import com.example.graphql_shopper.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<PurchasesDTO> getAllPurchases() {
        return purchaseService.getPurchases();
    }

    @GetMapping("/{id}")
    public PurchasesDTO getPurchaseById(@PathVariable Long id) {
        return purchaseService.getPurchaseById(id);
    }

    @GetMapping("/user/{userId}")
    public List<PurchasesDTO> getPurchasesByUser(@PathVariable Long userId) {
        return purchaseService.getPurchasesByUser(userId);
    }

    @GetMapping("/book/{bookId}/soldCount")
    public Long getSoldCountByBook(@PathVariable Long bookId) {
        return purchaseService.getSoldCountByBook(bookId);
    }

    @PostMapping
    public PurchasesDTO createPurchase(@RequestBody PurchasesDTO purchase) {
        System.out.println(purchase);
        return purchaseService.createPurchase(purchase);
    }
}
