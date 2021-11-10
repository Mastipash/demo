package com.example.demo.controller;

import com.example.demo.service.DocumentService;
import com.example.demo.service.NomenclatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocController {
    @Autowired
    private DocumentService documentService;
    @GetMapping("/docOutList")
    public String docOutList(Model model) {

        model.addAttribute("docOutList", documentService.getAllDocuments());

        return "docOutList";
    }
}
