package com.galisafe.galisafe_backend.controller;

import com.galisafe.galisafe_backend.model.User;
import com.galisafe.galisafe_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/update")
    public ResponseEntity<String> updateLocation(@RequestParam Long userId,
                                                 @RequestParam Double latitude,
                                                 @RequestParam Double longitude) {
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok("Location updated: " + latitude + ", " + longitude);
    }
}