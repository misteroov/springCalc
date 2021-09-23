package com.misteroov.springbootcalc.service;

import com.misteroov.springbootcalc.model.Contact;
import com.misteroov.springbootcalc.repository.Repo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CalcService {




    public double calculateSumma(List<Contact> contactList){
        double summapokupok = contactList.stream().mapToDouble(Contact::getSummaPokupok).sum();


        return summapokupok;
    }

    public List<Contact> calculateDelivery(List<Contact> contactList,Dostavka dostavka){
        List<Contact> newList = new ArrayList<>();
        contactList.forEach(contact -> newList.add(new Contact(contact.getName(),calculatePersonalDelivery(calculateSumma(Repo.showList()),
                contact.getSummaPokupok(),dostavka.getDostavka()) )));
        return newList;
    }

    public double calculatePersonalDelivery(double obshajaSumma,double personalSumma, double dostavka ){

        double personalDelivery = (personalSumma/obshajaSumma)*dostavka;
        BigDecimal bg = BigDecimal.valueOf(personalDelivery).setScale(2, RoundingMode.HALF_UP);
        return bg.doubleValue();

    }
}
