package ru.gb.api;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

    private SessionFactory factory;

    public void init(){
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public Session getSession(){
        return factory.getCurrentSession();
    }

    public void shutdown(){
        factory.close();
    }
}
