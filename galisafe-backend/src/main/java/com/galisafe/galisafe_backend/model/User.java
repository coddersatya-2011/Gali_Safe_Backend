package com.galisafe.galisafe_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String Name;

    @Column(unique = true, nullable = false)
    private String Email;

    @Column(unique = true)
    private String Phone;

    @Column(nullable = false)
    private String Password;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
