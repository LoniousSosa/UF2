package com.example;

public class Futbolista extends Thread {
    final static int NUM_JUGADORS = 11;
    final int NUM_TIRADES = 20;
    final float PROBABILITAT = 0.5f;
    private int n_gols = 0;

    public Futbolista (String name){
        super(name);
    }

    public static void main(String[] args) {
        String[]jugadors = {"Piqué","Vinicius", "Torres", "Ramos", "Ronaldo", 
             "Lewan", "Belli", "Arnau", "Aspas", "Messi", "Mbapé"};

        for(int i=0;i<NUM_JUGADORS;i++){
            Futbolista futbolista = new Futbolista(jugadors[i]);
            futbolista.start();
            try {
                futbolista.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    @Override
    public void run(){
        for(int i=0;i<NUM_TIRADES;i++){
            if (Math.random()>PROBABILITAT) {
                this.n_gols++;
            }
        }
        System.out.println(this.getName() + "  -> " + this.n_gols + " gols");
    }
    
}
