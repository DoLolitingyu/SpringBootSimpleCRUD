package top.dolo.springboot02.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dolo.springboot02.entities.Order;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order,Integer>{

    public List<Order> findAllByUserid(Integer id);

    public void deleteById(Integer id);

}
