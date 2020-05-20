package tipsit.garacavalliconthread;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Messeri
 */

public class Campo extends JPanel{
    public void paint(Graphics g) { //metodo per disegnare
        g.setColor(Color.lightGray); //aggiungo il colore di sfondo
        g.fillRect(0, 0, 1000, 500); //dimensione colore sfondo (coordinata x, coordinata y, larghezza del rettangolo da colorare, altezza)
        g.setColor(Color.red); //colore dopo linea del traguardo
        g.fillRect(960, 0, 40, 500); //grandezza del colore dopo linea del traguardo
        g.setColor(Color.black); //aggiungo il colore delle separazioni delle corsie
        g.fillRect(0, 0, 1000, 5); //dimensione della corsia (coordinata x, coordinata y, larghezza del rettangolo da colorare, altezza)
        g.fillRect(0, 100, 1000, 5);
        g.fillRect(0, 200, 1000, 5);
        g.fillRect(0, 300, 1000, 5);
        g.fillRect(0, 400, 1000, 5);
        g.fillRect(0, 500, 1000, 5);
        g.fillRect(960, 0, 5, 500); //riga del traguardo
    }
}
