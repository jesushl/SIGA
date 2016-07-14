/*
 * Clase que crea un JPanel y carga un PagePanel con un PDF 
 * pdfPanel -> panelPDF -> PDFFile
 * 
 */
package SIGAMARKS2.FramesAndPanels;

import com.sun.pdfview.*;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.swing.JOptionPane;

/**
 * Clase que carga un Panel de PDF utilizando la libreria pdfview
 * (com.sun.pdfview)
 *
 * @author j3su5
 */
public class PDFFond extends PagePanel {

    PDFFile archivoPDF;
    int indice;
    ByteBuffer buffPDFDirPersistance;
    //Costructor por default

    /**
     * Constructor sin parametros, sólo carga un indice
     */
    PDFFond() {

        indice = 1;

    }

    /**
     * Constructor, carga la primera página de un archivo concreto cargado por
     * buffer
     */
    PDFFond(ByteBuffer buffer) {
        indice = 1;
        if (buffer != null) {
            try {
                archivoPDF = new PDFFile(buffer);
                PDFPage pagina = archivoPDF.getPage(indice);
                this.showPage(pagina);
                buffPDFDirPersistance = buffer;
                this.setBackground(Color.white);
                //this.add(panelPDF);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "Error! -  " + ioe);
            }
        }
    }

    /**
     * Método sobrecargado paintPagePDF;
     */
    void paintPagePDF(int numPage) {
        try {
            archivoPDF = new PDFFile(buffPDFDirPersistance);
            PDFPage page = archivoPDF.getPage(numPage);
            this.showPage(page);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error! - " + ioe);
        }
    }

    /**
     * Método para cargar una página concreta de un documento PDF en un
     * PagePanel *PDFView
     */
    public void paintPagePDF(ByteBuffer dirBuffer, int numPage) {
        if (dirBuffer != null) {
            try {
                buffPDFDirPersistance = dirBuffer;
                archivoPDF = new PDFFile(buffPDFDirPersistance);
                PDFPage page = archivoPDF.getPage(numPage);
                this.showPage(page);
                ////////////zooom
                float tr[] = {(float) 1, 0, 0, (float) 1, 0, 0};
                AffineTransform trans = new AffineTransform(tr);
                page.addCommands(page, trans);
            } catch (IOException ioe) {
                System.out.println("Error e paintPagePDF");
                JOptionPane.showMessageDialog(null, "Error! - " + ioe);
            }
        }
    }

    /**
     * Costructor que solo recibe el buffer de dirección de archivo
     *
     * @param dirBuffer
     */
    void paintPagePDF(ByteBuffer dirBuffer) {
        if (dirBuffer != null) {
            try {
                buffPDFDirPersistance = dirBuffer;
                archivoPDF = new PDFFile(dirBuffer);
                PDFPage page = archivoPDF.getPage(indice);
                this.showPage(page);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "Error! - " + ioe);
            }
        }
    }

    public void paintNextPage() {
        int numPag = archivoPDF.getNumPages();
        if (indice < numPag) {
            indice = indice + 1;
            paintPagePDF(buffPDFDirPersistance, indice);
            System.out.println("PDFFond..... paintNextPage ....  -  Pagina: " + indice);
        }else{
            System.out.println("Fin del documento");
        }        
    }
    
    public void paintPreviusPage(){
        if(indice >1){
            indice = indice - 1 ;
            paintPagePDF(buffPDFDirPersistance, indice);
            System.out.println("PDFFond..... paintPreviusPage .... - Page " +  indice);
        }else{
            System.out.println("Págínainicial del documento");
        }
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public ByteBuffer getBuffPDFDirPersistance() {
        return buffPDFDirPersistance;
    }

    public void setBuffPDFDirPersistance(ByteBuffer buffPDFDirPersistance) {
        this.buffPDFDirPersistance = buffPDFDirPersistance;
    }

    
}
