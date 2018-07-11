package top.dolo.springboot02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dolo.springboot02.dao.OrderDAO;
import top.dolo.springboot02.entities.Order;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    public Order save(Order order) {
        return orderDAO.save(order);
    }

    @Override
    public List<Order> findAllByUserId(Integer userId) {
        return orderDAO.findAllByUserid(userId);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderDAO.deleteById(orderId);
    }
}
