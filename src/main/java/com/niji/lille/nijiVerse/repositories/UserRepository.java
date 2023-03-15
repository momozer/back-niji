package com.niji.lille.nijiVerse.repositories;

import com.niji.lille.nijiVerse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
