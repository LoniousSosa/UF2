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
        Soci soci = new Soci("Soci vacio");
        System.out.println("Saldo " +soci.compte.getSaldo());
    }
}
