package com.mycompany.emailservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
public class EmailConfig {

    private String host;

    private int port;

    private String username;

    private String password;

}
