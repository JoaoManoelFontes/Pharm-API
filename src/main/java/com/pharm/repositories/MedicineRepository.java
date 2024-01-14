package com.pharm.repositories;

import com.pharm.domain.medicines.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    
    
} 
