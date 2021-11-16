package com.example.demo.controller;

import com.example.demo.entity.Document;
import com.example.demo.entity.Product;
import com.example.demo.service.DocStatusService;
import com.example.demo.service.DocumentService;
import com.example.demo.service.NomenclatureService;
import com.example.demo.service.StorageService;
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
    @Autowired
    private NomenclatureService nomenclatureService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private DocStatusService docStatusService;

    @GetMapping("/docOutList")
    public String docOutList(Model model) {

        model.addAttribute("docOutList", documentService.getAllDocuments());
        //  model.addAttribute("docOutList", documentRepository.findDocByStatusNative(1));
        return "docOutList";
    }

    @GetMapping("/updateDocOut/{id}")
    public String updateDocOut(@PathVariable(value = "id") int id, Model model) {
        Document document = documentService.getDocumentById(id);
        model.addAttribute("storageList", storageService.getAllStorages());
        model.addAttribute("nomenklList", nomenclatureService.getAllNomenclatures());
        model.addAttribute("docStatusList", docStatusService.getAllDocStatus());
        model.addAttribute("document", document);
        return "updateDocOut";
    }

    @PostMapping("/saveDocuments")
    public String saveDocuments(@ModelAttribute("document") Document document) {
        documentService.saveDocuments(document);
        System.out.println("saveDocuments " + document);
        return "redirect:/docOutList";
    }

    @GetMapping("/addDocOut")
    public String showAddDocOutPage(Model model) {
        Document document = new Document();
        Product product = new Product();
        model.addAttribute("document", document);
        model.addAttribute("storageList", storageService.getAllStorages());
        model.addAttribute("nomenklList", nomenclatureService.getAllNomenclatures());
        model.addAttribute("docStatusList", docStatusService.getAllDocStatus());
        System.out.println("addDocOut " + document);
        return "addDocOut";
    }
}
