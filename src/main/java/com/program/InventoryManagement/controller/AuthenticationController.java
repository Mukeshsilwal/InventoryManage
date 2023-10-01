package com.program.InventoryManagement.controller;

import com.program.InventoryManagement.model.JwtRequest;
import com.program.InventoryManagement.model.JwtResponse;
import com.program.InventoryManagement.payload.UserDto;
import com.program.InventoryManagement.repository.UserRepo;
import com.program.InventoryManagement.security.JwtService;
import com.program.InventoryManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepo userRepo;
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest user) {
        JwtResponse jwtResponse;
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
            String token = this.jwtService.generateToken(userDetails);

            jwtResponse = JwtResponse.builder()
                    .token(token)
                    .username(userDetails.getUsername())
                    .build();

            return new ResponseEntity<>(jwtResponse, HttpStatus.OK);

    }

    @PostMapping("/create_user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user)  {
            UserDto userDto = this.userService.createUser(user);
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);

    }
    @PostMapping("/super-admin")
    public ResponseEntity<UserDto> createUser1(@RequestBody UserDto user)  {
        UserDto userDto = this.userService.createUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);

    }





}
