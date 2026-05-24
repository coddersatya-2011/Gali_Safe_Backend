package com.galisafe.galisafe_backend.repository;

import com.galisafe.galisafe_backend.model.EmergencyContect;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmergencyContectRepository extends JpaRepository<EmergencyContect, Long> {
    List<EmergencyContect> findByUserId(Long userId);
}