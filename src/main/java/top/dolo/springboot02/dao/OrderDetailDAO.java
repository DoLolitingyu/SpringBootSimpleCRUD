package top.dolo.springboot02.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dolo.springboot02.entities.OrderDetail;

import java.util.List;

public interface OrderDetailDAO extends JpaRepository<OrderDetail,Integer> {

    public List<OrderDetail> findAllByOrderid(Integer orderid);

    public void deleteAllByOrderid(Integer orderid);

}
