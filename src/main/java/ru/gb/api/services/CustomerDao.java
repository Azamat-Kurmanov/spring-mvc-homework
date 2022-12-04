package ru.gb.api.services;

import ru.gb.api.model.Product;
import ru.gb.api.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Product> getProductListByUserId(Long id);
    List<Customer> getUserListByProductId(Long id);
}
