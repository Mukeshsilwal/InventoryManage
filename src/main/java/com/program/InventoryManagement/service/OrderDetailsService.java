package com.program.InventoryManagement.service;

import com.program.InventoryManagement.payload.OrderDetailsDto;
import java.util.List;

public interface OrderDetailsService {
OrderDetailsDto createOrderDetails(OrderDetailsDto detailsDto);
OrderDetailsDto updateOrderDetails(OrderDetailsDto detailsDto,String id);
OrderDetailsDto getOrderDetails(String id);
List<OrderDetailsDto> getAllOrderDetails();
void deleteOrderDetails(String id);
}
