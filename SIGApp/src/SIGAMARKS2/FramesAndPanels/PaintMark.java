/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGAMARKS2.FramesAndPanels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author j3su5
 */
public class PaintMark extends JComponent {

    
    Graphics2D graphics2D;
    Image image;

    /**
     * PaintMark es un método sorbecargado de la clase JComponent se llama cada
     * vez que se dibuja el componente, en este caso es una imagen del tamaño de
     * un documento y mark reprecenta un ImageIcon que enviado por referencia
     * que reprecenta una marca de auditor
     *
     * 
     */
    public PaintMark() {
        setDoubleBuffered(false);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(1200, 1070);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void drawMark(int xPos, int yPos, Image marca, JPanel invoquer) {
        if (image == null) {
            image = createImage(1200, 1070);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        System.out.println("Posicion de marca x: " + xPos );
        System.out.println("Posicion de marca y: " + yPos);
        System.out.println("Imagen de marca: " + marca.toString());
        graphics2D.drawImage(marca, xPos, yPos,invoquer);
        //repaint();
    }
}
