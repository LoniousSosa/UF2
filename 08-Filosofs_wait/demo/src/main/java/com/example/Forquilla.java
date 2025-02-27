package com.example;

public class Forquilla 
{
    private int numForquilla;
    private int propietari = -1;
    private final int LLIURE = -1;

    public Forquilla(int numForquilla){
        this.numForquilla = numForquilla;
    }
    
    
    public int getNumForquilla() {
        return numForquilla;
    }


    public void setNumForquilla(int numForquilla) {
        this.numForquilla = numForquilla;
    }    

    public int getPropietari() {
        return propietari;
    }


    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }


    public int getLLIURE() {
        return LLIURE;
    }
}
