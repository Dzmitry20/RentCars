package com.mycompany.controller;

import com.mycompany.Listener.EmailSenderService;
import com.mycompany.controller.requests.UserCreateRequest;
import com.mycompany.domain.Role;
import com.mycompany.domain.User;
import com.mycompany.repository.jdbcTemplateClientRepository.RoleRepository;
import com.mycompany.repository.jdbcTemplateClientRepository.UserRepository;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {


    private final EmailSenderService service;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @ApiOperation(value = "Creating one user")
    @PostMapping
    public User createUser(@RequestBody UserCreateRequest createRequest) {

        service.sendSimpleEmail("zhdv27@mail.ru",
                "This is Email Body with Attachment...",
                "This email has attachment");

        User newUser = new User();
        newUser.setName(createRequest.getName());
        newUser.setSurname(createRequest.getSurname());
        newUser.setPhone(createRequest.getPhone());
        newUser.setPassportSeries(createRequest.getPassportSeries());
        newUser.setPassportNumber(createRequest.getPassportNumber());
        newUser.setEmail(createRequest.getEmail());
        newUser.setDriverLicenseNumber(createRequest.getDriverLicenseNumber());
        newUser.setLogin(createRequest.getLogin());
        newUser.setPassword(createRequest.getPassword());
        newUser.setGender(createRequest.getGender());

        User savedUser = userRepository.save(newUser);

        List<Role> roles = roleRepository.findAll();

        userRepository.saveUserRoles(savedUser, roles);

        return savedUser;
    }

}
