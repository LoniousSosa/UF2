package com.example;


public class Barberia extends Thread {
    private String[] cadires;
    private int nCadires;
    private int ocupades = 0;
    private int seguent = 0;
    private int ultim = 0;
    public final Object condBarber = new Object();

    public Barberia(int nCadires) {
        this.nCadires = nCadires;
        cadires = new String[nCadires];
    }

    public synchronized String seguentClient() {
        if (ocupades == 0) {
            return null;
        } else {
            String client = cadires[seguent];
            seguent = (seguent + 1) % nCadires;
            ocupades--;
            return client;
        }
    }

    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (ocupades < nCadires) {
                cadires[ultim] = client.getNom();
                ultim = (ultim + 1) % nCadires;
                ocupades++;
                System.out.println(client.getNom() + " en espera");
                condBarber.notify();
            } else {
                System.out.println(client.getNom() + " se'n va, no hi ha lloc");
            }
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(500);
                entrarClient(new Client(i));
            }
            Thread.sleep(10000);
            for (int i = 11; i <= 20; i++) {
                Thread.sleep(500);
                entrarClient(new Client(i));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {
        Barberia barberia = new Barberia(3);
        Barber barber = new Barber("Lonious", barberia);
        barber.start();
        barberia.start();
    }
}