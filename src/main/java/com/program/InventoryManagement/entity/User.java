package com.program.InventoryManagement.entity;

import com.program.InventoryManagement.common.enums.Roles;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="user_table")

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uId")
    private int uId;
    private String email;
    private String password;
    private Roles role;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Product> products=new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    Set<Order> orders = new HashSet<>();
    @Transient
    @Enumerated(EnumType.STRING)
    List<Roles> roles=new ArrayList<>();
    public User(String mail, String number) {
        this.email=mail;
        this.password=number;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map((role)->new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
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
