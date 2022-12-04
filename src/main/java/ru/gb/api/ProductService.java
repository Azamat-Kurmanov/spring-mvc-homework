package ru.gb.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.api.model.Product;
import java.util.List;

@Service
public class ProductService {
    private ProductDaoImpl productDaoImp;

    @Autowired
    public ProductService(ProductDaoImpl productDaoImp) {
        this.productDaoImp = productDaoImp;
    }

    public Product getProductById(Long id){
        Product product = productDaoImp.findById(id);
        return product;
    }

    public List<Product> getProductList(){
        List<Product> list = productDaoImp.findAll();
        return list;
    }

    public Product addProduct(Product product){
        return productDaoImp.saveOrUpdate(product);
    }

    public void deleteProductById(Long id){
        if (id!=null){
            productDaoImp.deleteById(id);
        }
    }
}
