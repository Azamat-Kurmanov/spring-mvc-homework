package ru.gb.api;

import ru.gb.api.model.Product;
import ru.gb.api.services.ProductDao;
import ru.gb.api.services.ProductDaoImpl;

public class MainApp {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            productDao.saveOrUpdate(new Product("Картошка", 450));
            productDao.saveOrUpdate(new Product("Мука", 240));

            Product product = productDao.findById(1L);
            System.out.println("product: " + product);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            sessionFactoryUtils.shutdown();
        }
    }
}
