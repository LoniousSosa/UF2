package com.example;

import java.util.Scanner;

public class Coet{

    Motor[] motors;
    int potenciaScanner;
    static Scanner scanner;
    int contador = 0;
    static int potenciaObjetivo;

    public Coet(Motor[]motors){
        this.motors = motors;
    }

    public static void main(String[] args) {
        Motor[]motors = new Motor[4];
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
        Coet coet = new Coet(motors);
        scanner = new Scanner(System.in);
        potenciaObjetivo = scanner.nextInt();
        System.out.println("Passant a potencia "+potenciaObjetivo);
        
        while (potenciaObjetivo<0 || potenciaObjetivo > 10) {
            System.out.println("Potència fora de rang! Torna-ho a intentar.");
            potenciaObjetivo = scanner.nextInt();
        }
        for (Motor motor : coet.motors) {
            motor.start();
        }
        coet.arranca();      
      }

    public void arranca(){
        while (true) {
            if (potenciaObjetivo <0 || potenciaObjetivo >10) {
                System.out.println("Potència fora de rang! Torna-ho a intentar.");
                potenciaObjetivo = scanner.nextInt();
                continue;
            }
            else{
                for (Motor motor : this.motors) {
                    motor.setPotencia(potenciaObjetivo);
                    }
                    potenciaObjetivo = scanner.nextInt();
                if (potenciaObjetivo < 0 || potenciaObjetivo > 10) {
                    System.out.println("Potència fora de rang! Torna-ho a intentar.");
                    continue;
                    }

                System.out.println("Passant a potencia "+potenciaObjetivo);
            }
        }
    }
}