package com.program.InventoryManagement.service.serviceImpl;

import com.program.InventoryManagement.entity.Order;
import com.program.InventoryManagement.entity.OrderDetails;
import com.program.InventoryManagement.entity.Product;
import com.program.InventoryManagement.exception.ResourceNotFoundException;
import com.program.InventoryManagement.payload.OrderDetailsDto;
import com.program.InventoryManagement.repository.OrderDetailsRepository;
import com.program.InventoryManagement.repository.OrderRepo;
import com.program.InventoryManagement.repository.ProductRepo;
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
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    @Override
    public OrderDetailsDto createOrderDetails(OrderDetailsDto detailsDto) {
        OrderDetails details=this.toOrderDetails(detailsDto);
        OrderDetails saved=this.orderDetailsRepository.save(details);
        return this.toOrderDetailsDto(saved);
    }

    @Override
    public OrderDetailsDto updateOrderDetails(OrderDetailsDto detailsDto, int id) {
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
    public OrderDetailsDto getOrderDetails(int id) {
        OrderDetails orderDetails=this.orderDetailsRepository.findById(id).orElseThrow();
        return this.toOrderDetailsDto(orderDetails);
    }

    @Override
    public List<OrderDetailsDto> getAllOrderDetails() {
        List<OrderDetails> orderDetailsList=this.orderDetailsRepository.findAll();
        return orderDetailsList.stream().map(this::toOrderDetailsDto).collect(Collectors.toList());
    }

    @Override
    public void deleteOrderDetails(int id) {
        OrderDetails orderDetails=this.orderDetailsRepository.findById(id).orElseThrow();
        this.orderDetailsRepository.delete(orderDetails);

    }

    @Override
    public OrderDetailsDto createOrderDetailsWithOrderAndProduct(OrderDetailsDto detailsDto, int productId, int orderId) {
        Product product=this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","id",productId));
        Order order=this.orderRepo.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Order","id",orderId));
        OrderDetails details=this.toOrderDetails(detailsDto);
        details.setProduct(product);
        details.setOrder(order);
        OrderDetails saved=this.orderDetailsRepository.save(details);
        return this.toOrderDetailsDto(saved);
    }

    public OrderDetailsDto toOrderDetailsDto(OrderDetails orderDetails) {
        return this.modelMapper.map(orderDetails, OrderDetailsDto.class);
    }
    public OrderDetails toOrderDetails(OrderDetailsDto orderDetailsDto) {
        return this.modelMapper.map(orderDetailsDto, OrderDetails.class);
    }
}
