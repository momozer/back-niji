package com.niji.lille.nijiVerse.repositories;

import com.niji.lille.nijiVerse.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingRepository extends JpaRepository<Parking, Long> {


        int getPlacesDisponibles();
}
