package com.inorise.consumer.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


@RunWith(SpringJUnit4ClassRunner.class)

public class MyTesthttp {
	
	 private Logger logger = LoggerFactory.getLogger(MyTesthttp.class);


	 OkHttpClient client = new OkHttpClient();

	  String run(String url) throws IOException {
	    Request request = new Request.Builder()
	        .url(url)
	        .build();

	    try (Response response = client.newCall(request).execute()) {
	      return response.body().string();
	    }
	  }
	  
	  
	  
	  
	  @Test
	  public void test1() throws IOException {
		  
	
		  
		  MyTesthttp example = new MyTesthttp();
	    String response = example.run
	    		("http://l0m6sb0d9z9dmmn:9001/host");
	    
	   
	    
	    
	  }
	

}
