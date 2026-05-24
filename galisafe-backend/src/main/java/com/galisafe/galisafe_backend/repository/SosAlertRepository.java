package com.galisafe.galisafe_backend.repository;

import com.galisafe.galisafe_backend.model.SosAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SosAlertRepository extends JpaRepository<SosAlert, Long> {
    List<SosAlert> findByUserId(Long userId);
}