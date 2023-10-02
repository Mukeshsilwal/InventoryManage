package com.program.InventoryManagement.service;

import com.program.InventoryManagement.payload.PermissionDto;

import java.util.List;

public interface PermissionService {
    PermissionDto createPermission(PermissionDto permissionDto);
    void deleteById(Integer id);
    List<PermissionDto> getAllPermission();
    PermissionDto createPermissionToUser(PermissionDto permissionDto,Integer id);
    }

