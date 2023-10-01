package com.program.InventoryManagement.controller;

import com.program.InventoryManagement.exception.ApiResponse;
import com.program.InventoryManagement.exception.ResourceEmpty;
import com.program.InventoryManagement.payload.OrderDto;
import com.program.InventoryManagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;
    private Logger logger= LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Integer orderId){
                logger.info("Get Mapping By Id end point is working perfectly");
                OrderDto orderDto=this.orderService.getOrderById(orderId);
                return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<List<OrderDto>> getAllOrder(){
                logger.info("Get Mapping endpoint is working perfectly");
                List<OrderDto> orderDto=this.orderService.getAllOrder();
                return new ResponseEntity<>(orderDto,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
                logger.info("Order Is created successfully without error");
                OrderDto orderDto1 = this.orderService.createOrder(orderDto);
                return new ResponseEntity<>(orderDto1, HttpStatus.CREATED);
    }
    @PutMapping("/update/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto,@PathVariable Integer orderId){
                logger.info("Data is being updated successfully");
                OrderDto orderDto1=this.orderService.updateOrder(orderId,orderDto);
                return new ResponseEntity<>(orderDto1,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable Integer orderId){
                 logger.info("Delete endpoint is work perfectly");
                 this.orderService.deleteOrder(orderId);
                 return new ResponseEntity<>(new ApiResponse("Delete successfully",HttpStatus.OK),HttpStatus.OK);
    }
    @PostMapping("/user/{uId}/product/{productId}/supplier/{supplierId}")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto,@PathVariable Integer uId,
                                                @PathVariable Integer productId,
                                                @PathVariable Integer supplierId){
              logger.info("Relational end point is working perfectly");
              OrderDto orderDto1=this.orderService.createOrder(orderDto,uId,supplierId,productId);
              return new ResponseEntity<>(orderDto1,HttpStatus.CREATED);
    }


}
