package com.program.InventoryManagement.controller;

import com.program.InventoryManagement.exception.ApiResponse;
import com.program.InventoryManagement.payload.UserDto;
import com.program.InventoryManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/admin/get/{uId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer uId){
        UserDto userDto=this.userService.getUserById(uId);
     return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> userDtos=this.userService.getAllUser();
       return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }
    @PostMapping("/admin/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userDto1=this.userService.createUser(userDto);
        return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
    }
    @PutMapping("/admin/update/{uId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Integer uId){
        UserDto userDto1=this.userService.updateUser(uId,userDto);
        return new ResponseEntity<>(userDto1,HttpStatus.OK);
    }
    @DeleteMapping("/admin/delete/{uId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer uId){
        this.userService.deleteUser(uId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted",HttpStatus.OK),HttpStatus.OK);
    }
}
