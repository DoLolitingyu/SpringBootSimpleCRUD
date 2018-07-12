package top.dolo.springboot02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.dolo.springboot02.service.OrderDetailServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
public class OrderDetailController {

    @Autowired
    OrderDetailServiceImpl orderDetailService;

//    //获取某个订单详情
//    @GetMapping("/oriderdetal/{id}")
//    public String findAll(@PathVariable("id") Integer id, Model model, HttpSession session){
//        String userName = (String)session.getAttribute("LoginName");
//        User user = userDAO.findByName(userName);
//        List<Order> orders = orderService.findAllByUserId(user.getId());
//        model.addAttribute("orders", orders);
//        return "order/list";
//    }

}
