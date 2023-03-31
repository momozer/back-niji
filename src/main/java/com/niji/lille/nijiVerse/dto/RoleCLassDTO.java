package com.niji.lille.nijiVerse.dto;

import com.niji.lille.nijiVerse.entities.RoleClass;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder @Data
public class RoleCLassDTO {
    private Long id;
    private String name;

    public static RoleCLassDTO fromEntity(RoleClass roleClass){
        if (roleClass == null){
            return null;
        }
        return RoleCLassDTO.builder().build();
    }

    public static RoleClass toEntity(RoleCLassDTO roleCLassDTO){
        if (roleCLassDTO == null){
            return null;
        }
        RoleClass roleClass = new RoleClass();
        roleClass.setName(roleCLassDTO.getName());
        return roleClass;
    }
}
