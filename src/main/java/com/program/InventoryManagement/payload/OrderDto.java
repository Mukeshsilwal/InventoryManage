package com.program.InventoryManagement.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
     String orderName;
     int oId;
     List<OrderDetailsDto> orderDetails;
}
