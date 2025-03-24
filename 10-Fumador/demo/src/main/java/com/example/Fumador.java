package com.example;

public class Fumador extends Thread {
    private final Estanc estanc;
    private int numFumades = 0;
    private final int id;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }

    private void compraTabac() throws InterruptedException {
        estanc.venTabac();
        System.out.println("Fumador " + id + " comprant Tabac");
    }

    private void compraPaper() throws InterruptedException {
        estanc.venPaper();
        System.out.println("Fumador " + id + " comprant Paper");
    }

    private void compraLlumi() throws InterruptedException {
        estanc.venLlumi();
        System.out.println("Fumador " + id + " comprant Llumí");
    }

    private void fumar() throws InterruptedException {
        System.out.println("Fumador " + id + " fumant. Vegades: " + (numFumades + 1));
        numFumades++;
        Thread.sleep((long) (500 + Math.random() * 500));
    }

    @Override
    public void run() {
        try {
            while (numFumades < 3) {
                compraTabac();
                compraPaper();
                compraLlumi();
                fumar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
