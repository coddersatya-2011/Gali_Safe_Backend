package com.galisafe.galisafe_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "risk_zones")
public class RiskZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;
    private Double radiusMeters;
    private String riskLevel;
    private String description;
}