package com.program.InventoryManagement.entity;

import io.micrometer.core.lang.Nullable;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oId")
    private int oId;
    private String orderName;
    @Nullable
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "uId")
    private User user;
    @ManyToOne
    @JoinColumn(name="productId",referencedColumnName = "id")
    private Product product;
    @ManyToOne
    @JoinColumn(name="supplierId",referencedColumnName = "id")
    private Supplier supplier;
    @OneToMany(mappedBy = "order")
    List<OrderDetails> orderDetails;

    public Order(String orderName, User user) {
        this.orderName=orderName;
        this.user=user;
    }
}
