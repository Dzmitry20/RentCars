package com.mycompany.controller.hibernate;


import com.mycompany.domain.SearchRequest;
import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.repository.hibernate.HibernateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hibernate")
@RequiredArgsConstructor
public class HibernateUserController {

    private final HibernateRepository hibernateRepository;

    @GetMapping
    public List<HibernateUser> findAll() {
        System.out.println("In hibernate rest controller");
        return hibernateRepository.findAll();
    }

    @GetMapping("/search")
    public List<HibernateUser> search(@ModelAttribute SearchRequest request) {
        return hibernateRepository.criteriaApiSearch(request);
    }
}

