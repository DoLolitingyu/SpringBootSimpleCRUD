package top.dolo.springboot02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import top.dolo.springboot02.dao.UserDAO;
import top.dolo.springboot02.entities.Order;
import top.dolo.springboot02.entities.OrderDetail;
import top.dolo.springboot02.entities.User;
import top.dolo.springboot02.service.OrderDetailServiceImpl;
import top.dolo.springboot02.service.OrderServiceImpl;

import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Controller
public class OrderController {


    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    OrderDetailServiceImpl orderDetailServicel;

    @Autowired
    UserDAO userDAO;

    //获取订单列表
    @GetMapping("/orders")
    public String findAll(Model model, HttpSession session){
        String userName = (String)session.getAttribute("LoginName");
        User user = userDAO.findByName(userName);
        List<Order> orders = orderService.findAllByUserId(user.getId());
        model.addAttribute("orders", orders);
        return "order/list";
    }

    //获取订单详情
    @GetMapping("/order/{id}")
    public String seeOne(@PathVariable("id") Integer id, Model model){
        List<OrderDetail> result = orderDetailServicel.findAllByOrderId(id);
        model.addAttribute("orderdetails", result);
        return "orderdetail/list";
    }

    //删除订单信息
    @DeleteMapping("/order/{id}")
    @Transactional
    public String deleteEmp(@PathVariable("id") Integer id){
        orderService.deleteOrder(id);
        orderDetailServicel.deleteAllByOrderId(id);
        return "redirect:/orders";
    }
}
