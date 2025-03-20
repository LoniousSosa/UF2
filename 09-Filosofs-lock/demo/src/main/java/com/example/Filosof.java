package com.example;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Filosof extends Thread {private Forquilla forquillaEsquerra, forquillaDreta;
    private int gana = 0;
    private int numComensal;
    private final Random random = new Random();
    private boolean sortir = false;

    public Filosof(String name, int numComensal, Forquilla forquillaE, Forquilla forquillaD) {
        super(name);
        this.numComensal = numComensal;
        this.forquillaEsquerra = forquillaE;
        this.forquillaDreta = forquillaD;
    }

    public void menjar() {
        try {
            if (!agafarForquilles()) {
                gana++;
                System.out.println(getFullInfo() + " no pot menjar, gana: " + gana);
                esperarRandom();
            } else {
                System.out.println(getFullInfo() + " menja");
                gana = 0;
                Thread.sleep(1000 + random.nextInt(1001));
                deixarForquilles();
                System.out.println(getFullInfo() + " ha acabat de menjar");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean agafarForquilles() {
        if (forquillaEsquerra.agafar()) {
            if (forquillaDreta.agafar()) {
                return true;
            } else {
                forquillaEsquerra.deixar();
            }
        }
        return false;
    }

    private void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
    }

    private void esperarRandom() {
        try {
            Thread.sleep(500 + random.nextInt(501));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pensar() {
        System.out.println(getFullInfo() + " està pensant");
        try {
            Thread.sleep(1000 + random.nextInt(1001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!sortir) {
            menjar();
            pensar();
            setSortir();
        }
    }

    public void setSortir() {
        if (gana >= 5) {
            System.out.println(super.getName() + " ha muerto de inanición.");
            sortir = true;
        }
    }

    public String getFullInfo() {
        return super.getName() + ": fil" + this.getNumComensal();
    }

    public int getNumComensal() {
        return numComensal;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public int getGana() {
        return gana;
    }
}