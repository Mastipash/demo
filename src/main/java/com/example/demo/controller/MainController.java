package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Nomenclature;
import com.example.demo.service.NomenclatureService;


@Controller
public class MainController {
    private Nomenclature nomenclature;

    @Autowired
    private NomenclatureService nomenclatureService;


    @GetMapping("/nomenclaturesList")
    public String nomenclatureList(Model model) {
        model.addAttribute("nomenclaturesList", nomenclatureService.getAllNomenclatures());
        return "nomenclaturesList";
    }

    @GetMapping("/addNomenclature")
    public String showAddNomenclaturePage(Model model) {
        Nomenclature nomenclature = new Nomenclature();
        model.addAttribute("nomenclature", nomenclature);
        return "addNomenclature";
    }

    @PostMapping("/saveNomenclature")
    public String saveNomenclature(@ModelAttribute("nomenclature") Nomenclature nomenclature) {
        nomenclatureService.saveNomenclature(nomenclature);
        return "redirect:/nomenclaturesList";
    }

    @GetMapping("/updateNomenclature/{id}")
    public String updateNomenclature(@PathVariable(value = "id") int id, Model model) {
        Nomenclature nomenclature = nomenclatureService.getNomenclatureById(id);
        model.addAttribute("nomenclature", nomenclature);
        return "updateNomenclature";
    }

    @GetMapping("error")
    public String errorPage() {
        return "error";
    }

}
