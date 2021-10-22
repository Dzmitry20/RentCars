package com.mycompany.controller.hibernate;


import com.mycompany.controller.requests.RoleCreateRequest;
import com.mycompany.domain.hibernate.HibernateRole;
import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.repository.hibernate.HibernateRepository;
import com.mycompany.repository.hibernate.HibernateRoleRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hibernate/role")
@RequiredArgsConstructor
public class HibernateRoleController {

    private final HibernateRoleRepositoryImpl hibernateRoleRepository;

    @GetMapping
    public List<HibernateRole> findAll() {
        System.out.println("In hibernate rest controller");
        return hibernateRoleRepository.findAll();
    }

    @GetMapping("/{id}")
    public HibernateRole findOne(@PathVariable Long id) {
        System.out.println("In hibernate rest controller");
        return hibernateRoleRepository.findOne(id);
    }

    @PostMapping
    public  HibernateRole  save(@RequestBody RoleCreateRequest request){

        HibernateRole role = new HibernateRole();
        role.setRoleName(request.getRoleName());

        return hibernateRoleRepository.save(role);
    }
}