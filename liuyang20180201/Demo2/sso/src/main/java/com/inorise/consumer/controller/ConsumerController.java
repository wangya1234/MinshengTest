package com.inorise.consumer.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    private Logger logger = Logger.getLogger(getClass().toGenericString());

   
    	@GetMapping(value = "/info")
        public String info() {
            return restTemplate.getForEntity("http://micro-weather-eureka-client/info", String.class).getBody();
        }

    	
    	@GetMapping(value = "/add")
        public String add() {
            return restTemplate.getForEntity("http://micro-weather-eureka-client/add?a=10&b=20", String.class).getBody();
        }

        
    }

