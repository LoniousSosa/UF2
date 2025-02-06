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
        if (plazasDisponibles==0) {
                try {
                    assistent.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        else{
            setMaxPlazas(plazasDisponibles--);

            
            System.out.println(assistent.getName() + " ha fet una reserva. Places disponibles " 
            + plazasDisponibles);

            for (Assistent a : listaAssistents) {
                if (a==assistent) {
                    break;
                }
            }
            listaAssistents.add(assistent);
        }
    }

    public synchronized void cancelaReserva(Assistent assistent){
        for (Assistent a : listaAssistents) {
            if (assistent == a) {
                notifyAll();
                listaAssistents.remove(a);
                if (plazasDisponibles<5) {
                    setMaxPlazas(plazasDisponibles++);
                }

                
                  System.out.println(assistent.getName()+ " ha cancel·lat una reserva. Places disponibles "
                + plazasDisponibles);
                
                
                break;
            }     
        }
    }
}