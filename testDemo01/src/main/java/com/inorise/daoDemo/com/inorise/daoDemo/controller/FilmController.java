package com.inorise.daoDemo.com.inorise.daoDemo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import com.inorise.daoDemo.com.inorise.daoDemo.dao.FilmDao;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.PageBean;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Result;

@RestController
@RequestMapping(value="/film")
public class FilmController {

    private Logger logger = LoggerFactory.getLogger(FilmController.class);

    @Autowired
    private FilmDao filmDao;

//
//    @RequestMapping("/pageQuery")
//    public Result pageQuery(final PageBean pageBean){
    

   // @RequestMapping
    @RequestMapping("/delete")
    public void delete(final PageBean pageBean) throws IOException{
        
    	logger.info(pageBean.getIds());
    	String ids=  pageBean.getIds();
    	
    	if(pageBean.getIds().contains(",")) 
    	{
    		String[] idss = ids.split(",");
    		for (String stringg : idss) {
    			filmDao.delete(Long.valueOf(stringg));
			}
    		
    	}else
    	{
    		filmDao.delete(Long.valueOf(pageBean.getIds()));
    	}
    	
    	HttpServletRequest requestRequest = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	
    	
    	HttpServletResponse responseResponse = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();

    
    	//ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
    	
    	responseResponse.sendRedirect(requestRequest.getContextPath()+"/page.html");
    
    	
    }
    
    @RequestMapping("/findOne/{id}")
    public Film findOne(@PathVariable(name="id") Long id){
        Film film = filmDao.findOne(id);
        System.out.println(film);
        return film;
    }
    
    @RequestMapping("/findOner/{id}")
    public Film findOner(@PathVariable(name="id") Long id){
        Film film = filmDao.findOne(id);
        System.out.println(film);
        return film;
    }

    /**
     * 分页查询方法
     * @param
     * @param
     * @return resultJson对象
     */
    @RequestMapping("/pageQuery")
    public Result pageQuery(final PageBean pageBean){
    	
    	
    	
    	
    	
    	Long a= System.currentTimeMillis();
    	
    	
    	
    	
    	
    	
    	
        Pageable pageable = new PageRequest(pageBean.getPage()-1,pageBean.getRows());
        Specification<Film> spec = new Specification<Film>() {
            @Override
            public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                Long id = pageBean.getFilmId();
                if (null != id && 0 != id && !"".equals(pageBean.getFilmId())) {
                      list.add(cb.equal(root.get("filmId").as(Long.class),pageBean.getFilmId()));
                }
                if (null != pageBean.getDescription() && !"".equals(pageBean.getDescription())) {
              list.add(cb.like(root.get("description").as(String.class),"%" + pageBean.getDescription() + "%"));
                 }

                if (null != pageBean.getReleaseYear() && !"".equals(pageBean.getReleaseYear())) {
                    list.add(cb.equal(root.get("releaseYear").as(String.class),pageBean.getReleaseYear()));
                }

                if (null != pageBean.getLength() && 0 != pageBean.getLength() && !"".equals(pageBean.getLength())){
                     list.add(cb.equal(root.get("length").as(Short.class),pageBean.getLength()));
                }
                   Predicate[] aa = new Predicate[list.size()];
                    return criteriaQuery.where(list.toArray(aa)).getGroupRestriction();
            }
        };




        Page<Film> page1 = filmDao.findAll(spec,pageable);

        List<Film> list = page1.getContent();
        long total = page1.getTotalElements();
        Result result = new Result();
        result.setRows(list);
        result.setTotal(total);
        
        
        
        
        

    
    	
    	Long b= System.currentTimeMillis();
    	
    	double c= (b-a)/(double)1000;
    	
    	logger.info("分页page调用所花的时间：" + String.valueOf(c) );
        
        
        
        return result;

    }
  /*  @RequestMapping("/pageQuery")
    public Result pageQuery(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows,Film film){



        Pageable pageable = new PageRequest(page-1,rows);
        Page<Film> page1 = filmDao.findAll(pageable);

        List<Film> list = page1.getContent();
        long total = page1.getTotalElements();
        Result result = new Result();
        result.setRows(list);
        result.setTotal(total);
        return result;

    }
*/
    /**
     * 保存方法
     * @param film
     */
    @RequestMapping("/save")
    public void save(Film film) {
    	filmDao.save(film);
    }
    
    
    /**
     * 单元测试方法
     * @return
     */
    @RequestMapping("/hello")
    public String helloWorld() {
    	return "Hello World";
    }





}
