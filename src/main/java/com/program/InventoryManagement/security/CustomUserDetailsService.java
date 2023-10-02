package com.program.InventoryManagement.security;

//
//import com.program.InventoryManagement.entity.User;
import com.program.InventoryManagement.entity.Permission;
import com.program.InventoryManagement.entity.Role;
import com.program.InventoryManagement.entity.User;
import com.program.InventoryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private  UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=this.userRepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
            for (Permission permission : user.getPermissions()) {
                authorities.add(new SimpleGrantedAuthority(permission.getPermissions()));
            }
        }
//       return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword())
//               .disabled(user.isEnabled()).authorities(user.getAuthorities()).build();
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword()).disabled(user.isEnabled()).authorities(authorities).build();
    }
}
