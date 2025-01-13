Part 1:

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

Part 2:

package com.example;

public class MainDemoFil extends Thread{

    public MainDemoFil(String name){
        super(name);
    }

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("MainDemoFil.main: ");
        System.out.println("Prioritat -> " + thread.getPriority());
        System.out.println("Nom -> " + thread.getName());
        System.out.println("toString() -> " + thread.toString() + "ID: " + thread.getId());
        /**
         * Para hacerlo solo con currentThread deberíamos poner la siguiente linea de código
         *         System.out.println("toString() -> " +thread.getId()+ thread.toString());
         * Pero el resultado que nos da no incluye el id que se ve en el resultado del enunciado.
         */
        MainDemoFil hiloEstilizado = new MainDemoFil(thread.getName());
        System.out.println("toString() -> " + hiloEstilizado.toString());
        /**
         * Curiosamente, el currentThread tiene como id 1 mientras que el creado manualmente
         * tiene Id 19
         */
    }

    @Override
    public String toString(){
        return "Thread[#" + this.getId() + "," + this.getName() + ","+ this.getPriority()+ "," + this.getName() + "]";
    }
}
        }
        System.out.println(this.getName() + "  -> " + this.n_gols + " gols");
    }
}

