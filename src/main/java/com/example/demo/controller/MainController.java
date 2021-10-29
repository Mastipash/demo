package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.form.NomenclatureForm;
import com.example.demo.model.Nomenclature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static List<Nomenclature> nomenclatures = new ArrayList<Nomenclature>();

    static {
        nomenclatures.add(new Nomenclature("0102", "Лего бионикл", 150));
        nomenclatures.add(new Nomenclature("0103", "Лего нинзяга", 200));
    }

    // Вводится (inject) из application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/nomenclatureList" }, method = RequestMethod.GET)
    public String nomenclatureList(Model model) {

        model.addAttribute("nomenclatures", nomenclatures);

        return "nomenclatureList";
    }

    @RequestMapping(value = { "/addNomenclature" }, method = RequestMethod.GET)
    public String showAddNomenclaturePage(Model model) {

        NomenclatureForm nomenclatureForm = new NomenclatureForm();
        model.addAttribute("nomenclatureForm", nomenclatureForm);

        return "addNomenclature";
    }

    @RequestMapping(value = { "/addNomenclature" }, method = RequestMethod.POST)
    public String saveNomenclature(Model model, //
                             @ModelAttribute("nomenclatureForm") NomenclatureForm nomenclatureForm) {

        String code = nomenclatureForm.getCode();
        String description = nomenclatureForm.getDescription();
        int price = nomenclatureForm.getPrice();

        if (code != null && code.length() > 0 //
                && description != null && description.length() > 0 && price != 0) {
            Nomenclature newNomenclature = new Nomenclature(code, description, price);
            nomenclatures.add(newNomenclature);

            return "redirect:/nomenclatureList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addNomenclature";
    }

}