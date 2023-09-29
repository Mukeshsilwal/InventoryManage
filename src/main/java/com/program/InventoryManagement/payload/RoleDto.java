package com.program.InventoryManagement.payload;

import com.program.InventoryManagement.entity.Permission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class RoleDto {
    private String  role;
    private int id;
    private Set<PermissionDto> permissionset;
//    private UserDto user;
}
