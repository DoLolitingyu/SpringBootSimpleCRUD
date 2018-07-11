package top.dolo.springboot02.service;

import top.dolo.springboot02.entities.ShopCar;

import java.util.List;

public interface ShopCarService {

    public ShopCar save(ShopCar shopCar);

    public void delete(Integer id);

    public void removeAll(Integer id);

    public List<ShopCar> findAllByUserid(Integer id);

    public ShopCar findById(Integer id);

    public ShopCar findByBookId(Integer id);
}
