package com.mycompany.controller.hibernate;

import com.mycompany.domain.hibernate.HibernateOrder;
import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.repository.hibernate.HibernateOrderRepositoryImpl;
import com.mycompany.repository.hibernate.HibernateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hibernate/order")
@RequiredArgsConstructor
public class HibernateOrderController {

    private final HibernateOrderRepositoryImpl hibernateOrderRepositoryImpl;

    @GetMapping
    public List<HibernateOrder> findAll() {
        System.out.println("In hibernate rest controller");
        return hibernateOrderRepositoryImpl.findAll();
    }
}

