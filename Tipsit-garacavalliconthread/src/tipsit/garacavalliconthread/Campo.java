package tipsit.garacavalliconthread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Messeri
 */

public class Campo extends JPanel{
    /**
     * Metodo per la creazione del campo 
     * @param g 
     */
    public void paint(Graphics g) { //metodo per disegnare
        //JButton b = new JButton("Inizia gara");
        //add(b);
        g.setColor(Color.gray); //aggiungo il colore di sfondo
        g.fillRect(0, 0, 1000, 1000); //dimensione colore sfondo (coordinata x, coordinata y, larghezza del rettangolo da colorare, altezza)
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, 70, 1000);
        g.setColor(Color.red); //colore dopo linea del traguardo
        g.fillRect(960, 0, 40, 1000); //grandezza del colore dopo linea del traguardo
        g.setColor(Color.black); //aggiungo il colore delle separazioni delle corsie
        g.fillRect(0, 0, 1000, 5); //dimensione della corsia (coordinata x, coordinata y, larghezza del rettangolo da colorare, altezza)
        g.fillRect(0, 100, 1000, 5);
        g.fillRect(0, 200, 1000, 5);
        g.fillRect(0, 300, 1000, 5);
        g.fillRect(0, 400, 1000, 5);
        g.fillRect(0, 500, 1000, 5);
        g.fillRect(0, 600, 1000, 5);
        g.fillRect(0, 700, 1000, 5);
        g.fillRect(0, 800, 1000, 5);
        g.fillRect(0, 900, 1000, 5);
        g.fillRect(0, 1000, 1000, 5);
        g.fillRect(960, 0, 5, 1000); //riga del traguardo
        g.fillRect(70, 0, 5, 1000); //riga iniziale
    }
}
