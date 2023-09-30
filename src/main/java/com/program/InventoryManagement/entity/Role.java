package com.program.InventoryManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="role___")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="uId")
    private User user;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private Set<Permission> permissionSet;
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities1=permissionSet.stream().map((permission)->new SimpleGrantedAuthority(permission.getPermissions())).collect(Collectors.toList());
        authorities1.add(new SimpleGrantedAuthority(this.role));
        return authorities1;
    }

}
