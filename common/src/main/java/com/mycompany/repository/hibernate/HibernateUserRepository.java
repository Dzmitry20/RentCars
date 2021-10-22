package com.mycompany.repository.hibernate;


import com.mycompany.domain.SearchRequest;
import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.repository.jdbcTemplateClientRepository.CrudOperations;

import java.util.List;

public interface HibernateUserRepository extends CrudOperations<Long, HibernateUser> {

    List<HibernateUser> criteriaApiSearch(SearchRequest request);





}
