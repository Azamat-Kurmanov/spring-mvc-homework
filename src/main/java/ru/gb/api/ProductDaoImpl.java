package ru.gb.api;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.gb.model.Product;

import java.util.List;
@Component
public class ProductDaoImpl implements ProductDao{
    private final BeanConfig beanConfigSession;

    public ProductDaoImpl(BeanConfig beanConfigSession) {
        this.beanConfigSession = beanConfigSession;
    }

    @Override
    public Product findById(Long id) {
        try {
            Session session = beanConfigSession.getSession();
            session.beginTransaction();
            Product product = session.createQuery("SELECT d FROM Product d WHERE d.id = :id", Product.class).setParameter("id", id).getSingleResult();
            session.persist(product);
            session.getTransaction().commit();
            return product;
        } finally {
            beanConfigSession.shutdown();
        }
    }

    @Override
    public List<Product> findAll() {
        try {
            Session session = beanConfigSession.getSession();
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT d FROM Product d").getResultList();
            session.getTransaction().commit();
            return products;
        } finally {
            beanConfigSession.shutdown();
        }
    }

    @Override
    public Boolean deleteById(Long id) {
        Session session = beanConfigSession.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
        if (findById(id) == null) {
            return true;
        }
        return false;
    }

    @Override
    public Product saveOrUpdate(Product product) {
        Session session = beanConfigSession.getSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return product;
    }


}
