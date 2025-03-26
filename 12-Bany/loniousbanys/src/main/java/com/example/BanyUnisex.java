package com.example;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class BanyUnisex {
    public static final int BANY_BUIT = 0;
    public static final int BANY_AMB_HOMES = 1;
    public static final int BANY_AMB_DONES = 2;
    private int estatActual = BANY_BUIT;
    private int ocupants = 0;
    private static final int CAPACITAT_MAX = 3;
    private Semaphore capacitat = new Semaphore(CAPACITAT_MAX, true);
    private ReentrantLock lockEstat = new ReentrantLock(true);

    public void entraHome(String nom) throws InterruptedException {
        while (true) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_HOMES) {
                    if (capacitat.tryAcquire()) {
                        ocupants++;
                        estatActual = BANY_AMB_HOMES;
                        System.out.println(nom + " entra al bany. Ocupants: " + ocupants);
                        break;
                    }
                }
            } finally {
                lockEstat.unlock();
            }
            Thread.sleep(100);
        }
    }

    public void surtHome(String nom) {
        lockEstat.lock();
        try {
            ocupants--;
            capacitat.release();
            System.out.println(nom + " surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
            }
        } finally {
            lockEstat.unlock();
        }
    }

    public void entraDona(String nom) throws InterruptedException {
        while (true) {
            lockEstat.lock();
            try {
                if (estatActual == BANY_BUIT || estatActual == BANY_AMB_DONES) {
                    if (capacitat.tryAcquire()) {
                        ocupants++;
                        estatActual = BANY_AMB_DONES;
                        System.out.println(nom + " entra al bany. Ocupants: " + ocupants);
                        break;
                    }
                }
            } finally {
                lockEstat.unlock();
            }
            Thread.sleep(100);
        }
    }

    public void surtDona(String nom) {
        lockEstat.lock();
        try {
            ocupants--;
            capacitat.release();
            System.out.println(nom + " surt del bany. Ocupants: " + ocupants);
            if (ocupants == 0) {
                estatActual = BANY_BUIT;
            }
        } finally {
            lockEstat.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BanyUnisex bany = new BanyUnisex();
        Thread[] personas = new Thread[10];
        for (int i = 0; i < 5; i++) {
            personas[i] = new Home("Home-" + i, bany);
        }
        for (int i = 0; i < 5; i++) {
            personas[i + 5] = new Dona("Dona-" + i, bany);
        }
        for (Thread hilo : personas) {
            hilo.start();
        }
        for (Thread hilo : personas) {
            hilo.join();
        }
        System.out.println("Tothom ha anat al bany");
    }

}

