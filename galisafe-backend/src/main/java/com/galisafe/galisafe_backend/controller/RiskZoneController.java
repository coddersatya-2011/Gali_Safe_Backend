package com.galisafe.galisafe_backend.controller;

import com.galisafe.galisafe_backend.model.RiskZone;
import com.galisafe.galisafe_backend.repository.RiskZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-zones")
public class RiskZoneController {

    @Autowired
    private RiskZoneRepository riskZoneRepository;

    @GetMapping
    public ResponseEntity<List<RiskZone>> getAllZones() {
        return ResponseEntity.ok(riskZoneRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<RiskZone> addZone(@RequestBody RiskZone riskZone) {
        RiskZone saved = riskZoneRepository.save(riskZone);
        return ResponseEntity.ok(saved);
    }
}