package com.program.InventoryManagement.controller;

import com.program.InventoryManagement.entity.Role;
import com.program.InventoryManagement.exception.ApiResponse;
import com.program.InventoryManagement.payload.RoleDto;
import com.program.InventoryManagement.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRole(@PathVariable Integer id){
        RoleDto roleDto=this.roleService.getRoleById(id);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto){
        RoleDto roleDto1=this.roleService.createRole(roleDto);
        return new ResponseEntity<>(roleDto1,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(@RequestBody RoleDto roleDto,@PathVariable Integer id){
        RoleDto roleDto1=this.roleService.updateRole(roleDto,id);
        return new ResponseEntity<>(roleDto1,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRole(@PathVariable Integer id){
        this.roleService.deleteRole(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Role is deleted successfully",HttpStatus.OK),HttpStatus.OK);
    }
    @PostMapping("/super-admin/user/{uId}")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto,@PathVariable Integer uId){
        RoleDto roleDto1=this.roleService.createUser(roleDto,uId);
        return new ResponseEntity<>(roleDto1,HttpStatus.CREATED);
    }

}
