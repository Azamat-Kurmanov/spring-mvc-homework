package ru.gb.api.services;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.gb.api.SessionFactoryUtils;
import ru.gb.api.model.Product;

import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {
    private final SessionFactoryUtils beanConfigSession;

    public ProductDaoImpl(SessionFactoryUtils beanConfigSession) {
        this.beanConfigSession = beanConfigSession;
    }

    @Override
    public Product findById(Long id) {
        try(Session session = beanConfigSession.getSession()) {
            session.beginTransaction();
            Product product = session.createQuery("SELECT d FROM Product d WHERE d.id = :id", Product.class).setParameter("id", id).getSingleResult();
            session.persist(product);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try(Session session = beanConfigSession.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT d FROM Product d").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = beanConfigSession.getSession()) {
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Product product) {
        try(Session session = beanConfigSession.getSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

}
