package com.inorise.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HelloWorldController {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));


    @RequestMapping("hello")
    public String helloWorld() {
        return "Hello World!";
    }

}
