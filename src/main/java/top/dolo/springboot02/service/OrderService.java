package top.dolo.springboot02.service;

import top.dolo.springboot02.entities.Order;

import java.util.List;

public interface OrderService {

    public Order save(Order order);

    public List<Order> findAllByUserId(Integer userId);

    public void deleteOrder(Integer orderId);

}
