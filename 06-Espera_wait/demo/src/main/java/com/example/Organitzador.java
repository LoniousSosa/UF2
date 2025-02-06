package com.example;

public class Organitzador {
    private Esdeveniment esdeveniment;

    public Organitzador(){
        esdeveniment = Esdeveniment.instanciaEsdeveniment(5);
    }
    public static void main(String[] args) {
        Organitzador organitzador = new Organitzador();
        organitzador.createAssistants(10);
        organitzador.juntar();
        organitzador.runAssistants();
    }

    public void createAssistants(int numAssistants){
        for (int i = 0; i < numAssistants; i++) {
            esdeveniment.getListaAssistents().add(new Assistent("Assistent-"+i));
        }
    }

    public void juntar(){
        for (Assistent a : esdeveniment.getListaAssistents()) {
            try {
                a.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void runAssistants(){
        for (Assistent a : this.esdeveniment.getListaAssistents()) {
            a.start();
        }
    }
}
