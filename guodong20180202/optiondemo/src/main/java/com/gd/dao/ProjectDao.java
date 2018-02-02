package com.gd.dao;

import com.gd.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 郭 on 2018/1/31.
 */
public interface ProjectDao extends JpaRepository<Project,Integer> {

}
