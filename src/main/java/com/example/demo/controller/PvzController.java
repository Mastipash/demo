package com.example.demo.controller;

import com.example.demo.entity.Document;
import com.example.demo.entity.Product;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PvzController {
    @Autowired
    private DocumentService documentService;

    @Autowired
    private ProductService productService;

    @GetMapping("/pvzList")
    public String pvzList(Model model) {
        model.addAttribute("productList", productService.getAllProducts());
        model.addAttribute("docOutList", documentService.getAllDocuments());
        return "pvzList";
    }


    @GetMapping("/getOutProductById/{id}")
    public String getOutProductById(@PathVariable(value = "id") int id) {
        productService.getOutProductById(id);
        return "redirect:/pvzList";
    }

}
