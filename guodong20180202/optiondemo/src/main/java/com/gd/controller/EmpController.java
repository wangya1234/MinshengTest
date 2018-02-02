package com.gd.controller;

import com.gd.dao.EmpDao;
import com.gd.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 郭 on 2018/2/2.
 */
@RestController
public class EmpController {
    @Autowired
    private EmpDao empDao;
    @RequestMapping("/empAll")
    public List<Employee> findAll(){
        return empDao.findAll();
    }
}
