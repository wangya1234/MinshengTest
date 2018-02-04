package com.inorise.consumer.helloworld;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inorise.consumer.dao.FilmDao;
import com.inorise.consumer.domain.Film;
import com.inorise.consumer.domain.PageBean;
import com.inorise.consumer.domain.Result;

@RestController
public class PageController {

	 private Logger logger = LoggerFactory.getLogger(PageController.class);

	
	@Autowired
	private DiscoveryClient discoveryClient; // 服务发现客户端

	@Autowired(required = true)
	private FilmDao filmDao;

	@PostMapping(value = "/page/pageQuery")
	public Result pageQuery(@RequestBody PageBean pageBean) {
		
		
		Pageable pageable = new PageRequest(pageBean.getPage() - 1, pageBean.getRows());
		Specification<Film> spec = new Specification<Film>() {
			@Override
			public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				Long id = pageBean.getFilmId();
				if (null != id && 0 != id && !"".equals(pageBean.getFilmId())) {
					list.add(cb.equal(root.get("filmId").as(Long.class), pageBean.getFilmId()));
				}
				if (null != pageBean.getDescription() && !"".equals(pageBean.getDescription())) {
					list.add(cb.like(root.get("description").as(String.class), "%" + pageBean.getDescription() + "%"));
				}

				if (null != pageBean.getReleaseYear() && !"".equals(pageBean.getReleaseYear())) {
					list.add(cb.equal(root.get("releaseYear").as(String.class), pageBean.getReleaseYear()));
				}

				if (null != pageBean.getLength() && 0 != pageBean.getLength() && !"".equals(pageBean.getLength())) {
					list.add(cb.equal(root.get("length").as(Short.class), pageBean.getLength()));
				}
				Predicate[] aa = new Predicate[list.size()];
				return criteriaQuery.where(list.toArray(aa)).getGroupRestriction();
			}
		};

		Page<Film> page1 = filmDao.findAll(spec, pageable);

		List<Film> list = page1.getContent();
		long total = page1.getTotalElements();
		Result result = new Result();
		result.setRows(list);
		result.setTotal(total);
		return result;
	}

	@Override
	public String toString() {
		return "PageController [logger=" + logger + ", discoveryClient=" + discoveryClient + ", filmDao=" + filmDao
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
