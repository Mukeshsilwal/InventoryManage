package com.program.InventoryManagement.service.serviceImpl;

import com.program.InventoryManagement.entity.OrderDetails;
import com.program.InventoryManagement.payload.OrderDetailsDto;
import com.program.InventoryManagement.repository.OrderDetailsRepository;
import com.program.InventoryManagement.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;
    private final ModelMapper modelMapper;

    @Override
    public OrderDetailsDto createOrderDetails(OrderDetailsDto detailsDto) {
        OrderDetails details=this.toOrderDetails(detailsDto);
        OrderDetails saved=this.orderDetailsRepository.save(details);
        return this.toOrderDetailsDto(saved);
    }

    @Override
    public OrderDetailsDto updateOrderDetails(OrderDetailsDto detailsDto, String id) {
        OrderDetails orderDetails=this.orderDetailsRepository.findById(Integer.valueOf(id)).orElseThrow();
        orderDetails.setDiscount(detailsDto.getDiscount());
        orderDetails.setQuantity(detailsDto.getQuantity());
        orderDetails.setPrice(detailsDto.getPrice());
        orderDetails.setTotalPrice(detailsDto.getTotalPrice());
        orderDetails.setTax(detailsDto.getTax());
        OrderDetails saved=this.orderDetailsRepository.save(orderDetails);
        return this.toOrderDetailsDto(saved);
    }

    @Override
    public OrderDetailsDto getOrderDetails(String id) {
        OrderDetails orderDetails=this.orderDetailsRepository.findById(Integer.valueOf(id)).orElseThrow();
        return this.toOrderDetailsDto(orderDetails);
    }

    @Override
    public List<OrderDetailsDto> getAllOrderDetails() {
        List<OrderDetails> orderDetailsList=this.orderDetailsRepository.findAll();
        return orderDetailsList.stream().map(this::toOrderDetailsDto).collect(Collectors.toList());
    }

    @Override
    public void deleteOrderDetails(String id) {
        OrderDetails orderDetails=this.orderDetailsRepository.findById(Integer.valueOf(id)).orElseThrow();
        this.orderDetailsRepository.delete(orderDetails);

    }
    public OrderDetailsDto toOrderDetailsDto(OrderDetails orderDetails) {
        return this.modelMapper.map(orderDetails, OrderDetailsDto.class);
    }
    public OrderDetails toOrderDetails(OrderDetailsDto orderDetailsDto) {
        return this.modelMapper.map(orderDetailsDto, OrderDetails.class);
    }
}
