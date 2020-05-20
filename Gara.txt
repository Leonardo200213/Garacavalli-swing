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
    Campo pista;
    Graphics offscreen;
    Image buffer_virtuale;
    int cav = 2;
    
    public Gara() {
        super("Gara Cavalli");
        setSize(1000, 500);
        setLocation(10, 40);
        pista = new Campo();
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Scrivi per cominciare: ");
            cav=input.nextInt();
        }while(cav<2 || cav>10);
        partecipanti = new GUICavalli[cav];
        thread = new Cavallo[cav];
        posizione = 1;
        int partenza = 15;
        for (int x2=0; x2<cav; x2++) {
            partecipanti[x2] = new GUICavalli(partenza,  x2+1);
            thread[x2] = new Cavallo(partecipanti[x2], this);
            partenza = partenza+100;
        }
        this.add(pista);
        setVisible(true);
    }
    
    public synchronized int getPosizione() {
        return posizione++;
    }
    
    public synchronized void arrivi() {
        boolean arrivati=true;
        for (int x2=0; x2<cav; x2++) {
            if (thread[x2].posizione==0) {
                arrivati=false;
            }
        }
        if(arrivati) {
            vincitore();
        }
    }
    
    public void vincitore() {
        JLabel[] arrivi;
        arrivi = new JLabel[10];
        JFrame classifica = new JFrame("Classifica");
        classifica.setSize(500, 500);
        classifica.setLocation(280, 130);
        classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
        classifica.getContentPane().setLayout(new GridLayout(5,1));
        for(int x2=1; x2<cav+1; x2++) {
            for (int y2=0; y2<cav; y2++) {
                if (thread[y2].posizione==1){
                    arrivi[y2]=new JLabel("1' classificato in " + (y2+1)+"' corsia");
                    arrivi[y2].setFont(new Font("times New Roman", Font.ITALIC, 20));
                    arrivi[y2].setForeground(Color.RED);
                    classifica.getContentPane().add(arrivi[y2]);
                    y2=10;
                    x2=11;
                }
            }
        }
        classifica.setVisible(true);
    }
    
    public void update(Graphics g) {
        paint(g);
    }
    
    public void paint(Graphics g) {
        if (partecipanti != null) {
            Graphics2D screen = (Graphics2D) g;
            buffer_virtuale= createImage(1000, 1645);
            offscreen = buffer_virtuale.getGraphics();
            Dimension d=getSize();
            pista.paint(offscreen);
            for (int x2=0; x2<cav; x2++) {
                partecipanti[x2].paint(offscreen);
            }
            screen.drawImage(buffer_virtuale, 0, 30, this);
            offscreen.dispose();
        }
    }
}
