package com.program.InventoryManagement.controller;

import com.program.InventoryManagement.exception.ApiResponse;
import com.program.InventoryManagement.payload.PermissionDto;
import com.program.InventoryManagement.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping("/")
    public ResponseEntity<PermissionDto> createPermission(@RequestBody PermissionDto permissionDto){
        PermissionDto permissionDto1=this.permissionService.createPermission(permissionDto);
        return new ResponseEntity<>(permissionDto1, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<PermissionDto>> getAllPermission(){
        List<PermissionDto> permissionDto=this.permissionService.getAllPermission();
        return new ResponseEntity<>(permissionDto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePermission(@PathVariable Integer id){
        this.permissionService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse("Permission is deleted",HttpStatus.OK),HttpStatus.OK);
    }
    @PostMapping("/role/{id}")
    public ResponseEntity<PermissionDto> createPermissionBasedRole(@RequestBody PermissionDto permissionDto,@PathVariable Integer id){
        PermissionDto permissionDto1=this.permissionService.createPermissionToRole(permissionDto,id);
        return new ResponseEntity<>(permissionDto1,HttpStatus.CREATED);
    }



}
