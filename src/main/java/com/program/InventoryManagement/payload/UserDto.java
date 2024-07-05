package com.program.InventoryManagement.payload;

import com.program.InventoryManagement.common.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int uId;
    private String email;
    private String password;
    private Roles role;
    List<OrderDto> orderDtos;
    List<ProductDto> productDtos;

}
