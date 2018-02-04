package com.example.demo.dao;

import com.example.demo.doamin.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yys on 2018/2/2.
 */
public interface EmpDao extends JpaRepository<Employee,Integer> {
}
