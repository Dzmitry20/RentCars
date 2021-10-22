package com.mycompany.repository.hibernate;

import com.mycompany.domain.hibernate.HibernateCar;
import com.mycompany.repository.jdbcTemplateClientRepository.CrudOperations;

import java.util.List;

public interface HibernateCarRepository extends CrudOperations<Long, HibernateCar> {

}