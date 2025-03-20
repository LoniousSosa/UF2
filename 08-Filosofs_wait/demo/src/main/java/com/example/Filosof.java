package com.example;

import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaEsquerra, forquillaDreta;
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
        if (agafarForquilles()==false) {
            gana++;
            System.out.println(getFullInfo() + " no pot menjar, gana: " + gana);
            esperarRandom();
            deixarForquilles();
        }
        
        else{
            System.out.println(getFullInfo() + " menja");
            gana = 0;
            try {
                Thread.sleep(1000 + random.nextInt(1001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            deixarForquilles();
            System.out.println(getFullInfo() + " ha acabat de menjar");
        } 
    }

    private synchronized boolean agafarForquilles() {
        if (agafarForquillaEsquerra() && agafarForquillaDreta()) {
            return true;
        }
        else{
            deixarForquilles();
        }
        return false;
    }

    private boolean agafarForquillaEsquerra() {
        while (forquillaEsquerra.getPropietari() != forquillaEsquerra.getLLIURE()) {
                try {
                    wait();
                    return false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
        }
        forquillaEsquerra.setPropietari(numComensal);
        System.out.println(getFullInfo() + " agafa la forquilla esquerra " + forquillaEsquerra.getNumForquilla());
        return true;
    }

    private boolean agafarForquillaDreta() {
        while (forquillaDreta.getPropietari() != forquillaDreta.getLLIURE()) {
            try {
                wait();
                return false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        forquillaDreta.setPropietari(numComensal);
        System.out.println(getFullInfo() + " agafa la forquilla dreta " + forquillaDreta.getNumForquilla());
        return true;
    }

    private synchronized void deixarForquilles() {
        forquillaEsquerra.setPropietari(forquillaEsquerra.getLLIURE());
        forquillaDreta.setPropietari(forquillaDreta.getLLIURE());
        System.out.println(getFullInfo() + " deixa les forquilles");
        notifyAll();
        return;
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

    public void setSortir(){
        if (gana >= 5) {
            System.out.println(super.getName() + " ha muerto de inanición.");
            sortir = false;
        }
    }
    public String getFullInfo(){
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