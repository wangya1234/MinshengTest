package com.inorise.daoDemo.com.inorise.daoDemo.service;

import com.inorise.daoDemo.com.inorise.daoDemo.dao.FilmDao;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.inorise.daoDemo.com.inorise.daoDemo.domain.Film.*;

@Service
public class FilmServcie {

    @Autowired
    private FilmDao filmDao;

    public Film findOne(Long id){
        Film film = filmDao.findOne(id);
        return film;
    }

   /* public static Specification<Film> getSpec(final Integer filmId, final String description, final Integer releaseYear,final Integer length) {
        return new Specification<Film>() {
            @Override
            public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1 = null;
                if (filmId != 0) {
                    System.out.println("正在操作age！！！");
                    Predicate p2 = cb.equal(root.get("filmId"), filmId);
                    if (p1 != null) {
                        p1=cb.and(p1, p2);
                    }  else {
                        p1 = p2;
                    }
                }
                if (false==description.isEmpty()) {
                    System.out.println("正在操作name！！！");
                    Predicate p2 = cb.equal(root.get("description"), description);
                    if (p1 != null) {
                        p1=cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (releaseYear != 0) {
                    System.out.println("正在操作high！！！");
                    Predicate p2 = cb.equal(root.get("length"), releaseYear);
                    if (p1 != null) {
                        p1=cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (length != 0) {
                    System.out.println("正在操作high！！！");
                    Predicate p2 = cb.equal(root.get("length"), length);
                    if (p1 != null) {
                        p1=cb.and(p1,p2);
                    } else {
                        p1 = p2;
                    }
                }
                return p1;
            }
        };
    }
*/



}
