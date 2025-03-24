package com.example;

import java.util.ArrayList;
import java.util.List;

public class Barri {
    public static void main(String[] args) throws InterruptedException {
        Estanc estanc = new Estanc();
        List <Fumador> fumadors = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fumadors.add(new Fumador(estanc, i));
        }

        for (Fumador fumador : fumadors) fumador.start();

        while (true) {
            Thread.sleep((long) (500 + Math.random() * 500));
            estanc.nouSubministrament();
            boolean acabat = true;
            for (Fumador fumador : fumadors) {
                if (fumador.isAlive()) {
                    acabat = false;
                    break;
                }
            }
            if (acabat) {
                break;
            }
        }
        System.out.println("Estanc tancat");
        estanc.tancarEstanc();
    }
}