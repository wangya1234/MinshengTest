package com.inorise.daoDemo.com.inorise.daoDemo.dao;

import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Scope(value="prototype")
public interface FilmDao extends JpaRepository<Film,Long> {

}
