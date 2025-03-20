package com.example;

import java.util.concurrent.locks.ReentrantLock;

public class Forquilla 
{ private final int numForquilla;
    private final ReentrantLock bloqueig = new ReentrantLock();

    public Forquilla(int numForquilla) {
        this.numForquilla = numForquilla;
    }

    public int getNum() {
        return numForquilla;
    }

    public boolean agafar() {
        return bloqueig.tryLock();
    }

    public void deixar() {
        bloqueig.unlock();
    }
}