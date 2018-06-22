package top.dolo.springboot02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.dolo.springboot02.dao.DepartmentDao;
import top.dolo.springboot02.dao.EmployeeDao;
import top.dolo.springboot02.entities.Department;
import top.dolo.springboot02.entities.Employee;

import java.util.Collection;

@Controller
public class CustomersController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //获取员工列表
    @GetMapping("/emps")
    public String findAll(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }

    //页面跳转到添加员工
    @GetMapping("/emp")
    public String add(Model model){
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts", depts);
        return "emp/add";
    }

    //添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //页面跳转到员工编辑
    @GetMapping("/emp/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
//        System.out.println(employee);
        model.addAttribute("emp", employee);

        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts", depts);
        return "emp/add";
    }

    //修改员工信息
    @PutMapping("/emp")
    public String editEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工信息
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
