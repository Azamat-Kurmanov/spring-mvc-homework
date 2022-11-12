package ru.gb.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/goods")
public class ProductController {
    private List<Product> productsList = new ArrayList<>();

    @GetMapping("/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable Long id) {
        Product product = productsList.stream().filter(it -> Objects.equals(id, it.getId())).findFirst().orElse(null);
        return product;
    }

    @GetMapping
    public String getProductList(Model model) {
        Product product = new Product();
        model.addAttribute("productList", productsList);
        model.addAttribute("product", product);
        return "products";
    }

    @PostMapping("/save")
    public String addProduct(Product product) {
        long id = 1L;
        Product productObj;
        if (!productsList.isEmpty()) {
            id = productsList.get(productsList.size() - 1).getId() + 1;
        }
        productObj = new Product(id, product.getTitle(), product.getCost());
        productsList.add(productObj);
//            productsList.forEach((prd) -> System.out.println("Id: "+prd.getId()+" Title: "+prd.getTitle()+" Cost: " +prd.getCost()));
        return "redirect:/goods";
    }
}
