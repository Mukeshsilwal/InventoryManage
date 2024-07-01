package com.program.InventoryManagement.entity;

import com.program.InventoryManagement.common.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="role_table")
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


}
