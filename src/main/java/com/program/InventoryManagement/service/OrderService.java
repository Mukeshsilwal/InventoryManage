package com.program.InventoryManagement.service;

import com.program.InventoryManagement.payload.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(Integer orderId,OrderDto orderDto);
    List<OrderDto> getAllOrder();
    OrderDto getOrderById(Integer orderId);
    void deleteOrder(Integer orderId);
    OrderDto getOrderByUser(Integer uId);
    List<OrderDto> getOrderBySupplier(Integer supplierId);
    List<OrderDto> getOrderByProduct(Integer productId);
    OrderDto createOrder(OrderDto orderDto,Integer uId,Integer supplierId,Integer productId);
    boolean isIdPresent(Integer orderId);
}
