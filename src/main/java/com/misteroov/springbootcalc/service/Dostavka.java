package com.misteroov.springbootcalc.service;

public class Dostavka {

    private double dostavka;

    public Dostavka() {
    }

    public Dostavka(double dostavka) {
        this.dostavka = dostavka;
    }

    public double getDostavka() {
        return dostavka;
    }

    public void setDostavka(double dostavka) {
        this.dostavka = dostavka;
    }

    public boolean isDostavka() {
        if (dostavka == 0.0) {
            return false;

        } else return true;
    }
}
