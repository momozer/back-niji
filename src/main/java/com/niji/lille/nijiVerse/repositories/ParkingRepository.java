package com.niji.lille.nijiVerse.repositories;

import com.niji.lille.nijiVerse.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, String> {
        }
