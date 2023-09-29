package com.program.InventoryManagement.repository;

import com.program.InventoryManagement.entity.Order;
import com.program.InventoryManagement.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderRepoTest {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;

    @Test
    void findByUser() {
        User user=new User("muku@gmail.com","1234");
        userRepo.save(user);
        Order order=new Order("waiwai",user);
        orderRepo.save(order);
        Order order1=this.orderRepo.findByUser(user);
        assertThat(order1).isEqualTo(order);


    }
}