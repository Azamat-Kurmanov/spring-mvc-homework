package ru.gb.api;

import ru.gb.model.Product;

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
    }
}
