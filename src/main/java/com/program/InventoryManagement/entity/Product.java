package com.program.InventoryManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_")
public class Product {
    private String productName;
    private Date expireDate;
    private String stock;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private int productNo;
    @ManyToOne
    @JoinColumn(name="uId")
    private User user;
    @OneToMany(mappedBy = "product")
    Set<Order> orders=new HashSet<>();
    @ManyToOne
    @JoinColumn(name="supplierId")
    private Supplier supplier;
}
