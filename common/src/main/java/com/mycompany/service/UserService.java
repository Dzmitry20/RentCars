package com.mycompany.service;


import com.mycompany.domain.hibernate.HibernateRole;
import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.repository.hibernate.HibernateRoleRepository;
import com.mycompany.repository.hibernate.HibernateUserRepository;
import com.mycompany.repository.springdata.RoleRepositorySpringData;
import com.mycompany.repository.springdata.UserRepositorySpringData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final RoleRepositorySpringData roleRepositorySpringData;

    private final UserRepositorySpringData userRepositorySpringData;


     public int  givRole(String login,String roleName) {

         HibernateUser user = userRepositorySpringData.findHibernateUserByLogin(login);

         HibernateRole role = roleRepositorySpringData.findHibernateRoleByRoleName(roleName);

       return  userRepositorySpringData.createSomeRow(user.getId(), role.getId());

     }

}
