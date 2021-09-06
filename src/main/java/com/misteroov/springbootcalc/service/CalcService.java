package com.misteroov.springbootcalc.service;

import com.misteroov.springbootcalc.model.Contact;
import com.misteroov.springbootcalc.repository.Repo;

import java.util.ArrayList;
import java.util.List;

public class CalcService {

    Dostavka dostavka = new Dostavka(100.00);


    public double calculateSumma(List<Contact> contactList){
        double summapokupok = contactList.stream().mapToDouble(Contact::getSummaPokupok).sum();


        return summapokupok;
    }

    public List<Contact> calculateDelivery(List<Contact> contactList){
        List<Contact> newList = new ArrayList<>();
        contactList.forEach(contact -> newList.add(new Contact(contact.getName(),calculatePersonalDelivery(calculateSumma(Repo.showList()),
                contact.getSummaPokupok(),Dostavka.getDostavka()) )));
        return newList;
    }

    public double calculatePersonalDelivery(double obshajaSumma,double personalSumma, double dostavka ){

        double personalDelivery = (personalSumma/obshajaSumma)*dostavka;
        return personalDelivery;

    }
}
