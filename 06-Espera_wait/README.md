1. Per què s'atura l'execució al cap d'un temps? 
Porque todos los hilos entran en el wait y no hay ninguno que pueda notificarlos.

2. Què passaria si en lloc de una probabilitat de 50%-50% fora de 70% (ferReserva)-30% 
(cancel·lar)?
Se pararía la ejecución mucho antes.

@Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(sleepTime.nextInt(1000));
            
            Float numRandom = new Random().nextFloat();
            if (numRandom <0.7f) {
                esdeveniment.ferReserva(this);
            }else {
                esdeveniment.cancelaReserva(this);}

            }catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

  ![image](https://github.com/user-attachments/assets/73427b38-1390-4694-bcb9-2a93a5f65b3b)

 I si foren al revés les probabilitats? → Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos

 Si fuera al revés tardaría mucho más.

 @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(sleepTime.nextInt(1000));
            
            Float numRandom = new Random().nextFloat();
            if (numRandom <0.3f) {
                esdeveniment.ferReserva(this);
            }else {
                esdeveniment.cancelaReserva(this);}

            }catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

  ![image](https://github.com/user-attachments/assets/2624ecab-cc4e-4e68-8d55-ed0f3e98161d)

4. Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves?
La lista es necesaria para saber quién ha reservado y evitar errores al cancelar.
Con solo una variable de plazas, no podríamos comprobar si alguien realmente tiene una reserva.
