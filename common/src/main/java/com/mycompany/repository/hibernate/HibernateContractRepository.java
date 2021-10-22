package com.mycompany.repository.hibernate;

import com.mycompany.domain.hibernate.HibernateContract;
import com.mycompany.repository.jdbcTemplateClientRepository.CrudOperations;

public interface HibernateContractRepository extends CrudOperations<Long, HibernateContract> {
}
