package com.example;

/**
 * Hello world!
 *
 */
public class Forquilla 
{
    private int numForquilla;
    private boolean enUs;

    public Forquilla(int numForquilla){
        this.numForquilla = numForquilla;
    }
    

    
    public int getNumForquilla() {
        return numForquilla;
    }


    public void setNumForquilla(int numForquilla) {
        this.numForquilla = numForquilla;
    }


    public boolean isEnUs() {
        return enUs;
    }


    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
