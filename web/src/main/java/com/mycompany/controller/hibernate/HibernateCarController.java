package com.mycompany.controller.hibernate;

import com.mycompany.domain.hibernate.HibernateCar;
import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.repository.hibernate.HibernateCarRepository;
import com.mycompany.repository.hibernate.HibernateContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/hibernate/car")
@RequiredArgsConstructor
public class HibernateCarController {

    private final HibernateCarRepository hibernateCarRepository;


    @GetMapping
    public List<HibernateCar> findAll() {
        System.out.println("In hibernate rest controller");
        return hibernateCarRepository.findAll();
    }

    @GetMapping("/{id}")
    public HibernateCar findOne(@PathVariable Long id) {
        System.out.println("In hibernate rest controller");
        return hibernateCarRepository.findOne(id);
    }


}
