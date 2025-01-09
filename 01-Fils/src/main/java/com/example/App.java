package com.example;
public class App extends Thread
{
    int contador;

    public App (String name){
        super(name);
        this.contador = 0;
    }

    public static void main(String[] args) {
        App a = new App("Joan");
        App b = new App("Pepe");

        a.start();
        b.start();
        
        
    }

    @Override
    public void run(){
        while (contador <9) {
            contador++;
            try {
                this.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(this.getName() + " " + this.contador);
        }
        System.out.println("Termina el fil " + this.getName());
    }
}