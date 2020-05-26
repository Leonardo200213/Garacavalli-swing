package tipsit.garacavalliconthread;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Messeri
 */

public class GUICavalli extends JPanel {
    int coordx, coordy;
    Image img;
    
    public GUICavalli(int y, int x) throws IOException {
        coordx = 0;
        coordy = y;
        setSize(80, 90);
        Toolkit tk = Toolkit.getDefaultToolkit(); //Toolkit: lavorare con la grandezza dello schermo
        switch (x) {
            case 1: {
                img = tk.getImage(getClass().getResource("cavallo1.jpg"));
                break;
            }
            case 2: {
                img = tk.getImage(getClass().getResource("cavallo2.png"));
                break;
            }
            case 3: {
                img = tk.getImage(getClass().getResource("cavallo3.png"));
                break;
            }
            case 4: {
                img = tk.getImage(getClass().getResource("cavallo4.jpg"));
                break;
            }
            case 5: {
                img = tk.getImage(getClass().getResource("cavallo5.jpg"));
                break;
            }
        }
        MediaTracker tracker = new MediaTracker(this); //mediatracker: per velocizzare il caricamento e l'inserimento delle immagini
        tracker.addImage(img, 1);
    }
    
    public void setX(int m){
        coordx = m;
    }
    
    public int getX(){
        return coordx;
    }
    
    public void paint(Graphics g) {
        g.drawImage(img,  coordx,  coordy, null);
    }
}
