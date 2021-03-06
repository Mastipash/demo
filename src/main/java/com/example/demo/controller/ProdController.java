package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.NomenclatureService;
import com.example.demo.service.ProductService;
import com.example.demo.service.StorageService;
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
    @Autowired
    private StorageService storageService;
    @Autowired
    private NomenclatureService nomenclatureService;

    @GetMapping("/productList")
    public String productList(Model model) {
        model.addAttribute("productList", productService.getAllProducts());
        System.out.println("!!! Contr productList ");
        return "productList";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable(value = "id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "updateProduct";
    }

    @PostMapping("/updProducts")
    public String updProducts(@ModelAttribute("product") Product product)  {
        System.out.println("updProducts " + product);
        productService.updProducts(product);
        return "redirect:/productList";
    }

    @PostMapping("/saveProducts")
    public String saveProducts(@ModelAttribute("product") Product product) {
        System.out.println("!!! Contr saveProducts " + product);
        productService.saveProducts(product);
        return "redirect:/productList";
    }

    @GetMapping("/addProduct")
    public String showAddProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("nomenklList", nomenclatureService.getAllNomenclatures());
        model.addAttribute("storageList", storageService.getAllStorages());
        model.addAttribute("product", product);
        System.out.println("productList " + product);
        return "addProduct";
    }

    @GetMapping("/confirmProductById/{id}")
    public String confirmProductById(@PathVariable(value = "id") int id) {
        productService.confirmProductById(id);
        return "redirect:/docOutList";
    }

}
