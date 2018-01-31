package com.inorise.daoDemo.com.inorise.daoDemo.dao;

import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmDao extends JpaRepository<Film,Long>,JpaSpecificationExecutor<Film> {



}
