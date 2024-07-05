package com.program.InventoryManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_table")
public class Product {
    private String productName;
    private LocalDateTime expireDate;
    private String stock;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int productNo;
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "uId")
    private User user;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<OrderDetails> orderDetails;
    @ManyToOne
    @JoinColumn(name = "supplier_id",referencedColumnName = "id")
    private Supplier supplier;

}
