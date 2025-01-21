package com.example;

public class Administracio {
    private final int num_poblacio_activa = 50;
    private Treballador[]poblacio_activa = new Treballador[50];

    public Administracio(){

    }

    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.crearTreballadors();
        administracio.runTreballador();
        for (Treballador t : administracio.poblacio_activa) {
            try {
                t.join();
                // També pot llençar InterruptedException
            } catch (InterruptedException e) {
                System.err.println("El fil principal ha estat interromput: " + e.getMessage());
            }
        }
        for (Treballador t : administracio.poblacio_activa) {
            String cobratFormat =  String.format("%.2f", t.getCobrat());
            System.out.println(t.getName() + "  -> edat: " + t.getEdat_actual() 
            + " / total: " + cobratFormat);
        }
        
    }

    public void crearTreballadors(){
        for (int i = 0; i < num_poblacio_activa; i++) {
            this.poblacio_activa[i] = new Treballador("Ciutada-"+i, 25000f,
             20, 65);
        }
    }

    public void runTreballador(){
        for (Treballador treballador : poblacio_activa) {
            treballador.start(); 
        }
    }
}