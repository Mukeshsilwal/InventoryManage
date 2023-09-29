package com.program.InventoryManagement.payload;


import com.program.InventoryManagement.entity.Product;
import com.program.InventoryManagement.entity.Supplier;
import com.program.InventoryManagement.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
     String orderName;
     int orderId;
     private UserDto user;
     private ProductDto product;
     private SupplierDto supplier;

     public OrderDto(String orderName, UserDto user) {
          this.orderName = orderName;
          this.user = user;
     }
}
