package com.mycompany.controller;


import com.mycompany.beans.SecurityConfig;
import com.mycompany.domain.User;
import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.domain.status.Gender;
import com.mycompany.repository.jdbcTemplateClientRepository.UserRepository;
import com.mycompany.repository.springdata.UserRepositorySpringData;
import com.mycompany.security.utils.PrincipalUtils;
import com.mycompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/usersdata")
@RequiredArgsConstructor
public class UserSpringDataController {

    private final UserRepositorySpringData userRepositorySpringData;

    private final UserService userService;


    @GetMapping
    public List<HibernateUser> findAll() {
        System.out.println("In springData controller");
        return userRepositorySpringData.findAll();
//        return userRepositorySpringData.findAll(PageRequest.of(1, 8, Sort.by(Sort.Direction.DESC, "id")));
    }
    @GetMapping("/byname")
    public List<HibernateUser> find(@RequestParam String name, @RequestParam String surname) {
        System.out.println("In springData controller");
        return userRepositorySpringData.findHibernateUserByNameAndSurname(name, surname);

    }

    @GetMapping("/bygender")
    public HibernateUser find(@RequestParam Gender gender) {
        System.out.println("In springData controller");
        return userRepositorySpringData.findHibernateUserByGenderIs(gender);

    }
    @GetMapping("/bylistid")
    public List<HibernateUser> find(@RequestParam List<Long> ids) {
        System.out.println("In springData controller");
        return userRepositorySpringData.findByIdIn(ids);
    }
    @GetMapping("/{id}")
    public HibernateUser find(@PathVariable Long id) {
        System.out.println("In springData controller");
        return userRepositorySpringData.findByIdHQLVersion(id);
    }

    @GetMapping("/test/{userId}")
    public List<Object[]> searchTest(@PathVariable Long userId) {
        System.out.println("In rest controller");
        return userRepositorySpringData.findByIdHQLVersionSimplified2(userId);
    }

    @GetMapping("/test/qwert")
    public int createSomeRow(@RequestParam Long userId, @RequestParam Long roleId) {
        System.out.println("In rest controller");
        return userRepositorySpringData.createSomeRow(userId,roleId);
    }

    @GetMapping("/test/giveRole")
    public int giveRole(@RequestParam String login, @RequestParam String roleName) {
        System.out.println("In rest controller");
        return userService.givRole(login,roleName);
    }



}
