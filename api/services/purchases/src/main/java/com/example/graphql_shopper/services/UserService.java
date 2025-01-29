package com.example.graphql_shopper.services;

import com.example.graphql_shopper.dtos.PurchasesDTO;
import com.example.graphql_shopper.dtos.UserDTO;
import com.example.graphql_shopper.dtos.requests.BookPurchaseRequest;
import com.example.graphql_shopper.dtos.requests.PurchaseRequest;
import com.example.graphql_shopper.enums.PurchaseStatus;
import com.example.graphql_shopper.mappers.PurchasesMapper;
import com.example.graphql_shopper.mappers.UserMapper;
import com.example.graphql_shopper.models.BookPurchase;
import com.example.graphql_shopper.models.Purchase;
import com.example.graphql_shopper.models.User;
import com.example.graphql_shopper.repositories.BookPurchaseRepository;
import com.example.graphql_shopper.repositories.PurchaseRepository;
import com.example.graphql_shopper.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PurchaseRepository purchaseRepository;
    private final UserMapper userMapper;
    private final PurchasesMapper purchasesMapper;

    @Autowired
    public UserService(UserRepository userRepository, PurchaseRepository purchaseRepository,
                       UserMapper userMapper, PurchasesMapper purchasesMapper) {
        this.userRepository = userRepository;
        this.purchaseRepository = purchaseRepository;
        this.userMapper = userMapper;
        this.purchasesMapper = purchasesMapper;
    }

    public List<UserDTO> getUsers() {
        return userMapper.toDTOList(userRepository.findAll());
    }

    public UserDTO getUserById(Long id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found")));
    }

    public UserDTO createUser(UserDTO userDTO) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId()).orElseThrow(() ->
                new RuntimeException("User not found"));
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        return userMapper.toDTO(userRepository.save(existingUser));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<PurchasesDTO> getUserPurchases(Long id) {
        return purchasesMapper.toDTOList(userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found")).getPurchases());
    }

    public PurchasesDTO getPurchaseById(Long id) {
        return purchasesMapper.toDTO(purchaseRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Purchase not found")));
    }

    public PurchasesDTO createPurchase(PurchaseRequest purchaseRequest) {
        User user = userRepository.findById(purchaseRequest.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found"));

        Purchase newPurchase = purchasesMapper.toEntityFromRequest(purchaseRequest);
        newPurchase.setUser(user);

        List<BookPurchase> bookPurchases = purchasesMapper.toEntityListFromRequest(purchaseRequest.getBooks());
        newPurchase.setBookPurchases(bookPurchases);

        return purchasesMapper.toDTO(purchaseRepository.save(newPurchase));
    }

    public PurchasesDTO updatePurchaseStatus(Long id, PurchaseStatus status) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Purchase not found"));
        // Check if status is CANCELLED, and then only allow the update if the purchase status is PENDING or DECLINED
        if (status.equals(PurchaseStatus.CANCELLED) && !purchase.getStatus().equals(PurchaseStatus.PENDING) && !purchase.getStatus().equals(PurchaseStatus.DECLINED)) {
            throw new RuntimeException("Purchase cannot be cancelled");
        }
        // Check if the purchase status is CANCELLED or REFUNDED, and throw an error that the status cannot be updated
        if (purchase.getStatus().equals(PurchaseStatus.CANCELLED) || purchase.getStatus().equals(PurchaseStatus.REFUNDED)) {
            throw new RuntimeException("Purchase status cannot be updated");
        }
        purchase.setStatus(status);
        return purchasesMapper.toDTO(purchaseRepository.save(purchase));
    }

}
