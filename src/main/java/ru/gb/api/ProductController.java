package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Product;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Product> getProductListFromDB(){
        return productService.getProductList();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/add-product")
    public Product addProductToDB(@RequestBody Product product) {
        System.out.println("Controller: id: " +product.getId()+ " title: " + product.getTitle() + " price: " + product.getPrice());
        return productService.addProduct(product);
    }

    @DeleteMapping("/delete")
    public void deleteById(
        @PathParam("id") Long id
    ) {
        productService.deleteProductById(id);
    }
}
