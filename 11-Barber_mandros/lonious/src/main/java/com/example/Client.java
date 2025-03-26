package com.example;

public class Client {
    private final String nom;

    public Client(int id) {
        this.nom = "Client-" + id;
    }

    public String getNom() {
        return nom;
    }
}