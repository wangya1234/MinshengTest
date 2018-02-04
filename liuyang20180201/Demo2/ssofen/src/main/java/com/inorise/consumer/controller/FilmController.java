package com.inorise.consumer.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inorise.consumer.client.ComputeClient;
import com.inorise.consumer.domain.PageBean;
import com.inorise.consumer.domain.Result;

@RestController
@RequestMapping(value = "/film")
public class FilmController {

	private Logger logger = LoggerFactory.getLogger(FilmController.class);

	@Autowired
	private ComputeClient computeClient;

	@RequestMapping(value = "/pageQuery", method = RequestMethod.POST)
	public Result pageQuery(PageBean pageBean) {
	
		Result r = computeClient.pageQuery(pageBean);

		return r;

	}

	@RequestMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}

}
