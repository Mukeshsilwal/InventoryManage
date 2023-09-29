package com.program.InventoryManagement.repository;

import com.program.InventoryManagement.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepo extends JpaRepository<Permission,Integer> {
}
