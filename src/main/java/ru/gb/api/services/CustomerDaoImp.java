package ru.gb.api.services;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.gb.api.SessionFactoryUtils;
import ru.gb.api.model.Product;
import ru.gb.api.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDaoImp implements CustomerDao {
    private final SessionFactoryUtils beanConfigSession;

    public CustomerDaoImp(SessionFactoryUtils beanConfigSession) {
        this.beanConfigSession = beanConfigSession;
    }

    @Override
    public List<Product> getProductListByUserId(Long id) {
        try {
            Session session = beanConfigSession.factory().getCurrentSession();
            session.beginTransaction();
            List<Product> products = session.get(Product.class, id).getProducts();
            session.persist(products);
            session.getTransaction().commit();
            return products;
        } finally {
            beanConfigSession.factory().close();
        }
    }

    @Override
    public List<Customer> getUserListByProductId(Long id) {
//        try {
//            Session session = beanConfigSession.factory().getCurrentSession();
//            session.beginTransaction();
//            Customer user = session.get(Product.class, id).getProducts();
//            session.persist(users);
//            session.getTransaction().commit();
//            return users;
//        } finally {
//            beanConfigSession.factory().close();
//        }
        return null;
    }
}
