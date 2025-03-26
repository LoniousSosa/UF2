package com.example;

public class Barber extends Thread {
    private String nom;
    private Barberia barberia;

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            String client = barberia.seguentClient();
            if (client == null) {
                System.out.println("Ningú en espera");
                synchronized (barberia.condBarber) {
                    try {
                        System.out.println("Barber " + nom + " dormint");
                        barberia.condBarber.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            } else {
                System.out.println("Li toca al client " + client);
                System.out.println("Tallant cabell a " + client);
                try {
                    Thread.sleep(900 + (int) (Math.random() * 100));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}