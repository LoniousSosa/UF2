package com.example;

import java.util.Random;

public class Soci extends Thread {
    
    Compte compte;
    float aportacio;
    int esperaMax;
    Random random;
    int maxAnys;

    public Soci(String name){
        super(name);
        this.compte = Compte.instanciaCompte();
        this.aportacio = 10f;
        this.esperaMax= 100;
        this.random = new Random();
        this.maxAnys = 10;
    }

    public void run() {
        for (int i = 0; i < maxAnys; i++) {
            for (int j = 0; j < 12; j++) {
                if (j % 2 == 0) {
                    compte.setSaldo(compte.getSaldo()+aportacio);
                }else compte.setSaldo(compte.getSaldo()-aportacio);
            try {
                this.sleep(random.nextInt(esperaMax));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            }
        }
    };

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    
}
