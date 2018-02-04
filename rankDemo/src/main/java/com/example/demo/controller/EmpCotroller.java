package com.example.demo.controller;

import com.example.demo.dao.EmpDao;
import com.example.demo.doamin.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yys on 2018/2/2.
 */
@RestController
public class EmpCotroller {
    @Autowired
    private EmpDao empDao;
    @RequestMapping("/findemp")
    public List<Employee> getEmployee(){
        List<Employee> list=empDao.findAll();
        return  list;
    }
}
