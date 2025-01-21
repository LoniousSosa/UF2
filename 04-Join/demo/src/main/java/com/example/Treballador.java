package com.example;

public class Treballador extends Thread {
    private float nou_anual_brut;
    private int edat_inici_treball;
    private int edat_final_treball;
    private int edat_actual;
    private float cobrat;

    public Treballador(String nom, float nou_anual_brut, int edat_inici_treball, int edat_final_treball) {
        super(nom);
        this.nou_anual_brut = nou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_final_treball = edat_final_treball;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
    }

    public void cobra() {
        cobrat += this.nou_anual_brut/12f;
    }

    public void pagaImpostos() {
        cobrat -= (this.nou_anual_brut/12f)*0.24f;
    }

    public int getEdat_actual() {
        return edat_actual;
    }

    public float getCobrat() {
        return cobrat;
    }

    @Override
    public void run() {
        this.edat_actual = edat_inici_treball;
        while (this.edat_actual<edat_final_treball) {
            for (int i = 0; i < 12; i++) {
                cobra();
                pagaImpostos();
            }
            
            edat_actual++;
        }
        
    };
}
