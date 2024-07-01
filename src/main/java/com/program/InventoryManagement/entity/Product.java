package com.program.InventoryManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_")
public class Product {
    private String productName;
    private LocalDateTime expireDate;
    private String stock;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productNo;
    @ManyToOne
    @JoinColumn(name="uId")
    private User user;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<OrderDetails> orderDetails;
    @ManyToOne
    @JoinColumn(name = "supplier_id",referencedColumnName = "supplierId")
    private Supplier supplier;

}
