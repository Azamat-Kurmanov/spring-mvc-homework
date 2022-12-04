package ru.gb.api;

import org.hibernate.Session;
import ru.gb.api.model.Product;
import ru.gb.api.services.ProductDao;
import ru.gb.api.services.ProductDaoImpl;

public class MainApp {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
//            productDao.saveOrUpdate(new Product(1L, "Картошка", 450));
            Product product = productDao.findById(1L);
            System.out.println("product: " + product);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            sessionFactoryUtils.shutdown();
        }

//        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
//        CustomerDaoImp customerDaoImp = new CustomerDaoImp(sessionFactoryUtils);
//        CustomerService customerService = new CustomerService(customerDaoImp);
//        System.out.println("Start");
//       customerService.getListOfProductsByUserId(2L);
    }
}
