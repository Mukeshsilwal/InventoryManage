package com.program.InventoryManagement.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="table__")

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uId;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    Set<Product> products=new HashSet<>();
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    Set<Order> orders=new HashSet<>();
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    Set<Role> roles=new HashSet<>();
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<Permission> permissions;
    public User(String mail, String number) {
        this.email=mail;
        this.password=number;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map((role)->new SimpleGrantedAuthority(role.getRoles().name())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
