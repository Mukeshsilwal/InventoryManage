package com.program.InventoryManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;
    private String permissions;
    @ManyToOne
    @JoinColumn(name = "uId",referencedColumnName = "uId")
    private User user;
    @Transient
    @Enumerated(EnumType.STRING)
    private Permission1 permission1;

}
