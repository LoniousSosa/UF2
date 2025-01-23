package com.example;

public class Compte {

    private float saldo;
    private static Compte instanciaCompte;

    private Compte (){
        this.saldo = 0;
    }

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