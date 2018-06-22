package top.dolo.springboot02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session){
        if("lty".equals(username) && "qq".equals(password)){
            session.setAttribute("LoginName", username);
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户名或密码错误");
            return "/index";
        }
    }
}
