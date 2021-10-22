package com.mycompany.Listener;

import com.mycompany.domain.User;
import com.mycompany.domain.hibernate.HibernateUser;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@Setter
@Getter

public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private HibernateUser user;

    public OnRegistrationCompleteEvent(
            HibernateUser user, Locale locale, String appUrl) {
        super(user);

        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }


}