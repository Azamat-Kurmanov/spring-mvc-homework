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
        Product product = null;
        if (id != null){
            beanConfigSession.init();
            product = productDaoImp.findById(id);
        }
        return product;
    }

    public List<Product> getProductList(){
        beanConfigSession.init();
        List<Product> list = productDaoImp.findAll();
        return list;
    }

    public Product addProduct(Product product){
        beanConfigSession.init();
        return productDaoImp.saveOrUpdate(product);
    }

    public boolean deleteProductById(Long id){
        if (id!=null){
            beanConfigSession.init();
            ProductDaoImpl productDao = new ProductDaoImpl(beanConfigSession);
            productDao.deleteById(id);
        }
        return false;
    }
}
