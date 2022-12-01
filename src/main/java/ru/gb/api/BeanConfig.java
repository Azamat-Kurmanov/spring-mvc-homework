package ru.gb.api;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

    @Bean
    public final SessionFactory factory(){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        return factory;
    }
}
