package com.inorise.test;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inorise.daoDemo.MainMethod;
import com.inorise.daoDemo.com.inorise.daoDemo.dao.FilmDao;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import com.inorise.daoDemo.com.inorise.daoDemo.service.ApplicationContextHolder;
import com.inorise.daoDemo.com.inorise.daoDemo.service.FilmServcie;
import com.inorise.daoDemo.com.inorise.daoDemo.service.SpringContextUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainMethod.class)
public class Dfeerer  {
	
	@Autowired
	private  FilmServcie filmService;
	@Autowired
    private    FilmDao filmDao;
	@Autowired
	private static SpringContextUtil springContextUtil;
	
    private   FilmDao filmDaoo = filmDao;
	
    @Test
	public void test2() {
		//Film film = filmService.findOne(1l);
	//	System.out.println(SpringContextUtil.getSpringBean("filmDao"));
		
	//	System.out.println(filmDao.findOne(Long.parseLong("100000000000000004"))); 
		
		FilmDao filmDaoor = (FilmDao) ApplicationContextHolder.getBeanByType(FilmDao.class); 
    	
		System.out.println("--------------++++++++++++++++++++++++\n");
	   	System.out.println("--------------"+filmDaoor.findOne(Long.parseLong("100000000000000005")));
	    
	}
    
    
	@Test
	public void test1() {
		// 创建一个可重用固定线程数的线程池  
        ExecutorService pool = Executors.newFixedThreadPool(5);  
        // 创建线程  
        Thread t1 = new MyThread();  
        Thread t2 = new MyThread();  
        Thread t3 = new MyThread();  
        Thread t4 = new MyThread();  
        Thread t5 = new MyThread();  
        // 将线程放入池中进行执行  
        pool.execute(t1);  
        pool.execute(t2);  
        pool.execute(t3);  
        pool.execute(t4);  
        pool.execute(t5);  
        // 关闭线程池  
        pool.shutdown();  
	}
	
	class MyThread extends Thread {  
		
		
		
		
	    @Override  
	    public void run() {  
	    	
	    	FilmDao FilmDaoo = (FilmDao) ApplicationContextHolder.getBeanByType(FilmDao.class); 
	    	
	    	
	   	System.out.println(filmDaoo.findOne(Long.parseLong("100000000000000004")));
	    	
	    	
//	    	for (int i = 0; i < 100000000; i++) {
//	    		filmService.save(new Film("sd", "String description", 2099, 
//						(byte) 1, (byte) 3, (byte) 6, new BigDecimal(23.99),
//						(short) 86, new BigDecimal(23.99), "G", "Trailers"));
//			}  
	    }  
	}

	 

}
