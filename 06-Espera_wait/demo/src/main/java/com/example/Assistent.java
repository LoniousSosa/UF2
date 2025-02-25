package com.example;

import java.util.Random;

public class Assistent extends Thread{

    private Esdeveniment esdeveniment;
    private String name;
    private Random sleepTime;

    public Assistent(String name){
        super(name);
        esdeveniment = Esdeveniment.instanciaEsdeveniment();
        sleepTime = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(sleepTime.nextInt(1000));
            
            int numRandom = new Random().nextInt(2);
            if (numRandom ==0) {
                esdeveniment.ferReserva(this);
            }else {
                esdeveniment.cancelaReserva(this);}

            }catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
