package com.example;

import java.util.ArrayList;
import java.util.List;

public class Taula {
    public List<Filosof> comensals;
    public List<Forquilla> forquilles;

    public Taula(int num){
        comensals = new ArrayList<>();
        forquilles = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            forquilles.add(new Forquilla(i));
        }
        for (int i = 0; i < num; i++) {
            if (i != num-1) {
                comensals.add(new Filosof("Filòsof "+ i, i,forquilles.get(i),forquilles.get(i+1)));
            }else comensals.add(new Filosof("Filòsof "+ i, i,forquilles.get(i),forquilles.get(0)));
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }

    public void showTaula(){
        for (Filosof filosof : comensals) {
            System.out.println("Comensal:fil"+(filosof.getNumComensal())+" esq:"+ filosof.getForquillaEsquerra().getNumForquilla()
            + " dret:" + filosof.getForquillaDreta().getNumForquilla());
        }
        System.out.println("-------------------------------");
    }

    public void cridarATaula(){

        for (Filosof filosof : comensals) {
            filosof.start();
        }
    }

}
