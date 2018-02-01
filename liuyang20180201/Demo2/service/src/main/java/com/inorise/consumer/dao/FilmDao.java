package com.inorise.consumer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.inorise.consumer.domain.Film;

@Service
public interface FilmDao extends JpaRepository<Film, Long>, JpaSpecificationExecutor<Film> {

}
