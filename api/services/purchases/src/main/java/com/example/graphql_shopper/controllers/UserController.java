package com.example.graphql_shopper.controllers;

import com.example.graphql_shopper.dtos.PurchasesDTO;
import com.example.graphql_shopper.dtos.UserDTO;
import com.example.graphql_shopper.dtos.requests.PurchaseRequest;
import com.example.graphql_shopper.enums.PurchaseStatus;
import com.example.graphql_shopper.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDTO createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping
    public UserDTO updateUser(UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // Purchases

    @GetMapping("/purchases/{id}")
    public List<PurchasesDTO> getUserPurchases(@PathVariable Long id) {
        return userService.getUserPurchases(id);
    }

    @GetMapping("/purchase/{id}")
    public PurchasesDTO getPurchaseById(@PathVariable Long id) {
        return userService.getPurchaseById(id);
    }

    @PostMapping("/purchase")
    public PurchasesDTO createPurchase(@RequestBody PurchaseRequest purchaseRequest) {
        return userService.createPurchase(purchaseRequest);
    }

    @PatchMapping("/purchase/{id}/{status}")
    public PurchasesDTO updatePurchase(@PathVariable Long id, @PathVariable PurchaseStatus status) {
        return userService.updatePurchaseStatus(id, status);
    }

}
