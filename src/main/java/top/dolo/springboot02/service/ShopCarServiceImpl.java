package top.dolo.springboot02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dolo.springboot02.dao.ShopCarDAO;
import top.dolo.springboot02.entities.ShopCar;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    ShopCarDAO shopCarDAO;

    @Override
    public ShopCar save(ShopCar shopCar) {
        return shopCarDAO.save(shopCar);
    }

    @Override
    public void delete(Integer id) {
        shopCarDAO.deleteById(id);
    }

    @Override
    public void removeAll(Integer id) {
        shopCarDAO.deleteAllByUserid(id);
    }

    @Override
    @Transactional
    public List<ShopCar> findAllByUserid(Integer id) {
        return shopCarDAO.findAllByUserid(id);
    }

    @Override
    public ShopCar findByBookId(Integer id) {
        return shopCarDAO.findByBookid(id);
    }

    @Override
    public ShopCar findById(Integer id) {
        return shopCarDAO.findById(id).get();
    }
}
