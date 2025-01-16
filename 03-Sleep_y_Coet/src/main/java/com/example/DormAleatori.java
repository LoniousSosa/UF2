package com.example;

import java.util.Random;

public class DormAleatori extends Thread {

    public DormAleatori(String name){
        super(name);
        
    }
    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();
    }

    @Override
    public void run() {
        int sleepTime= 0;
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(1000) + 1;
            sleepTime = sleepTime + randomNumber; 
            System.out.printf("%s(%d) a dormir %dms total %d%n", this.getName(), i, randomNumber, sleepTime);
            try {
                sleep(randomNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}
