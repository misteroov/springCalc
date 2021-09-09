package com.misteroov.springbootcalc.controller;

import com.misteroov.springbootcalc.model.Contact;
import com.misteroov.springbootcalc.repository.Repo;
import com.misteroov.springbootcalc.service.CalcService;
import com.misteroov.springbootcalc.service.Dostavka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {


Dostavka dostavka = new Dostavka();

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("listcontact", Repo.showList());
        model.addAttribute("delivery", dostavka.isDostavka());
        model.addAttribute("deliveryprice",dostavka.getDostavka());

        return "startpage";
    }
    @PostMapping("/")
    public ModelAndView addDelivery(@RequestParam("deliveryvalue") double deliv){
dostavka.setDostavka(deliv);
return new ModelAndView("redirect:/") ;

    }

    @GetMapping("/index")
    public String show(Model model) {
        model.addAttribute("contact", new Contact());
        return "index";
    }

    @PostMapping(value = "/index")
    public ModelAndView addContact(
            @ModelAttribute("contact") Contact contact) {

        Repo.add(contact);

        return new ModelAndView("redirect:/");
    }
    @GetMapping("/result")
    public String showDeliveryCost(Model model) {
         CalcService calcService = new CalcService();
        model.addAttribute("listcontact", calcService.calculateDelivery(Repo.showList(),dostavka));
        return "deliveryResult";
    }

    @GetMapping("/clear")
    public String clearInfo(){
        Repo.list.clear();
        dostavka.setDostavka(0.0);
        return "startpage";

    }
}

