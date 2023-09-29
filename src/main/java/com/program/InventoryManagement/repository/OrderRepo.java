package com.program.InventoryManagement.repository;

import com.program.InventoryManagement.entity.Order;
import com.program.InventoryManagement.entity.Product;
import com.program.InventoryManagement.entity.Supplier;
import com.program.InventoryManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Integer> {
    Order findByUser(User user);
    List<Order> findBySupplier(Supplier supplier);
    List<Order> findByProduct(Product product);

}
