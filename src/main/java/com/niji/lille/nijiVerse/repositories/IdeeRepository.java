package com.niji.lille.nijiVerse.repositories;

import com.niji.lille.nijiVerse.entities.Idee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeeRepository extends JpaRepository<Idee, String> {
}
