package com.program.InventoryManagement.repository;

import com.program.InventoryManagement.entity.User;
import com.program.InventoryManagement.payload.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepoTest {
    @Autowired
    private  UserRepo userRepo;
    @Test
    public void itShouldCheckIfEmail(){
        String email="mukeshsilwal5@gmail.com";
        User user=new User(email,"1234");
        userRepo.save(user);




    }


}