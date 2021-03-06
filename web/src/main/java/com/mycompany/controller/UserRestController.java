package com.mycompany.controller;

import com.mycompany.beans.SecurityConfig;
import com.mycompany.domain.User;
import com.mycompany.repository.jdbcTemplateClientRepository.UserRepository;
import com.mycompany.security.utils.PrincipalUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserRepository userRepository;
    private final SecurityConfig config;
    private final PrincipalUtils principalUtils;

    @GetMapping
    public List<User> findAll() {
        System.out.println("In rest controller");
        return userRepository.findAll();
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "Secret-Key", dataType = "string", paramType = "header",
                    value = "Secret header for secret functionality!! Hoho"),
            @ApiImplicitParam(name = "X-Auth-Token", value = "token", required = true, dataType = "string", paramType = "header")

    })
    @GetMapping("/hello")
    public List<User> securedFindAll(HttpServletRequest request, @ApiIgnore Principal principal) {

        String username = principalUtils.getUsername(principal);

        String secretKey = request.getHeader("Secret-Key");

        User user = userRepository.findByLogin(username);


        if (StringUtils.isNotBlank(secretKey) && secretKey.equals(config.getSecretKey())) {
            return Collections.singletonList(user);
        } else {
            //throw new UnauthorizedException();
            return Collections.emptyList();
        }
    }

//    @GetMapping("/search")
//    public List<User> userSearch(@RequestParam Integer limit, @RequestParam String query) {
//        return userRepository.findUsersByQuery(limit, query);
//    }
//
//    @PostMapping
//    public User createUser(@ModelAttribute UserCreateRequest createRequest) {
//        User generatedUser = userGenerator.generate();
//        generatedUser.setWeight(createRequest.getWeight());
//        generatedUser.setLogin(createRequest.getLogin());
//
//        return userRepository.save(generatedUser);
//    }
//
//    @ApiOperation(value = "Generate auto users in system")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "usersCount", dataType = "string", paramType = "path",
//                    value = "Count of generated users", required = true, defaultValue = "100")
//    })
//    @PostMapping("/generate/{usersCount}")
//    public List<User> generateUsers(@PathVariable("usersCount") Integer count) {
//        throw new RuntimeException("Haha!");
////        List<User> generateUsers = userGenerator.generate(count);
////        userRepository.batchInsert(generateUsers);
////
////        return userRepository.findAll();
//    }
}
