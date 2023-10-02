package com.program.InventoryManagement.service.serviceImpl;

import com.program.InventoryManagement.entity.Order;
import com.program.InventoryManagement.entity.Product;
import com.program.InventoryManagement.entity.Supplier;
import com.program.InventoryManagement.entity.User;
import com.program.InventoryManagement.exception.ResourceEmpty;
import com.program.InventoryManagement.exception.ResourceNotFoundException;
import com.program.InventoryManagement.payload.OrderDto;
import com.program.InventoryManagement.repository.OrderRepo;
import com.program.InventoryManagement.repository.ProductRepo;
import com.program.InventoryManagement.repository.SupplierRepo;
import com.program.InventoryManagement.repository.UserRepo;
import com.program.InventoryManagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final SupplierRepo supplierRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;
    private Logger logger= LoggerFactory.getLogger(OrderServiceImpl.class);



    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order=this.dtoToOrder(orderDto);
        Order order1=this.orderRepo.save(order);
        return orderToDto(order1);
    }

    @Override
    public OrderDto updateOrder(Integer orderId, OrderDto orderDto) {
        Order order=this.orderRepo.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order","orderId",orderId));
        order.setOrderName(orderDto.getOrderName());
        Order order1=this.orderRepo.save(order);
        return orderToDto(order);
    }

    @Override
    public List<OrderDto> getAllOrder() {
        List<Order> orders=this.orderRepo.findAll();
        List<OrderDto> orderDtos=orders.stream().map((order)-> this.orderToDto(order)).collect(Collectors.toList());
        return orderDtos;
    }

    @Override
    public OrderDto getOrderById(Integer orderId) {
        Order order=this.orderRepo.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order","orderId",orderId));
        return orderToDto(order);
    }

    @Override
    public void deleteOrder(Integer orderId) {

            Order order=this.orderRepo.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order","orderId",orderId));
            this.orderRepo.delete(order);
    }

    @Override
    public OrderDto getOrderByUser(Integer uId) {
        User user=this.userRepo.findById(uId).orElseThrow(()->new ResourceNotFoundException("User","uId",uId));
        Order orders=this.orderRepo.findByUser(user);
//        List<OrderDto> orderDtos=orders.stream().map((order)->this.orderToDto(order)).collect(Collectors.toList());
        return orderToDto(orders);
    }

    @Override
    public List<OrderDto> getOrderBySupplier(Integer supplierId) {
        Supplier supplier=this.supplierRepo.findById(supplierId).orElseThrow(()->new ResourceNotFoundException("Supplier","supplierId",supplierId));
        List<Order> orders=this.orderRepo.findBySupplier(supplier);
        List<OrderDto> orderDtos=orders.stream().map((order)->this.orderToDto(order)).collect(Collectors.toList());
        return orderDtos;
    }

    @Override
    public List<OrderDto> getOrderByProduct(Integer productId) {
        Product product=this.productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product","productId",productId));
        List<Order> orders=this.orderRepo.findByProduct(product);
        List<OrderDto> orderDtos=orders.stream().map((order)->this.orderToDto(order)).collect(Collectors.toList());
        return orderDtos;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto, Integer uId, Integer supplierId, Integer productId) {
        User user=this.userRepo.findById(uId).orElseThrow(()->new ResourceNotFoundException("User","uId",uId));
        Supplier supplier=this.supplierRepo.findById(supplierId).orElseThrow(()->new ResourceNotFoundException("Supplier","supplierId",supplierId));
        Product product=this.productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product","productId",productId));
        Order order=this.dtoToOrder(orderDto);
        order.setProduct(product);
        order.setSupplier(supplier);
        order.setUser(user);
        Order order1=this.orderRepo.save(order);
        return orderToDto(order1);
    }

    @Override
    public boolean isIdPresent(Integer orderId) {

        return this.orderRepo.findById(orderId)==null;
    }

    public Order dtoToOrder(OrderDto orderDto){
        Order order=this.modelMapper.map(orderDto,Order.class);
        return order;
    }
    public OrderDto orderToDto(Order order){
        OrderDto orderDto=this.modelMapper.map(order,OrderDto.class);
        return orderDto;
    }
}
