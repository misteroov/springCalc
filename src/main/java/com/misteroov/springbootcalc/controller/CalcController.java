package com.misteroov.springbootcalc.controller;

import com.misteroov.springbootcalc.model.Contact;
import com.misteroov.springbootcalc.repository.Repo;
import com.misteroov.springbootcalc.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController {




    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("listcontact", Repo.showList());
        return "startpage";
    }

    @GetMapping("/index")
    public String show(Model model) {
        model.addAttribute("contact", new Contact());
        return "index";
    }

    @PostMapping(value = "/index")
    public void addContact(
            @ModelAttribute("contact") Contact contact) {

        Repo.add(contact);


    }
    @GetMapping("/result")
    public String showDeliveryCost(Model model) {
         CalcService calcService = new CalcService();
        model.addAttribute("listcontact", calcService.calculateDelivery(Repo.showList()));
        return "deliveryResult";
    }

    @GetMapping("/clear")
    public String clearInfo(){
        Repo.list.clear();
        return "startpage";

    }
}

