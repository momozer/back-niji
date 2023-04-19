package com.niji.lille.nijiVerse.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

public enum ERole {
    // TODO = commentaire das toutes les class.
    ROLE_USER,
    ROLE_MODERATOR,
    ROLE_ADMIN;


}
