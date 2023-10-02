package com.program.InventoryManagement.service.serviceImpl;

import com.program.InventoryManagement.entity.Permission;
import com.program.InventoryManagement.entity.Role;
import com.program.InventoryManagement.entity.User;
import com.program.InventoryManagement.exception.ResourceNotFoundException;
import com.program.InventoryManagement.payload.PermissionDto;
import com.program.InventoryManagement.repository.PermissionRepo;
import com.program.InventoryManagement.repository.RoleRepo;
import com.program.InventoryManagement.repository.UserRepo;
import com.program.InventoryManagement.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepo permissionRepo;
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final ModelMapper  modelMapper;
    @Override
    public PermissionDto createPermission(PermissionDto permissionDto) {
        Permission permission=this.dtoToPermission(permissionDto);
        Permission permission1=this.permissionRepo.save(permission);
        return permissionToDto(permission1);
    }

    @Override
    public void deleteById(Integer id) {
        Permission permission=this.permissionRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Permission","id",id));
        this.permissionRepo.delete(permission);

    }

    @Override
    public List<PermissionDto> getAllPermission() {
        List<Permission> permissions=this.permissionRepo.findAll();
        List<PermissionDto> permissionDtos=permissions.stream().map(permission->this.permissionToDto(permission)).collect(Collectors.toList());
        return permissionDtos;
    }

    @Override
    public PermissionDto createPermissionToUser(PermissionDto permissionDto, Integer uId) {
        User user =this.userRepo.findById(uId).orElseThrow(()->new ResourceNotFoundException("User","uId",uId));
        Permission permission=this.dtoToPermission(permissionDto);
        permission.setUser(user);
        Permission permission1=this.permissionRepo.save(permission);
        return permissionToDto(permission1);
    }

    public Permission dtoToPermission(PermissionDto permissionDto){
        Permission permission=this.modelMapper.map(permissionDto, Permission.class);
        return permission;
    }
    public PermissionDto permissionToDto(Permission permission){
        PermissionDto permissionDto=this.modelMapper.map(permission, PermissionDto.class);
        return permissionDto;
    }
}
