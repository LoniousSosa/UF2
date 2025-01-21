Activitat 04: Join

Treballador:
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




Administració:

package com.example;

public class Administracio {
    private final int num_poblacio_activa = 50;
    private Treballador[]poblacio_activa = new Treballador[50];

    public Administracio(){

    }

    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.crearTreballadors();
        administracio.runTreballador();
        for (Treballador t : administracio.poblacio_activa) {
            try {
                t.join();
                // També pot llençar InterruptedException
            } catch (InterruptedException e) {
                System.err.println("El fil principal ha estat interromput: " + e.getMessage());
            }
        }
        for (Treballador t : administracio.poblacio_activa) {
            String cobratFormat =  String.format("%.2f", t.getCobrat());
            System.out.println(t.getName() + "  -> edat: " + t.getEdat_actual() 
            + " / total: " + cobratFormat);
        }
        
    }

    public void crearTreballadors(){
        for (int i = 0; i < num_poblacio_activa; i++) {
            this.poblacio_activa[i] = new Treballador("Ciutada-"+i, 25000f,
             20, 65);
        }
    }

    public void runTreballador(){
        for (Treballador treballador : poblacio_activa) {
            treballador.start(); 
        }
    }
}
