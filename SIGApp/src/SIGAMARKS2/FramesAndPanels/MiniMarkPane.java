/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGAMARKS2.FramesAndPanels;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * Clase  para crear paneles de marca, 
 * un panel flotante con una marca
 * 
 *
 * @author j3su5
 */
public class MiniMarkPane extends JPanel {
    Image markIconImage;
    public MiniMarkPane() {
           this.setSize(50, 50);
           
    }

    public void drawPanelMark(String dirMark) {
        //System.out.println("MiniMarkPane .... iniciando dibujo de marca " + dirMark);
        markIconImage =  new ImageIcon(dirMark).getImage();
    }
    @Override 
    public void paintComponent(Graphics g){
        g.drawImage(markIconImage, 0, 0, null);
    }
    
}
