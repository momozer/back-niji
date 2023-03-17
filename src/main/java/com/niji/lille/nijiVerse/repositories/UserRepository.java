package com.niji.lille.nijiVerse.repositories;

import com.niji.lille.nijiVerse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
