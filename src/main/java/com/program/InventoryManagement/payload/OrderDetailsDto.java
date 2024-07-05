package com.program.InventoryManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {
    private int id;
    private String quantity;
    private String price;
    private String totalPrice;
    private String tax;
    private String discount;
}
