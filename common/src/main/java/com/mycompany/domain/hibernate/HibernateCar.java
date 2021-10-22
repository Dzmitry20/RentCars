package com.mycompany.domain.hibernate;

import com.mycompany.domain.status.CarStatus;
import com.mycompany.domain.status.Transmission;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cars")
@NamedQuery(name = "HibernateCarWithId", query="select c from HibernateCar c where c.id > :id ")
@NamedQuery(name = "HibernateCarWithId2", query="select c from HibernateCar c where c.id = :id ")
public class HibernateCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_car")
    private String nameCar;

    @Column
    private String model;

    @Column(name = "birthday_car")
    private LocalDateTime birthdayCar;

    @Column
    private String color;

    @Column(name = "v_motor")
    private Double vMotor;

    @Column
    private Double power;

    @Column
    @Enumerated(EnumType.STRING)
    private Transmission transmission = Transmission.NOT_SELECTED ;

    @Column(name = "cost_per_day")
    private Double costPerDay;

    @Column(name = "car_status")
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus = CarStatus.NOT_AVAILABLE;


    @Override
    public String  toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

