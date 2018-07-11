package top.dolo.springboot02.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.dolo.springboot02.entities.ShopCar;

import java.util.List;

public interface ShopCarDAO extends JpaRepository<ShopCar, Integer> {

    public void deleteAllByUserid(Integer id);

    public List<ShopCar> findAllByUserid(Integer id);

    public ShopCar findByBookid(Integer id);

}
