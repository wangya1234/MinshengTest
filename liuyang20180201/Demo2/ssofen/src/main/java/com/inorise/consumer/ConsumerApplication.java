package com.inorise.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import feign.Request;

@EnableDiscoveryClient // 用于启动服务发现功能
@EnableFeignClients // 用于启动Fegin功能
@SpringBootApplication

@EnableEurekaClient

@EnableHystrix
@EnableHystrixDashboard
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		simpleClientHttpRequestFactory.setConnectTimeout(50000);
		simpleClientHttpRequestFactory.setReadTimeout(50000);
		return new RestTemplate(simpleClientHttpRequestFactory);
	}
	
	
	@Bean
    Request.Options feignOptions() {
        return new Request.Options(/**connectTimeoutMillis**/900 * 1000, /** readTimeoutMillis **/900 * 1000);
    }
}
