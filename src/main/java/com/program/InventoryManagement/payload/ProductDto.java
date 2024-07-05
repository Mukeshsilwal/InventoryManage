package com.program.InventoryManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String productName;
    private int id;
    private int productNo;
    private LocalDateTime expireDate;
    private String stock;
    List<OrderDetailsDto> orderDetails;
}
