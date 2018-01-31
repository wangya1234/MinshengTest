package com.inorise.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inorise.daoDemo.MainMethod;
import com.inorise.daoDemo.com.inorise.daoDemo.dao.FilmDao;
import com.inorise.daoDemo.com.inorise.daoDemo.service.ApplicationContextHolder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainMethod.class)
public class Rty {

	@Test
	public void test() {
		FilmDao filmDaoor = (FilmDao) ApplicationContextHolder.getBeanByType(FilmDao.class);

		System.out.println("--------------++++++++++++++++++++++++\n");
		System.out.println("--------------" + filmDaoor.findOne(Long.parseLong("100000000000000005")));

	}

}
