package com.mycompany.repository.hibernate;

import com.mycompany.domain.hibernate.HibernateOrder;
import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.repository.jdbcTemplateClientRepository.CrudOperations;

public interface HibernateOrderRepository extends CrudOperations<Long, HibernateOrder> {


}
