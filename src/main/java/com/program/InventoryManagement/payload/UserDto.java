package com.program.InventoryManagement.payload;

import com.program.InventoryManagement.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int uId;
    private String email;

    private String password;
    private Set<RoleDto> roles;


}
