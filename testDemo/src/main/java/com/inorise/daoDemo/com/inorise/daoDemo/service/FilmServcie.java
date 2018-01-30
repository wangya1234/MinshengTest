package com.inorise.daoDemo.com.inorise.daoDemo.service;

import com.inorise.daoDemo.com.inorise.daoDemo.dao.FilmDao;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope(value="request")
@Service
public class FilmServcie {
	
	public FilmServcie() {
		// TODO Auto-generated constructor stub
	}

    @Autowired
    private FilmDao filmDao;

    public Film findOne(Long id){
        Film film = filmDao.findOne(id);
        return film;
    }
    public Film save(Film film){
        
        return  filmDao.save(film);
    }

}
