package com.program.InventoryManagement.service.serviceImpl;

import com.program.InventoryManagement.entity.User;
import com.program.InventoryManagement.exception.ResourceEmpty;
import com.program.InventoryManagement.exception.ResourceNotFoundException;
import com.program.InventoryManagement.payload.UserDto;
import com.program.InventoryManagement.repository.UserRepo;
import com.program.InventoryManagement.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        super();
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public UserDto createUser(UserDto userDto) {
        if (userRepo.existsByEmail(userDto.getEmail())) {
            throw new ResourceEmpty("USER ALREADY EXIST WITH EMAIL" +" "+ userDto.getEmail(), "User");
        }
        User user=this.dtoToUser(userDto);

        User user1=this.userRepo.save(user);
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        return userToDto(user1);
    }

    @Override
    public UserDto updateUser(Integer uId, UserDto userDto) {
        User user=this.userRepo.findById(uId).orElseThrow(()->new ResourceNotFoundException("User","uId",uId));
        user.setEmail(userDto.getEmail());
        User user1=this.userRepo.save(user);
        return userToDto(user1);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users=this.userRepo.findAll();
        return users.stream().map(this::userToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Integer uId) {
        User user=this.userRepo.findById(uId).orElseThrow(()->new ResourceNotFoundException("User","uId",uId));
        user.setPassword(null);
        return userToDto(user);
    }

    @Override
    public void deleteUser(Integer uId) {
        User user=this.userRepo.findById(uId).orElseThrow(()->new ResourceNotFoundException("User","uId",uId));
        this.userRepo.delete(user);

    }

    public User dtoToUser(UserDto userDto){
        return this.modelMapper.map(userDto,User.class);
    }
    public UserDto userToDto(User user){
        return this.modelMapper.map(user,UserDto.class);
    }
}
