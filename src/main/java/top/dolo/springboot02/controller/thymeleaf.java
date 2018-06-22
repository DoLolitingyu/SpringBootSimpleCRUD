package top.dolo.springboot02.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.dolo.springboot02.entity.Girl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class thymeleaf {

    @RequestMapping("/thymeleaf")
    public String Test(Map<String, Object> map) {
        map.put("name", "lty");

        Girl mygirl1 = new Girl("zmq", 20, 'C');
        Girl mygirl2 = new Girl("lll", 21, 'A');
        Girl mygirl3 = new Girl("ldy", 23, 'B');
        List<Girl> girls = new ArrayList<Girl>();
        girls.add(mygirl1);
        girls.add(mygirl2);
        girls.add(mygirl3);
        map.put("girls", girls);

        return "mygirls";
    }
}
