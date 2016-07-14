/*
 * Clase que crea un JPanel y carga un PagePanel con un PDF 
 * pdfPanel -> panelPDF -> PDFFile
 * 
 */
package sigamarks;

import com.sun.pdfview.*;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author j3su5
 */
public class PDFFond extends JPanel {

    PagePanel panelPDF;
    PDFFile archivoPDF;
    int indice;
    ByteBuffer buffPersistance;
    //Costructor por default

    PDFFond() {
        panelPDF = new PagePanel();
        indice = 1;
        
    }

    //Constructor, carga la primera página de un archivo concreto cargado por buffer
    PDFFond(ByteBuffer buffer) {
        indice = 1;
        panelPDF = new PagePanel();
        if (buffer != null) {
            try {
                archivoPDF = new PDFFile(buffer);
                PDFPage pagina = archivoPDF.getPage(indice);
                panelPDF.showPage(pagina);
                buffPersistance = buffer;
                this.add(panelPDF);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "Error! -  " + ioe);
            }
        }
    }

    //Método sobrecargado paintPagePDF; 
    void paintPagePDF(int numPage) {
        try {
            archivoPDF = new PDFFile(buffPersistance);
            PDFPage page = archivoPDF.getPage(numPage);
            panelPDF.showPage(page);
            this.add(panelPDF);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error! - " + ioe);
        }
    }

    //Método para cargar una página concreta de un  documento PDF en un PagePanel *PDFView
    void paintPagePDF(ByteBuffer dirBuffer, int numPage) {
        if (dirBuffer != null) {
            try {
                buffPersistance =  dirBuffer;
                archivoPDF = new PDFFile(buffPersistance);
                PDFPage page = archivoPDF.getPage(numPage);
                panelPDF.showPage(page);
                this.add(panelPDF);  
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "Error! - " + ioe);
            }
        }
    }
    void paintPagePDF(ByteBuffer dirBuffer) {
        if (dirBuffer != null) {
            try {
                buffPersistance =  dirBuffer;
                archivoPDF = new PDFFile(dirBuffer);
                PDFPage page = archivoPDF.getPage(indice);
                panelPDF.showPage(page);
                this.add(panelPDF);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "Error! - " + ioe);
            }
        }
    }
}
