package com.example;

public class Dona extends Thread {
    private final String nom;
    private final BanyUnisex bany;

    public Dona(String nom, BanyUnisex bany) {
        this.nom = nom;
        this.bany = bany;
    }

    @Override
    public void run() {
        try {
            System.out.println(nom + " vol entrar al bany");
            bany.entraDona(nom);
            Thread.sleep(2000 + (int) (Math.random() * 1000));
            bany.surtDona(nom);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

