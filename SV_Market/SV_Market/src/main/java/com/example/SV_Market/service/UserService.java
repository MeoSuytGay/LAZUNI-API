package com.example.SV_Market.service;

import com.example.SV_Market.dto.UserDto;
import com.example.SV_Market.entity.User;
import com.example.SV_Market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Other methods...

    public User createUser(UserDto request) {
        User user = new User();
        // Combine firstName and lastName for userName
        String fullName = request.getFirstName() + " " + request.getLastName();
        user.setUserName(fullName);
        // Set password, email, and default role
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRole("USER");  // Default role
        // Set optional fields
        user.setAddress(request.getAddress());
        user.setBalance(0.0);  // Default balance
        user.setCreatedAt(new Date());  // Set created_at date
        // Save user to repository
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    // New method to change the password of a user
    public User updatePassword(String userId, String newPassword) throws Exception {
            if (userId == null || userId.isEmpty()) {
                throw new IllegalArgumentException("The given id must not be null");
            }

        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new Exception("User not found.");
        }

        User user = optionalUser.get();
        user.setPassword(newPassword);  // Update the password
        return userRepository.save(user);  // Save the updated user
    }
}
