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

    @PostMapping("/post")
    public ResponseEntity<PermissionDto> createPermission(@RequestBody PermissionDto permissionDto){
        PermissionDto permissionDto1=this.permissionService.createPermission(permissionDto);
        return new ResponseEntity<>(permissionDto1, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<PermissionDto>> getAllPermission(){
        List<PermissionDto> permissionDto=this.permissionService.getAllPermission();
        return new ResponseEntity<>(permissionDto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePermission(@PathVariable Integer id){
        this.permissionService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse("Permission is deleted",HttpStatus.OK),HttpStatus.OK);
    }
    @PostMapping("/user/{uId}")
    public ResponseEntity<PermissionDto> createPermissionBasedRole(@RequestBody PermissionDto permissionDto,@PathVariable Integer uId){
        PermissionDto permissionDto1=this.permissionService.createPermissionToUser(permissionDto,uId);
        return new ResponseEntity<>(permissionDto1,HttpStatus.CREATED);
    }



}
