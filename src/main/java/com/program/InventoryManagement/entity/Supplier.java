package com.program.InventoryManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.program.InventoryManagement.payload.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="supplier_")
public class Supplier {
    private String supplierName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;
    private String location;


    @ManyToOne
    @JoinColumn(name="uId",referencedColumnName = "uId")
    private User user;
    @OneToMany(mappedBy = "supplier",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    Set<Product> products=new HashSet<>();
    @OneToMany(mappedBy = "supplier",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    Set<Order> orders=new HashSet<>();
}
