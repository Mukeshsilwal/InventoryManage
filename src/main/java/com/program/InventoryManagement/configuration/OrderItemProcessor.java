package com.program.InventoryManagement.configuration;

import com.program.InventoryManagement.payload.OrderDto;
import org.springframework.batch.item.ItemProcessor;

public class OrderItemProcessor implements ItemProcessor<OrderDto, OrderDto> {
    @Override
    public OrderDto process(OrderDto orderDto) throws Exception {
        return orderDto;
    }
}
