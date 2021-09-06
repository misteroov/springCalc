package com.misteroov.springbootcalc.repository;

import com.misteroov.springbootcalc.model.Contact;

import java.util.ArrayList;
import java.util.List;

public  class Repo {
    public Repo() {
    }

    public static List<Contact> showList(){
        return list;
    }

    public static List<Contact> list = new ArrayList<Contact>();

    public static void add (Contact contact){
        list.add(contact);
    }

    public static Contact getContactByName(String name){
        return list.stream().filter(contact -> name.equals(contact.getName())).findAny().get();
    }
}
