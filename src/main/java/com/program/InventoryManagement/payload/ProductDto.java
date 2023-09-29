package com.program.InventoryManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String productName;
    private int productId;
    private int productNo;
    private Date expireDate;
    private String stock;
    private UserDto user;
    private SupplierDto supplier;

}
