package com.example;

import java.util.Random;

public class Filosof extends Thread{

    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana = 0;
    private final Random random = new Random();
    private int forquillasEnLaMa = 0;


    public Filosof(String name, Forquilla forquillaE, Forquilla forquillaD){
        super(name);
        this.forquillaEsquerra = forquillaE;
        this.forquillaDreta = forquillaD;
    }

    public void menja(){
        if (!this.forquillaEsquerra.isEnUs()) {
            this.forquillaEsquerra.setEnUs(true);
            System.out.println(getFullInfo() + " agafa la forquilla esquerra " + 
            this.getForquillaEsquerra().getNumForquilla());
            forquillasEnLaMa++;
        }
        else{
            System.out.println(getFullInfo() + " deixa l'esquerra" + forquillaEsquerra.getNumForquilla() +
            " i espera (dreta ocupada)");
            forquillaEsquerra.setEnUs(false);
        }
        if (!this.forquillaDreta.isEnUs()) {
            this.forquillaDreta.setEnUs(true);
            System.out.println(getFullInfo() + " agafa la forquilla dreta " + 
            this.getForquillaDreta().getNumForquilla());
            forquillasEnLaMa++;
        }
        if (forquillasEnLaMa == 2) {
            System.out.println(getFullInfo() + " menja ");
            try {
                Thread.sleep(1000+ random.nextInt(1001));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            forquillasEnLaMa = 0;
            gana = 0;
            forquillaEsquerra.setEnUs(false);
            forquillaDreta.setEnUs(false);
            System.out.println(getFullInfo() + " ha acabat de menjar");
        }
        else{
            gana++;
            System.out.println(getFullInfo() + " gana: " + gana);
        }
    }
    
    public void pensar(){
        System.out.println(getFullInfo() + " pensant");
        try {
            Thread.sleep(1000+ random.nextInt(1001));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            menja();
            pensar();
        }
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }

    public int getGana() {
        return gana;
    }

    public void setGana(int gana) {
        this.gana = gana;
    }
    
    public String getFullInfo(){
        return super.getName() + ": fil" +(this.getId()-19);
    }
}
