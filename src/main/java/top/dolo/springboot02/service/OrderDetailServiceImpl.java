package top.dolo.springboot02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dolo.springboot02.dao.OrderDetailDAO;
import top.dolo.springboot02.entities.OrderDetail;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService   {

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    public List<OrderDetail> findAllByOrderId(Integer orderId) {
        return orderDetailDAO.findAllByOrderid(orderId);
    }

    @Override
    public void deleteAllByOrderId(Integer orderID) {
        orderDetailDAO.deleteAllByOrderid(orderID);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailDAO.save(orderDetail);
    }
}
