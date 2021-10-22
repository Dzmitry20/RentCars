package com.mycompany.domain;

import com.mycompany.domain.status.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

        private Long id;

        private String name;

        private String surname;

        private Long phone;

        private String passportSeries;

        private Integer passportNumber;

        private String email;

        private Integer driverLicenseNumber;

        private String login;

        private String password;

        private Gender gender = Gender.NOT_SELECTED;


        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }


}
