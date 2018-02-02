package com.gd.controller;

import com.gd.dao.ProjectDao;
import com.gd.pojo.Project;
import com.gd.utils.TimeTool;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;

/**
 * Created by 郭 on 2018/1/31.
 */
@RestController
public class ProjectController {


    @Autowired
    private ProjectDao projectDao;
    @RequestMapping("/h")
    public String getId(String id){
        return id+"345";

    }
    //8081
    @RequestMapping("home")
    public String home(){
        return "redirect:/templates/h";
    }

    @RequestMapping("/findAll")
    public List<Project> findAll(HttpServletRequest request){
         List<Project> l=projectDao.findAll();
        return l;
    }

    @RequestMapping("/save")
    public String saveProject(){

        for (int i=0;i<10;i++){

            Project project=new Project();
            project.setX_name("鲁班"+i);
            project.setX_address("天津");
            project.setX_begin(TimeTool.getTime(new Date()));
            project.setX_department("人事部");
            project.setX_rental(2000+i*100.0);
            project.setX_year("2014");
            project.setX_stop(TimeTool.getTime(new Date()));
            projectDao.save(project);
        }
        return "执行完成";
    }
    //@RequestMapping("/delete")
    public String deleteAll(){
        projectDao.deleteAll();
        return "删除成功";
    }



}
