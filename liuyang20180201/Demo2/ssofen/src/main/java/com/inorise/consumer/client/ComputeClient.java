package com.inorise.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inorise.consumer.domain.Film;
import com.inorise.consumer.domain.PageBean;
import com.inorise.consumer.domain.Result;

@FeignClient("micro-weather-eureka-client")
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
    
    @RequestMapping(method = RequestMethod.POST, value = "/min")
    Integer min(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
    
    @RequestMapping("/findOne/{id}")
    Film findOne(@PathVariable(name="id") Long id);


	
	@RequestMapping(method = RequestMethod.POST, value = "/page/pageQuery")
	Result pageQuery(@RequestBody PageBean pageBean);

}

