package com.example.coinapp.controller;

import com.example.coinapp.dto.UserDTO;
import com.example.coinapp.entity.User;
import com.example.coinapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public User createUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMobile(userDTO.getMobile());

        return userRepository.save(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody UserDTO userDTO) {
        // Fetch currently authenticated user
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();

        // Find user by username
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setMobile(userDTO.getMobile());
            user.setPassword(userDTO.getPassword()); // You should encrypt the password before saving

            return userRepository.save(user);
        }
        return null;
    }

    @GetMapping("/profile")
    public User getUserProfile() {
        // Fetch currently authenticated user
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();

        // Find user by username
        return userRepository.findByUsername(username);
    }
}
