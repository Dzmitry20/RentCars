package com.mycompany.repository.springdata;

import com.mycompany.domain.hibernate.HibernateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepositorySpringData extends CrudRepository<HibernateUser, Long>, PagingAndSortingRepository<HibernateUser, Long>, JpaRepository<HibernateUser, Long> {
}
