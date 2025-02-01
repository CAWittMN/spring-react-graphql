package com.example.graphql_user.services;

import com.example.graphql_user.dtos.UserDTO;
import com.example.graphql_user.dtos.UserGraphql;
import com.example.graphql_user.dtos.requests.LoginRequest;
import com.example.graphql_user.mappers.UserMapper;
import com.example.graphql_user.models.User;
import com.example.graphql_user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserGraphql getUserById(Long id) {
        return userMapper.toGraphql(userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found")));
    }

    public UserDTO authenticateUser(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() ->
                new RuntimeException("User not found"));
        if (user.getPassword().equals(loginRequest.getPassword())) {
            return userMapper.toDTO(user);
        } else {
            throw new RuntimeException("Invalid password");
        }
    }

    public UserDTO createUser(LoginRequest newUser) {
        if (userRepository.findByUsername(newUser.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(newUser.getUsername());
       return userMapper.toDTO(userRepository.save(user));
    }

    public UserDTO updateUser(UserDTO userInfo) {
        User existingUser = userRepository.findByUsername(userInfo.getUsername()).orElseThrow(() ->
                new RuntimeException("User not found"));
        User updatedUser = userMapper.toEntity(userInfo);
        updatedUser.setPassword(existingUser.getPassword());
        return userMapper.toDTO(userRepository.save(updatedUser));
    }
}
