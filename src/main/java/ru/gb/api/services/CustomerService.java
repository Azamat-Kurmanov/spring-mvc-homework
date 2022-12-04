package ru.gb.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.api.model.Customer;
import ru.gb.api.model.Product;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDaoImp customerDaoImp;

    @Autowired
    public CustomerService(CustomerDaoImp userDaoImp) {
        this.customerDaoImp = userDaoImp;
    }

    public List<Product> getListOfProductsByUserId(Long userId) {
        return customerDaoImp.getProductListByUserId(userId);
    }

    public List<Customer> getListOfCustomersByProductId(Long productId) {
        return customerDaoImp.getUserListByProductId(productId);
    }

}