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
            Session session = beanConfigSession.factory().getCurrentSession();
            session.beginTransaction();
            Product product = session.createQuery("SELECT d FROM Product d WHERE d.id = :id", Product.class).setParameter("id", id).getSingleResult();
            session.persist(product);
            session.getTransaction().commit();
            return product;
        } finally {
            beanConfigSession.factory().close();
        }
    }

    @Override
    public List<Product> findAll() {
        try {
            Session session = beanConfigSession.factory().getCurrentSession();
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT d FROM Product d").getResultList();
            session.getTransaction().commit();
            return products;
        } finally {
            beanConfigSession.factory().close();
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            Session session = beanConfigSession.factory().getCurrentSession();
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        } finally {
            beanConfigSession.factory().close();
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try {
            Session session = beanConfigSession.factory().getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        } finally {
            beanConfigSession.factory().close();
        }
    }


}
