/**
 * Questa classe è utilizzata inserire le immagini dei cavalli
 * 
*/


package tipsit.garacavalliconthread;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.*;
import java.applet.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Messeri
 */

public class GUICavalli extends JPanel {
    int coordx, coordy;
    Image img;
    
    /**
     * 
     * @param y
     * @param x
     * @throws IOException 
     */
    public GUICavalli(int y, int x) throws IOException {
        coordx = 0;
        coordy = y;
        setSize(80, 75);
        Toolkit tk = Toolkit.getDefaultToolkit(); //Toolkit: lavorare con la grandezza dello schermo
        switch (x) {
            case 1: {
                   ImageIcon img = new ImageIcon("img/cavallo1.jpg");
                   JLabel imagelabel = new JLabel(img);
                break;
            }
            case 2: {
            }
            case 3: {
            }
            case 4: {
            }
            case 5: {
            }
        }
        MediaTracker tracker = new MediaTracker(this); //mediatracker: per velocizzare il caricamento e l'inserimento delle immagini
        tracker.addImage(img, 1);
    }
    
    /**
     * Metodo per settare la coordinata X
     * @param m 
     */
    public void setX(int m){
        coordx = m;
    }
    
    /**
     * Metodo per ottenere la coordinata X
     * @return 
     */
    public int getX(){
        return coordx;
    }
    
    /**
     * Disegna l'immagine utilizzando le coordinate dichiarate in precedenza
     * @param g 
     */
    public void paint(Graphics g) {
        g.drawImage(img,  coordx,  coordy, null);
    }
}
