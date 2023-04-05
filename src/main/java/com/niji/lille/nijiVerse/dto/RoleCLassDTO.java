package com.niji.lille.nijiVerse.dto;

import com.niji.lille.nijiVerse.entities.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder @Data
public class RoleCLassDTO {
    private Long id;
    private String name;

    public static RoleCLassDTO fromEntity(Role roleClass){
        if (roleClass == null){
            return null;
        }
        return RoleCLassDTO.builder().build();
    }

    public static Role toEntity(RoleCLassDTO roleCLassDTO){
        if (roleCLassDTO == null){
            return null;
        }
        Role role = new Role();
        role.setName(roleCLassDTO.getName());
        return role;
    }
}
