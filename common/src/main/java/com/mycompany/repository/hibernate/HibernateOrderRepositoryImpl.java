package com.mycompany.repository.hibernate;

import com.mycompany.domain.hibernate.HibernateOrder;
import com.mycompany.domain.hibernate.HibernateUser;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HibernateOrderRepositoryImpl implements HibernateOrderRepository{

    private final SessionFactory sessionFactory;

    @Override
    public List<HibernateOrder> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return Collections.singletonList(session.find(HibernateOrder.class, 1L));
        }
    }


    @Override
    public HibernateOrder findOne(Long id) {
        return null;
    }

    @Override
    public HibernateOrder save(HibernateOrder entity) {
        return null;
    }

    @Override
    public void addOne(HibernateOrder entity) {

    }

    @Override
    public void save(List<HibernateOrder> entities) {

    }

    @Override
    public HibernateOrder update(HibernateOrder entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
