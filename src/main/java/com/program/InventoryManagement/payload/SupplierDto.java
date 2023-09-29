package com.program.InventoryManagement.payload;

import com.program.InventoryManagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {
    private String supplierName;
    private int supplierId;
    private String location;
    private Set<ProductDto> product;
    private Set<OrderDto> order;
    private UserDto user;
}
