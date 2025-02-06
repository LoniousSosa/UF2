package com.example;

public class Filosof extends Thread{

    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;

    public Filosof(String name, Forquilla forquillaE, Forquilla forquillaD){
        super(name);
        this.forquillaEsquerra = forquillaE;
        this.forquillaDreta = forquillaD;
    }

    public void menja(){

    }
    
    public void pensar(){
        System.out.println(super.getName() + ": fil" + this.getId() + " pensant");
    }

    @Override
    public void run() {
        menja();
        pensar();
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
    
}
