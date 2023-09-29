package com.program.InventoryManagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Order_")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oId;
    private String orderName;
    @ManyToOne
    @JoinColumn(name="uId",referencedColumnName = "uId")
    private User user;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;
    @ManyToOne
    @JoinColumn(name="supplierId")
    private Supplier supplier;

    public Order(String orderName, User user) {
        this.orderName=orderName;
        this.user=user;
    }
}
