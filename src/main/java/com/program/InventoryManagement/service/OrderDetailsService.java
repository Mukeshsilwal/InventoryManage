package com.program.InventoryManagement.service;

import com.program.InventoryManagement.payload.OrderDetailsDto;
import java.util.List;

public interface OrderDetailsService {
OrderDetailsDto createOrderDetails(OrderDetailsDto detailsDto);
OrderDetailsDto updateOrderDetails(OrderDetailsDto detailsDto,int id);
OrderDetailsDto getOrderDetails(int id);
List<OrderDetailsDto> getAllOrderDetails();
void deleteOrderDetails(int id);
OrderDetailsDto createOrderDetailsWithOrderAndProduct(OrderDetailsDto detailsDto,int productId,int orderId);
}
