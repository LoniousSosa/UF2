package com.example;

public class Motor extends Thread {
    private int potenciaObjetivo;
    private int potenciaActual;
    private String potenciaDireccion;
    private int position;

    public Motor(int position){
        this.position = position;
        this.potenciaActual = 0;
    }
    
    public void setPotencia(int potenciaObjetivo){
        this.potenciaObjetivo = potenciaObjetivo;
    }

    @Override
    public void run() {
        while (true) {
            potenciaDireccion = "FerRes.";
            while (potenciaActual != potenciaObjetivo) {
                try {
                    Thread.sleep((int) (Math.random() * 1000 + 1000));
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                    if (potenciaActual < potenciaObjetivo) {
                        potenciaDireccion = "Incre.";
                        potenciaActual++;
                    }
            
                    else {
                        potenciaActual--;
                        potenciaDireccion = "Decre.";
                    }
                System.out.println("Motor " +position+": "+potenciaDireccion+ " Objectiu: "+
                potenciaObjetivo+ " Actual:"+ potenciaActual);
                } 
                
                if (potenciaActual == 0) {
                    System.out.println("Motor apagado");
                    break;
                }
        }
    }
}