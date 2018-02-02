package com.gd.dao;

import com.gd.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 郭 on 2018/2/2.
 */
public interface EmpDao  extends JpaRepository<Employee,Integer>{
}
