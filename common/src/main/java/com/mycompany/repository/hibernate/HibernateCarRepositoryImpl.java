package com.mycompany.repository.hibernate;

import com.mycompany.domain.hibernate.HibernateCar;
import com.mycompany.domain.hibernate.HibernateUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class HibernateCarRepositoryImpl implements HibernateCarRepository{

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManager entityManager;


    @Override
    public List<HibernateCar> findAll() {

        try (Session session = sessionFactory.openSession()) {

            Query<HibernateCar> query = session.createNamedQuery("HibernateCarWithId",HibernateCar.class);
            query.setParameter("id", 4l);
            return query.getResultList();
        }


    }

    @Override
    public HibernateCar findOne(Long id) {
        try (Session session = sessionFactory.openSession()) {

            Query<HibernateCar> query = session.createNamedQuery("HibernateCarWithId2",HibernateCar.class);
            query.setParameter("id", id);

            return query.getSingleResult();
        }
    }

    @Override
    public HibernateCar save(HibernateCar entity) {
        return null;
    }

    @Override
    public void addOne(HibernateCar entity) {

    }

    @Override
    public void save(List<HibernateCar> entities) {

    }

    @Override
    public HibernateCar update(HibernateCar entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
