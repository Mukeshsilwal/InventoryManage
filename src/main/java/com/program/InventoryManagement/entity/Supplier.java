package com.program.InventoryManagement.entity;

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
@Table(name="supplier_table")
public class Supplier {
    private String supplierName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String location;
    @OneToMany(mappedBy = "supplier",fetch = FetchType.EAGER)
    Set<Product> products=new HashSet<>();
}
