package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdController {
    @Autowired
    private ProductService productService;

    @GetMapping("/productList")
    public String productList(Model model) {

        model.addAttribute("productList", productService.getAllProducts());
        return "productList";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateDocOut(@PathVariable(value = "id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "updateProduct";
    }

    @PostMapping("/saveProducts")
    public String saveProducts(@ModelAttribute("product") Product product) {
        productService.saveProducts(product);
        return "redirect:/productList";
    }

    @GetMapping("/addProduct")
    public String showAddProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProduct";
    }
}
