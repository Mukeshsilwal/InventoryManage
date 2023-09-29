package com.program.InventoryManagement.service;

import com.program.InventoryManagement.entity.Role;
import com.program.InventoryManagement.payload.RoleDto;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    RoleDto getRoleById(Integer id);
    RoleDto updateRole(RoleDto roleDto,Integer id);
    void deleteRole(Integer id);
    RoleDto createUser(RoleDto roleDto,Integer uId);
    }

