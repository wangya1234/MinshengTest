package com.inorise.consumer.client;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inorise.consumer.controller.FilmController;
import com.inorise.consumer.domain.Film;

@RestController
public class ConsumerController {
	private Logger logger = LoggerFactory.getLogger(FilmController.class);

	@Autowired
	private ComputeClient computeClient;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		return computeClient.add(a, b);
	}

	@RequestMapping(value = "/min", method = RequestMethod.POST)
	public Integer min(@RequestParam Integer a, @RequestParam Integer b) {
		return computeClient.min(a, b);
	}

	@RequestMapping("/findOne/{id}")

	public Film findOne(@PathVariable(name = "id") Long id) {

		return computeClient.findOne(id);
	}

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private Registration registration;

	// LogUtils是我自己封装的日志类,其实就是LogManager.getLogger(),另外我用的是log4j2
	@GetMapping( "metadata" )
	@ResponseBody
    public String testMetadata () {
        final List< ServiceInstance > instances = discoveryClient.getInstances( registration.getServiceId() );
        instances.forEach( service -> logger.info(
                                                      "host:{}, service_id:{},metadata:{}",
                                                      service.getHost(),
                                                      service.getServiceId(),
                                                      service.getMetadata()
                                              ) );
        return instances.toString() ;
    }
	
	@GetMapping( "host" )
	@ResponseBody
    public List<String> host () {
        final List< ServiceInstance > instances = discoveryClient.getInstances( registration.getServiceId() );
        instances.forEach( service -> logger.info(
                                                      "host:{}, service_id:{},metadata:{}",
                                                      service.getHost(),
                                                      service.getServiceId(),
                                                      service.getMetadata()
                                              ) );
        
      List<String> a = new ArrayList<>();
      for (ServiceInstance s : instances) {
		String sum = "";
		sum +=s.getHost();
		sum+=s.getPort();
		a.add(sum);
	}
        return a;  
    }

}
