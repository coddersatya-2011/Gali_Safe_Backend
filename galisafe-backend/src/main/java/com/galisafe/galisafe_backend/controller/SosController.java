package com.galisafe.galisafe_backend.controller;

import com.galisafe.galisafe_backend.model.SosAlert;
import com.galisafe.galisafe_backend.model.User;
import com.galisafe.galisafe_backend.repository.SosAlertRepository;
import com.galisafe.galisafe_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sos")
public class SosController {

    @Autowired
    private SosAlertRepository sosAlertRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/trigger")
    public ResponseEntity<String> triggerSOS(@RequestParam Long userId,
                                             @RequestParam Double latitude,
                                             @RequestParam Double longitude) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        SosAlert alert = new SosAlert();
        alert.setUser(user);
        alert.setLatitude(latitude);
        alert.setLongitude(longitude);
        sosAlertRepository.save(alert);

        return ResponseEntity.ok("SOS triggered successfully!");
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<SosAlert>> getHistory(@PathVariable Long userId) {
        List<SosAlert> alerts = sosAlertRepository.findByUser_Id(userId);
        return ResponseEntity.ok(alerts);
    }
}
