package com.mycompany.domain;

import com.mycompany.domain.status.CarStatus;
import com.mycompany.domain.status.Transmission;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Car {

        private Long id;

        private String nameCar;

        private String model;

        private LocalDateTime birthdayCar;

        private String color;

        private Double vMotor;

        private Double power;

        private Transmission transmission = Transmission.NOT_SELECTED ;

        private Double costPerDay;

        private CarStatus carStatus = CarStatus.NOT_AVAILABLE;


        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }
}

