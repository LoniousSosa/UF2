Sin sincronización:

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
        float saldoGeneral = 0;
        for (int i = 0; i < maxAnys; i++) {
            for (int j = 0; j < 12; j++) {
                if (j % 2 == 0) {
                    saldoGeneral= compte.getSaldo()+aportacio;
                    compte.setSaldo(saldoGeneral);
                }else {
                    saldoGeneral = compte.getSaldo()-aportacio;
                    compte.setSaldo(saldoGeneral);}
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

package com.example;

public class Compte {

    private float saldo;
    private static Compte instanciaCompte;

    private Compte (){}

    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public static Compte instanciaCompte(){
        if (instanciaCompte == null) {
            instanciaCompte = new Compte();
        }
        return instanciaCompte;
    }
    
}

package com.example;

public class Associacio {
    private int numSocis;
    private Soci[]socis;

    public Associacio(){
        this.numSocis = 1000;
        this.socis = new Soci[this.numSocis];
        for (int i = 0; i < socis.length; i++) {
            String sociName = "Soci "+ i;
            socis[i] = new Soci(sociName);
        }
    }

    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }

    public void iniciaCompteTempsSocis(){
        for (Soci soci : socis) {
            soci.start();
        }
    }

    public void esperaPeriodeSocis(){
        for (Soci soci : socis) {
            try {
                soci.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes(){
        System.out.println("Saldo: " + socis[0].getCompte().getSaldo());
    }
}
