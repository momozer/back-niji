package com.niji.lille.nijiVerse.repositories;

import com.niji.lille.nijiVerse.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, String> {
}
