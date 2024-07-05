package com.program.InventoryManagement.controller;

import com.program.InventoryManagement.payload.OrderDetailsDto;
import com.program.InventoryManagement.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetails")
@RequiredArgsConstructor
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;
    @GetMapping
    public ResponseEntity<List<OrderDetailsDto>> getAllOrderDetails() {
        List<OrderDetailsDto> orderDetails = orderDetailsService.getAllOrderDetails();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<OrderDetailsDto> createOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto) {
        OrderDetailsDto  orderDetails = orderDetailsService.createOrderDetails(orderDetailsDto);
        return new ResponseEntity<>(orderDetails, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailsDto> updateOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto,@PathVariable int id) {
        OrderDetailsDto detailsDto=this.orderDetailsService.updateOrderDetails(orderDetailsDto,id);
        return new ResponseEntity<>(detailsDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDetailsDto> deleteOrderDetails(@PathVariable int id) {
        this.orderDetailsService.deleteOrderDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/product/{pId}/order/{oId}")
    public ResponseEntity<OrderDetailsDto> addOrderDetails(@RequestBody OrderDetailsDto orderDetailsDto,@PathVariable int pId,@PathVariable int oId) {
        OrderDetailsDto detailsDto=this.orderDetailsService.createOrderDetailsWithOrderAndProduct(orderDetailsDto,pId,oId);
        return new ResponseEntity<>(detailsDto, HttpStatus.CREATED);
    }
}
