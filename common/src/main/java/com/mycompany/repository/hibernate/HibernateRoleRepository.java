package com.mycompany.repository.hibernate;

import com.mycompany.domain.hibernate.HibernateRole;
import com.mycompany.repository.jdbcTemplateClientRepository.CrudOperations;

public interface HibernateRoleRepository extends CrudOperations<Long, HibernateRole> {
}
