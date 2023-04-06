package com.niji.lille.nijiVerse.repositories;

import com.niji.lille.nijiVerse.entities.ERole;
import com.niji.lille.nijiVerse.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
