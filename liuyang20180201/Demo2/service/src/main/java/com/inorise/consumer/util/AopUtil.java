package com.inorise.consumer.util;

import java.util.ArrayList;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopUtil {

	private Logger logger = LoggerFactory.getLogger(AopUtil.class);

	
	@Pointcut("execution(* com.inorise.consumer.dao.FilmDao.*(..))")
	public void ComputeClient() {
	}

	@Around("ComputeClient()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		

		Long a = System.currentTimeMillis();

		 Object result=pjp.proceed();
		 
		 Object[] args = pjp.getArgs();
		 ArrayList<String> argsString = new ArrayList<String>();
		 
		 for (Object string : args) {
			 argsString.add(string.toString());
		}

		Long b = System.currentTimeMillis();

		double c = (b - a) / (double) 1000;

		logger.info("调用的方法:[{}],,使用的时间[{}]" , pjp.getSignature().getName() ,  c);
		logger.info("传入的方法参数[{}]" , argsString);
		  return result;
	}

}