package top.dolo.springboot02.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.dolo.springboot02.dao.OrderDAO;
import top.dolo.springboot02.entities.Order;


import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Autowired
    OrderDAO orderDAO;

    @Test
    public void save() {
        Order order = new Order();
        order.setCost(123);
        order.setUserid(1);
        orderDAO.save(order);
    }

    @Test
    public void findAllByUserId() {
    }

    @Test
    public void deleteOrder() {
    }
}