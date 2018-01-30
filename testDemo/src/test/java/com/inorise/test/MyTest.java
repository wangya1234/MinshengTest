package com.inorise.test;

import com.inorise.daoDemo.MainMethod;
import com.inorise.daoDemo.com.inorise.daoDemo.dao.FilmDao;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import com.inorise.daoDemo.com.inorise.daoDemo.service.ApplicationContextHolder;
import com.inorise.daoDemo.com.inorise.daoDemo.service.FilmServcie;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainMethod.class)
public class MyTest {

	@Autowired
	private FilmServcie filmService;
	@Autowired
	private FilmDao filmDao;

	@Test
	public void test1() {
		System.out.println("--------------++++++++++++++++++++++++\n");
		FilmDao filmDaoor = (FilmDao) ApplicationContextHolder.getBeanByType(FilmDao.class);

		System.out.println("--------------++++++++++++++++++++++++\n");
		System.out.println("--------------" + filmDaoor.findOne(Long.parseLong("100000000000000005")));

	}

//	@Test
//	public void test2() {
//
//		for (int i = 0; i < 100000000; i++) {
//			filmDao.save(new Film("sd", "String description", 2099, 
//					(byte) 1, (byte) 3, (byte) 6, new BigDecimal(23.99),
//					(short) 86, new BigDecimal(23.99), "G", "Trailers"));
//		}
//	}

}
