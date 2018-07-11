package top.dolo.springboot02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.dolo.springboot02.dao.BookDAO;
import top.dolo.springboot02.dao.UserDAO;
import top.dolo.springboot02.entities.*;
import top.dolo.springboot02.service.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ShopCarController {

    @Autowired
    ShopCarServiceImpl shopCarService;

    @Autowired
    UserDAO userDAO;

    @Autowired
    BookDAO bookDAO;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    OrderDetailServiceImpl orderDetailService;

    //获取购物车列表
    @GetMapping("/cars")
    public String findAll(Model model, HttpSession session){
        String userName = (String)session.getAttribute("LoginName");
        User user = userDAO.findByName(userName);
        List<ShopCar> cars = shopCarService.findAllByUserid(user.getId());
        model.addAttribute("cars", cars);
        double money = 0;
        for (ShopCar car : cars) {
            money +=  car.getNum() * car.getPrice();
        }
        model.addAttribute("money", money);
        return "car/shopcar";
    }

    //购物车添加书
    @PostMapping("/car/{id}")
    public String add(@PathVariable("id") Integer id,HttpSession session){
        ShopCar shopCar = new ShopCar();
        User user = userDAO.findByName((String) session.getAttribute("LoginName"));
        shopCar.setUserid(user.getId());
        shopCar.setBookid(id);
        Book book = bookDAO.findById(id).get();
        shopCar.setPrice(book.getPrice());
        shopCar.setBookName(book.getName());
        ShopCar result = shopCarService.findByBookId(id);
        if(result != null){
            shopCar.setId(result.getId());
            shopCar.setNum(result.getNum()+1);
        }else{
            shopCar.setNum(1);
        }
        shopCarService.save(shopCar);
        return "redirect:/cars";
    }

    //页面跳转到编辑
    @GetMapping("/car/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Model model){
        ShopCar shopCar = shopCarService.findByBookId(id);
        model.addAttribute("car", shopCar);
        return "car/edit";
    }

    //删除一本书本信息
    @DeleteMapping("/car/{id}")
    public String deleteOne(@PathVariable("id") Integer id){
        shopCarService.delete(id);
        return "redirect:/cars";
    }

    //修改书本数量信息
    @PostMapping("/car")
    public String editEmp(Integer id, String bookName, Integer num){
        ShopCar shopCar = shopCarService.findById(id);
        shopCar.setId(id);
        shopCar.setNum(num);
        shopCarService.save(shopCar);
        return "redirect:/cars";
    }

    //删除所有的购物车
    @GetMapping("/cars2")
    @Transactional
    public String deleteAll(HttpSession session){
        String userName = (String)session.getAttribute("LoginName");
        User user = userDAO.findByName(userName);
        shopCarService.removeAll(user.getId());
        return "redirect:/cars";
    }

    //提交订单
    @PostMapping("/cars2")
    @Transactional
    public String subOrder(HttpSession session){
        String userName = (String)session.getAttribute("LoginName");
        User user = userDAO.findByName(userName);
        List<ShopCar> cars = shopCarService.findAllByUserid(user.getId());
        Order order = new Order();
        order.setUserid(user.getId());
        double money = 0;
        for(ShopCar car : cars){
            money += car.getNum()* car.getPrice();
        }
        order.setCost(money);
        Order result = orderService.save(order);
        for(ShopCar car : cars){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setBookid(car.getBookid());
            orderDetail.setNum(car.getNum());
            orderDetail.setOrderid(result.getId());
            orderDetailService.save(orderDetail);
        }
        return "redirect:/orders";
    }
}
