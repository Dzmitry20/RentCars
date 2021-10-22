package com.mycompany.controller.hibernate;


import com.mycompany.domain.hibernate.HibernateContract;
import com.mycompany.domain.hibernate.HibernateOrder;
import com.mycompany.repository.hibernate.HibernateContractRepositoryImpl;
import com.mycompany.repository.hibernate.HibernateOrderRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hibernate/contact")
@RequiredArgsConstructor
public class HibernateContractController {

    private final HibernateContractRepositoryImpl hibernateContractRepositoryImpl;

    @GetMapping
    public List<HibernateContract> findAll() {
        System.out.println("In hibernate rest controller");
        return hibernateContractRepositoryImpl.findAll();
    }
}

