package top.dolo.springboot02.service;

import top.dolo.springboot02.entities.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    public List<OrderDetail> findAllByOrderId(Integer orderId);

    public void deleteAllByOrderId(Integer orderID);

    public void save(OrderDetail orderDetail);

}
