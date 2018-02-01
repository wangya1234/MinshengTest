package com.inorise.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    private Logger logger = Logger.getLogger(getClass().toGenericString());

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer()
    {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
        String body = forEntity.getBody();
        logger.info(body);
        return body;
    }
}
