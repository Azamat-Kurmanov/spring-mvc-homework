package ru.gb.api.services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.api.SessionFactoryUtils;
import ru.gb.api.model.Customer;
import ru.gb.api.model.Product;

import java.util.List;

@Component
public class CustomerDaoImp implements CustomerDao {
    private final SessionFactoryUtils beanConfigSession;

    @Autowired
    public CustomerDaoImp(SessionFactoryUtils beanConfigSession) {
        this.beanConfigSession = beanConfigSession;
    }

    @Override
    public List<Product> getProductListByUserId(Long id) {
        try(Session session = beanConfigSession.getSession()){
            session.beginTransaction();
            List<Product> products = session.get(Customer.class, id).getProducts();
            session.persist(products);
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<Customer> getUserListByProductId(Long id) {
        try (Session session = beanConfigSession.getSession()){
            session.beginTransaction();
            List<Customer> customer = session.get(Product.class, id).getCustomers();
            session.persist(customer);
            session.getTransaction().commit();
            return customer;
        }
    }
}
