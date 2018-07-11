package top.dolo.springboot02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.dolo.springboot02.dao.BookDAO;
import top.dolo.springboot02.entities.Book;

import java.util.*;

@Controller
public class BookController {

    @Autowired
    BookDAO bookDAO;

    //获取书本列表
    @GetMapping("/books")
    public String findAll(Model model){
        List<Book> books = bookDAO.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    //页面跳转到添加书本
    @GetMapping("/book")
    public String add(Model model){
        return "book/add";
    }

    //添加书本
    @PostMapping("/book")
    public String addEmp(Book book){
        bookDAO.save(book);
        return "redirect:/books";
    }

    //页面跳转到员工编辑
    @GetMapping("/book/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Model model){
        Book book = bookDAO.findById(id).get();
        model.addAttribute("book", book);
        return "book/add";
    }

    //修改书本信息
    @PutMapping("/book")
    public String editEmp(Book book){
        System.out.println(book);
        bookDAO.save(book);
        return "redirect:/books";
    }

    //删除书本信息
    @DeleteMapping("/book/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        bookDAO.deleteById(id);
        return "redirect:/books";
    }

//    @PostMapping("/book/order/{id}")
//    public String joincar(@PathVariable("id") Integer id){
//        return "redirect:/books";
//    }

}
