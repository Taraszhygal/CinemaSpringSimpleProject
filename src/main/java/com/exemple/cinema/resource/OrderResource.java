package com.exemple.cinema.resource;

import com.exemple.cinema.dto.OrderDto;
import com.exemple.cinema.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderResource {
    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @GetMapping("/")
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<OrderDto> getAllByUserId(@PathVariable Long userId) {
        return orderService.getAllByUserId(userId);
    }

    @PutMapping("/")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }
}
