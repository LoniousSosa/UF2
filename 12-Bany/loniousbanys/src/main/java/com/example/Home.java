package com.example;

public class Home extends Thread {
    private final String nom;
    private final BanyUnisex bany;

    public Home(String nom, BanyUnisex bany) {
        this.nom = nom;
        this.bany = bany;
    }

    @Override
    public void run() {
        try {
            System.out.println(nom + " vol entrar al bany");
            bany.entraHome(nom);
            Thread.sleep(1000 + (int) (Math.random() * 1000));
            bany.surtHome(nom);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}