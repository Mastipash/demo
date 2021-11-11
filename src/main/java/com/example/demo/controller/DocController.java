package com.example.demo.controller;

import com.example.demo.entity.Document;
import com.example.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DocController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/docOutList")
    public String docOutList(Model model) {

        model.addAttribute("docOutList", documentService.getAllDocuments());
        //  model.addAttribute("docOutList", documentRepository.findDocByStatusNative(1));
        return "docOutList";
    }

    @GetMapping("/updateDocOut/{id}")
    public String updateDocOut(@PathVariable(value = "id") int id, Model model) {
        Document document = documentService.getDocumentById(id);
        model.addAttribute("document", document);
        return "updateDocOut";
    }

    @PostMapping("/saveDocuments")
    public String saveDocuments(@ModelAttribute("document") Document document) {
        documentService.saveDocuments(document);
        return "redirect:/docOutList";
    }

    @GetMapping("/addDocOut")
    public String showAddDocOutPage(Model model) {
        Document document = new Document();
        model.addAttribute("document", document);
        return "addDocOut";
    }
}
