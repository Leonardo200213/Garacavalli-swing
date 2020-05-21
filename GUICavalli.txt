package tipsit.garacavalliconthread;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * @author Messeri
 */

public class GUICavalli extends JPanel {
    int coordx, coordy;
    Image img;
    
    public GUICavalli(int y, int x) {
        coordx = 0;
        coordy = y;
        setSize(80, 90);
        Toolkit tool = Toolkit.getDefaultToolkit(); //Toolkit: lavorare con la grandezza dello schermo
        switch (x) {
            case 1: {
                img = tool.getImage("");
                break;
            }
            case 2: {
                img = tool.getImage("");
                break;
            }
            case 3: {
                img = tool.getImage("");
                break;
            }
            case 4: {
                img = tool.getImage("");
                break;
            }
            case 5: {
                img = tool.getImage("");
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
