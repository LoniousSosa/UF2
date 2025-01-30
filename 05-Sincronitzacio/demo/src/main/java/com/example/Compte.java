package com.example;

public class Compte {

    private float saldo;
    private static Compte instanciaCompte;

    private Compte (){
        this.saldo = 0;
    }

    public synchronized float getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public static synchronized Compte instanciaCompte(){
        if (instanciaCompte == null) {
            instanciaCompte = new Compte();
        }
        return instanciaCompte;
    }
    
}