package com.mycompany.repository.jdbcTemplateClientRepository;



import com.mycompany.domain.Role;
import com.mycompany.domain.User;

import java.util.List;

public interface RoleRepository extends CrudOperations<Long, Role> {


    List<Role> getUserRoles(User user);

    @Override
    List<Role> findAll();

    @Override
    Role findOne(Long id);

    @Override
    Role save(Role entity);

    @Override
    void addOne(Role entity);

    @Override
    void save(List<Role> entities);

    @Override
    Role update(Role entity);

    @Override
    void delete(Long id);
}
