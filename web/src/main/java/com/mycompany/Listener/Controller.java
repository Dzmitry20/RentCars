package com.mycompany.Listener;


import com.mycompany.controller.requests.UserCreateRequest;
import com.mycompany.domain.User;
import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.repository.jdbcTemplateClientRepository.UserRepository;
import com.mycompany.repository.springdata.UserRepositorySpringData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/rest/users1")
@RequiredArgsConstructor
public class Controller {


    private final UserRepositorySpringData userRepository;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PostMapping("/user/regist")
    public HibernateUser registerUserAccount(
            @RequestBody UserCreateRequest createRequest,
            HttpServletRequest request) {

        HibernateUser newUser = new HibernateUser();
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

        HibernateUser savedUser = userRepository.save(newUser);

        String appUrl = request.getContextPath();
           eventPublisher.publishEvent(new OnRegistrationCompleteEvent(savedUser,
                  request.getLocale(), appUrl));


//        try {
//            User registered = userService.registerNewUserAccount(userDto);
//
//            String appUrl = request.getContextPath();
//            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered,
//                    request.getLocale(), appUrl));
//        } catch (UserAlreadyExistException uaeEx) {
//            ModelAndView mav = new ModelAndView("registration", "user", userDto);
//            mav.addObject("message", "An account for that username/email already exists.");
//            return mav;
//        } catch (RuntimeException ex) {
//            return new ModelAndView("emailError", "user", userDto);
//        }

        return savedUser;
    }
}
