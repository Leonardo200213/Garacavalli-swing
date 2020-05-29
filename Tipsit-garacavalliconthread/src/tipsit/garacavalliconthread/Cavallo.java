package tipsit.garacavalliconthread;

/**
 * @author Messeri
 */

public class Cavallo implements Runnable {
    GUICavalli c;
    Gara campo;
    Thread t = new Thread(this); //dichiarazione del thread
    int posizione; //posizione del cavallo
    int velocità; //velocità del cavallo
    int conteggio;
    
    /**
     * Costruttore
     * @param horse
     * @param cam 
     */
    public Cavallo(GUICavalli horse, Gara cam){
        c = horse;
        campo = cam;
        conteggio = 0;
        velocità = 5; //impostazione velocità del cavallo
        posizione = 0; //impostazione della posizione iniziale del cavallo
        t.start(); //comincia il thread
    }
    
    /**
     * Metodo run che permette il movimento delle immagini
     */
    public void run(){
        int dimImmagine = 10;
        int dimPista = 1000;
        while((c.getX() + dimImmagine) < dimPista){ //finchè l'immagine è dentro la pista, continua
            if ((conteggio % 10) == 0){
                velocità = (int)(Math.random() * 5 + 1); //velocità del cavallo
            }
            c.setX(c.getX() + velocità); //aggiunge alla coordinata x del cavallo la velocità per farlo muovere
            conteggio++;
            try {
                Thread.sleep(75);
            }
            catch (Exception e) {}
            campo.repaint();
        }
        posizione = campo.getPosizione(); //mette come posizione quella nella classe campo
        campo.arrivi(); //annuncia gli arrivi
    }
}
