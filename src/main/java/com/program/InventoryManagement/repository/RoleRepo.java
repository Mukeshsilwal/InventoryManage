package com.program.InventoryManagement.repository;

import com.program.InventoryManagement.entity.Role;
import com.program.InventoryManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
    Role findRoleByUser(User user);
}
