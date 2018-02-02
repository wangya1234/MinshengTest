package com.gd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class OptiondemoApplication {

	public static void main(String[] args) {
		System.out.println(new Date().getTime()+"dskajfkdjfsljdflsjfasldfjskdfjdk");
		SpringApplication.run(OptiondemoApplication.class, args);
	}

}
