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