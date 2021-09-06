package com.misteroov.springbootcalc.model;

public class Contact {
    private String name;
    private double summaPokupok;

    public Contact(String name, double summaPokupok) {
        this.name = name;
        this.summaPokupok = summaPokupok;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSummaPokupok() {
        return summaPokupok;
    }

    public void setSummaPokupok(double summaPokupok) {
        this.summaPokupok = summaPokupok;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", summaPokupok=" + summaPokupok +
                '}';
    }
}
