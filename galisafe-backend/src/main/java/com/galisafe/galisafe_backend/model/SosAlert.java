package com.galisafe.galisafe_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sos_alerts")
public class SosAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double latitude;
    private Double longitude;
    private LocalDateTime triggeredAt = LocalDateTime.now();
    private String status = "active";
}