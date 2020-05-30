/**
 * Questa classe è utilizzata inserire le immagini dei cavalli
 * 
*/


package tipsit.garacavalliconthread;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Messeri
 */
public class GUICavalli extends JPanel{
    int coordx; //coordinata x
    int coordy; //coordinata y
    Image img; //immagine
    
    /**
     * Costruttore per settare x e y e le immagini
     * @param y coordinata y
     * @param x coordinata x
     */
    public GUICavalli(int y, int x){
        this.coordx = 0;
        this.coordy = y;
        setSize(80,80);
        Toolkit tk = Toolkit.getDefaultToolkit();
        switch(x){
            case 1: {
                img = tk.getImage("img/cavallo1.png"); 
                break;
            }
            case 2: {
                img = tk.getImage("img/cavallo2.png"); 
                break;
            }
            case 3: {
                img = tk.getImage("img/cavallo3.png"); 
                break;
            }
            case 4: {
                img = tk.getImage("img/cavallo4.png"); 
                break;
            }
            case 5: {
                img = tk.getImage("img/cavallo5.png"); 
                break;
            }
            case 6: {
                img = tk.getImage("img/cavallo6.png"); 
                break;
            }
            case 7: {
                img = tk.getImage("img/cavallo7.png"); 
                break;
            }
            case 8: {
                img = tk.getImage("img/cavallo8.png"); 
                break;
            }
            case 9: {
                img = tk.getImage("img/cavallo9.png"); 
                break;
            }
            case 10: {
                img = tk.getImage("img/cavallo10.png"); 
                break;
            }
        }
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(img, 1);
        try{mt.waitForID(1);}
        catch(InterruptedException e){}
    }
    
    /**
     * Metodo per settare la coordinata X
     * @param m 
     */
    public void setX(int n){
        this.coordx = n;
    }
    
    /**
     * Metodo per ottenere la coordinata X
     * @return 
     */
    public int getX(){
        return this.coordx;
    }
    
    /**
     * Disegna l'immagine utilizzando le coordinate dichiarate in precedenza
     * @param g 
     */
    public void paint(Graphics g){
        g.drawImage(img, coordx, coordy, null);
    }
}







