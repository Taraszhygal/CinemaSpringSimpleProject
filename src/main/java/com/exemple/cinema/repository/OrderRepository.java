package com.exemple.cinema.repository;

import com.exemple.cinema.entity.Order;
import com.exemple.cinema.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private List<Order> orderList;
    private Long count;

    @PostConstruct
    public void initOrders() {
        orderList = new ArrayList<>();
        count = 0L;
    }

    public List<Order> getAll() {
        return orderList;
    }

    public Order save(Order order) {
        ++count;
        order.setId(count);
        orderList.add(order);
        return order;
    }

    public Order getById(Long id) {
        Order order = orderList.stream()
                .filter((e -> e.getId().equals(id)))
                .findFirst()
                .orElseThrow(()-> new ServiceException(400,"User not found",null));

        return order;
    }

    public Order update(Order order) {
        if (order.getId()==null){
            throw new ServiceException(400,"Order not found", null);
        }
        final Order oldOrder = getById(order.getId());
        orderList.remove(oldOrder);
        orderList.add(order);
        return order;
    }

    public List<Order> getByUserId(Long userId) {
        return orderList.stream().filter((o) -> o.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
