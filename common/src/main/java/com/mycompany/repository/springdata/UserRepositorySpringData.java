package com.mycompany.repository.springdata;

import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.domain.status.Gender;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Repository
public interface UserRepositorySpringData extends CrudRepository<HibernateUser, Long>, PagingAndSortingRepository<HibernateUser, Long> , JpaRepository<HibernateUser, Long> {

        List<HibernateUser> findHibernateUserByNameAndSurname(String name, String surname);

        HibernateUser findHibernateUserByGenderIs(Gender gender);

        List<HibernateUser> findByIdIn(List<Long> ids);

        @Cacheable("goods")
        @Query(value = "select u from HibernateUser u where u.id = :userId")
        HibernateUser findByIdHQLVersion(@Param("userId") Long id);


        @Query(value = "select * from users where id = :userID", nativeQuery = true)
        List<HibernateUser> findByIdSQLVersion(@Param("userID") Long id);

        @Query(value = "select u.id, u.name from HibernateUser u where u.id = :userID")
        Object[] findByIdHQLVersionSimplified(@Param("userID") Long id);

        @Query(value = "select u.id, u.name from HibernateUser u where u.id > :userID")
        List<Object[]> findByIdHQLVersionSimplified2(@Param("userID") Long id);

        @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = SQLException.class)
        @Modifying
        @Query(value = "insert into user_roles(users_id, role_id) values (:users_id, :role_id)", nativeQuery = true)
        int createSomeRow(@Param("users_id") Long userId, @Param("role_id") Long roleId);


        HibernateUser findHibernateUserByLogin(String login);

        @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = SQLException.class)
        @Modifying
        @Query(value = "UPDATE user_photos SET link = :userPhotoLink , user_id = :userId FROM users WHERE users.id = user_photos.user_id;", nativeQuery = true)
        int saveUser(@Param("userPhotoLink")String userPhotoLink,@Param("userId") Long userId);

        @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = SQLException.class)
        @Modifying
        @Query(value = "insert into user_photos(link, user_id) values (:userPhotoLink, :userId)", nativeQuery = true)
        int createRow(@Param("userPhotoLink")String userPhotoLink,@Param("userId") Long userId);




        @Query(value = "select * from users u INNER JOIN user_photos p ON p.user_id = u.id where users.id =", nativeQuery = true)
        HibernateUser findByPhoto();



}
