package com.misteroov.springbootcalc.service;

public class Dostavka {
    private static  double dostavka;

    Dostavka(double dostavka) {
        this.dostavka = dostavka;
    }

    public static double getDostavka() {
        return dostavka;
    }
}
