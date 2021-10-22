package com.mycompany;


import com.mycompany.beans.ApplicationBeans;
import com.mycompany.beans.PersistenceBeanConfiguration;
import com.mycompany.beans.SwaggerConfig;
import com.mycompany.security.configuration.WebSecurityConfiguration;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.mycompany")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableWebMvc
@EnableSwagger2
@EnableCaching
@Import({
        ApplicationBeans.class,
        SwaggerConfig.class,
        PersistenceBeanConfiguration.class,
        WebSecurityConfiguration.class,
        SecurityConfig.class})
public class SpringBootStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }
}
