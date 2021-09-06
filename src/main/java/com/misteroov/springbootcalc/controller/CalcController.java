package com.misteroov.springbootcalc.controller;

import com.misteroov.springbootcalc.model.Contact;
import com.misteroov.springbootcalc.repository.Repo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController {


    private Repo contactService = new Repo();

    @GetMapping("/index")
    public String show(Model model){
        model.addAttribute("contact",new Contact());
        return "index";
    }

    @PostMapping(value = "/index")
    public void addContact(
                             @ModelAttribute("contact") Contact contact) {

             contactService.add(contact);
        System.out.println(contactService.showList());


        }
    }

