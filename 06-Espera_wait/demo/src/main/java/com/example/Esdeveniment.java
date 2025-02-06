package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Esdeveniment {

    private List<Assistent> listaAssistents;
    private int maxPlazas = 10;
    private int plazasDisponibles;
    private static Esdeveniment instanciaEsdeveniment;
    
    private Esdeveniment(){
        this.plazasDisponibles = maxPlazas;
        listaAssistents = new ArrayList<>();
    }

    private Esdeveniment(int maxPlazas){
        this.maxPlazas = maxPlazas;
        this.plazasDisponibles = maxPlazas;
        listaAssistents = new ArrayList<>();
    }

    public List<Assistent> getListaAssistents() {
        return listaAssistents;
    }

    public void setListaAssistents(List<Assistent> listaAssistents) {
        this.listaAssistents = listaAssistents;
    }
    
    public int getMaxPlazas() {
        return maxPlazas;
    }

    public void setMaxPlazas(int maxPlazas) {
        this.maxPlazas = maxPlazas;
    }

    public static Esdeveniment instanciaEsdeveniment(){
        if (instanciaEsdeveniment == null) {
            instanciaEsdeveniment = new Esdeveniment();
        }
        return instanciaEsdeveniment;
    }

    public static Esdeveniment instanciaEsdeveniment(int maxPlazas){
        if (instanciaEsdeveniment == null) {
            instanciaEsdeveniment = new Esdeveniment(maxPlazas);
        }
        return instanciaEsdeveniment;
    }


    public synchronized void ferReserva(Assistent assistent){
        while (plazasDisponibles == 0) {
            try {
                wait(5000);
                return;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                
            }
        }
        plazasDisponibles--;
        listaAssistents.add(assistent);       
        System.out.println(assistent.getName() + " ha fet una reserva. Places disponibles "+ plazasDisponibles);
    }

    public synchronized void cancelaReserva(Assistent assistent){
        if (listaAssistents.remove(assistent)) {
            if (plazasDisponibles < maxPlazas) {
                plazasDisponibles++;    

            }
                System.out.println(assistent.getName()+ " ha cancel·lat una reserva. Places disponibles "
                + plazasDisponibles);
            notifyAll();
        }else System.out.println("La reserva no existeig. Places disponibles " + plazasDisponibles );
    }
}