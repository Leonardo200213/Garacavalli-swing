package tipsit.garacavalliconthread;

import java.lang.String;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * @author Messeri
 */

public class Gara extends JFrame {
    int posizione;
    GUICavalli[] partecipanti;
    Cavallo[] thread;
    Campo circuito;
    Graphics offscreen;
    Image buffer_virtuale;
    int c = 2;
    
    /**
     * Inizio del programma
     * @throws IOException 
     */
    public Gara() throws IOException {
        super("Gara");
        setSize(1000, 1040);
        setLocation(500, 0);
        circuito = new Campo();
        //JButton bottone = new JButton("Inizia gara");
        do {
            Scanner input = new Scanner(System.in);
            /**
             * Messaggi che legge l'utente
             */
            System.out.println("Benvenuto alla gara dei cavalli");
            System.out.println("Scegli quanti cavalli vorresti che gareggiassero: "); //frase iniziale
            c = input.nextInt(); //inserimento dell'input
            if(c >= 11 || c<=1){
                System.out.println("Devi inserire un valore tra 2 e 10" + "\n");
            }
        }while(c < 2 || c > 10); //da 2 a 10 cavalli
        partecipanti = new GUICavalli[c];
        thread = new Cavallo[c];
        posizione = 1;
        int partenza = 10;
        for (int x2 = 0; x2 < c; x2++) {
            partecipanti[x2] = new GUICavalli(partenza,  x2 + 1);
            thread[x2] = new Cavallo(partecipanti[x2], this);
            partenza = partenza+100;
        }
        this.add(circuito); //aggiunge il campo tramite la variabile circuito...
        setVisible(true); //...e lo rende visibile
    }
    
    /**
     * Metodo per ottenere la posizione
     * @return 
     */
    public synchronized int getPosizione(){ //metodo per ottenere la posizione
        return posizione++;
    }
    
    /**
     * Metodo per verificare gli arrivi
     */
    public synchronized void arrivi(){
        boolean fine = true;
        for (int x2 = 0; x2 < c; x2++){
            if (thread[x2].posizione == 0){ //se la posizione è uguale a 0 significa che non è arrivato al traguardo
                fine = false;
            }
        }
        if (fine) { //altrimenti si
            vincitore();
        }
    }
    
    /**
     * Metodo che permette di mostrare il vincitore
     */
    public void vincitore(){
        JLabel[] arrivi;
        arrivi = new JLabel[10];
        JFrame classifica = new JFrame("Classifica");
        classifica.setSize(450, 200); //grandezza della finestra successiva
        classifica.setLocation(300, 150); 
        classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
        classifica.getContentPane().setLayout(new GridLayout(5,1));
        for(int x2 = 1; x2 <c + 1; x2++){
            for (int y2 = 0; y2 < c; y2++){
                if (thread[y2].posizione == 1){ //thread arrivato in prima posizione
                    arrivi[y2] = new JLabel("Il vincitore è nella corsia: " + (y2 + 1)); //messaggio del vincitore
                    arrivi[y2].setForeground(Color.black); //colore del messaggio
                    classifica.getContentPane().add(arrivi[y2]);
                    y2=10;
                    x2=11;
                }
            }
        }
        classifica.setVisible(true);
    }
    
    /**
     * Metodo che modifica la grafica aggiornando
     * @param g 
     */
    public void update(Graphics g) { //modifica
        paint(g);
    }
    
    
}
