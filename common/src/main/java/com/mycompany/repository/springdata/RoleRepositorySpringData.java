package com.mycompany.repository.springdata;

import com.mycompany.domain.hibernate.HibernateRole;
import com.mycompany.domain.hibernate.HibernateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepositorySpringData extends CrudRepository<HibernateRole, Long>, PagingAndSortingRepository<HibernateRole, Long>, JpaRepository<HibernateRole, Long> {

        HibernateRole findHibernateRoleByRoleName(String roleName);

}
