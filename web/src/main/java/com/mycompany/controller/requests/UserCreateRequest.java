package com.mycompany.controller.requests;

import com.mycompany.domain.status.Gender;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiOperation("Class for creating user entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

    private String name;

    private String surname;

    private Long phone;

    private String passportSeries;

    private Integer passportNumber;

    private String email;

    private Integer driverLicenseNumber;

    private String login;

    private String password;

    private Gender gender;
}
