package com.program.InventoryManagement.service;

import com.program.InventoryManagement.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(Integer uId,UserDto userDto);
    List<UserDto> getAllUser();
    UserDto getUserById(Integer uId);
    void deleteUser(Integer uId);
}
