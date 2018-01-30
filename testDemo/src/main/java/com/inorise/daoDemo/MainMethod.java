package com.inorise.daoDemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class MainMethod {

    public static void main(String[] args) {
        SpringApplication.run(MainMethod.class,args);
    }
    
    @Scheduled(cron="0/1 * * * * ? *")
    public void A()
    {
    	System.out.println("sd");
    }

}
