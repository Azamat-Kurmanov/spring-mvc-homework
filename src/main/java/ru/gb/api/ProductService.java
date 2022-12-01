package ru.gb.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.model.Product;
import java.util.List;

@Service
public class ProductService {
    private ProductDaoImpl productDaoImp;
    private final BeanConfig beanConfigSession;

    @Autowired
    public ProductService(ProductDaoImpl productDaoImp, BeanConfig beanConfigSession) {
        this.productDaoImp = productDaoImp;
        this.beanConfigSession = beanConfigSession;
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
