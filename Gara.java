package tipsit.garacavalliconthread;

import java.lang.String;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    
    public Gara() {
        super("Gara");
        setSize(1000, 540);
        setLocation(500, 300);
        circuito = new Campo();
        JButton bottone = new JButton("Inizia gara");
       /* do {
            Scanner input = new Scanner(System.in);
            System.out.println("Scrivi su quale cavallo punti per cominciare: "); //frase iniziale
            c = input.nextInt(); //inserimento dell'input
        }while(c < 1 || c > 5); //da 1 a 5 quanti sono i cavalli
*/
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
    
    public synchronized int getPosizione(){ //metodo per ottenere la posizione
        return posizione++;
    }
    
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
    
    public void update(Graphics g) { //modifica
        paint(g);
    }
    
    
}
