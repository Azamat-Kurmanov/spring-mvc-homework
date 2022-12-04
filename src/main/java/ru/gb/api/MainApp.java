package ru.gb.api;


import org.hibernate.Session;
import ru.gb.api.model.Product;
import ru.gb.api.services.CustomerDaoImp;
import ru.gb.api.services.CustomerService;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        SessionFactoryUtils SessionFactory = new SessionFactoryUtils();

        Session session = SessionFactory.factory().getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, 1L);
        System.out.println("product: " + product);
//        System.out.println("productGetProducts: " + product.getProducts());
        session.getTransaction().commit();

//        CustomerDaoImp customerDaoImp = new CustomerDaoImp(session);
//        CustomerService customerService = new CustomerService(customerDaoImp);
//        List<Product> products =  customerService.getListOfProductsByUserId(1L);
//        for (Product product: products){
//            System.out.println("product: " + product.getProducts());
//        }
    }
}
