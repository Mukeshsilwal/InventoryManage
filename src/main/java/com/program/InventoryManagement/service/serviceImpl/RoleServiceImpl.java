package com.program.InventoryManagement.service.serviceImpl;

import com.program.InventoryManagement.entity.Role;
import com.program.InventoryManagement.entity.User;
import com.program.InventoryManagement.exception.ResourceNotFoundException;
import com.program.InventoryManagement.payload.RoleDto;
import com.program.InventoryManagement.repository.RoleRepo;
import com.program.InventoryManagement.repository.UserRepo;
import com.program.InventoryManagement.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role=this.dtoToRole(roleDto);
        Role role1=this.roleRepo.save(role);
        return roleToDto(role1);
    }

    @Override
    public RoleDto getRoleById(Integer id) {
        Role role=this.roleRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Role","id",id));
        return roleToDto(role);
    }

    @Override
    public RoleDto updateRole(RoleDto roleDto, Integer id) {
        Role role1=this.roleRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Role","id",id));
        Role role=this.dtoToRole(roleDto);
        role1.setRole(role.getRole());
        Role role2=this.roleRepo.save(role);
        return roleToDto(role2);
    }

    @Override
    public void deleteRole(Integer id) {
        Role role=this.roleRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Role","id",id));
        this.roleRepo.delete(role);
    }

    @Override
    public RoleDto createUser(RoleDto roleDto, Integer uId) {
        User user=this.userRepo.findById(uId).orElseThrow(()->new ResourceNotFoundException("User","uId",uId));
        Role role=this.dtoToRole(roleDto);
        role.setUser(user);
        Role role1=this.roleRepo.save(role);
        return roleToDto(role1);
    }
    public Role dtoToRole(RoleDto roleDto){
        Role role=this.modelMapper.map(roleDto,Role.class);
        return role;
    }
    public RoleDto roleToDto(Role role){
        RoleDto roleDto=this.modelMapper.map(role,RoleDto.class);
        return roleDto;
    }



}
