package com.mycompany.repository.hibernate;

import com.mycompany.domain.hibernate.HibernateContract;
import com.mycompany.domain.hibernate.HibernateOrder;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class HibernateContractRepositoryImpl implements HibernateContractRepository {


    private final SessionFactory sessionFactory;

    @Override
    public List<HibernateContract> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return Collections.singletonList(session.find(HibernateContract.class, 1L));
        }
    }


    @Override
    public HibernateContract findOne(Long id) {
        return null;
    }

    @Override
    public HibernateContract save(HibernateContract entity) {
        return null;
    }

    @Override
    public void addOne(HibernateContract entity) {

    }

    @Override
    public void save(List<HibernateContract> entities) {

    }

    @Override
    public HibernateContract update(HibernateContract entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
