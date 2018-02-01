package com.inorise.consumer.helloworld;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inorise.consumer.dao.FilmDao;
import com.inorise.consumer.domain.Film;



@RestController
public class HelloWorldController {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient discoveryClient; //服务发现客户端

    @Autowired(required=true)
    private FilmDao filmDao;
    

    @RequestMapping("hello")
    public String helloWorld() {
        return "Hello World!";
    }
    
    @RequestMapping("info")
    public String helloWorldinfo() {
        return "info";
    }
    
    @GetMapping(value = "/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
    
    @PostMapping(value = "/min")
    public Integer min(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        int r = a > b ? a: b;
        
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
    
    @RequestMapping("/findOne/{id}")
    public Film findOne(@PathVariable(name="id") Long id) {
    	
    	logger.info(Long.toString(id));
    	Film film = filmDao.findOne(id);
        System.out.println(film);
        return film;
    	
    }


}
