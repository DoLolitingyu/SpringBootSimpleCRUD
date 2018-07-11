package top.dolo.springboot02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.dolo.springboot02.entities.User;
import top.dolo.springboot02.service.UserServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session){
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        boolean login = userService.login(user);
        if(login == true){
            session.setAttribute("LoginName", username);
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户名或密码错误");
            return "/index";
        }
    }

    //注册跳转
    @GetMapping("/reg")
    public String login2() {
        return "redirect:/register.html";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Map<String, Object> map){
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        boolean login = userService.save(user);
        if(login == true){
            return "redirect:/login";
        }else {
            map.put("msg", "用户名或密码错误");
            return "redirect:/register.html";
        }
    }

}
