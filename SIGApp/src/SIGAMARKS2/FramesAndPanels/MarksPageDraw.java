/*
 * Clase diseñada para crear un panel con marcas pintadas desde un arraylist de 
 * marcas
 */
package SIGAMARKS2.FramesAndPanels;

import mx.unam.patronato.auditoria.siga.core.model.MarcaDocumento;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import mx.unam.patronato.auditoria.siga.core.daoimpl.Marca_DocumentoDAOImpl;
import mx.unam.patronato.auditoria.siga.core.model.Documento;

/**
 * Clase que genera un JComponent donde se dibujan marcas. La lista MarkItem
 * guarda el nombre de la imagen, su posición en "x" y "y" y el método
 * paintMarks las dibuja sobre el objeto markedPanelImage, una imagen del mismo
 * tamaño que el MarksPageDraw.
 *
 * @since 18-Sep-2013
 * @author j3su5 Herrera Ledón
 */
public class MarksPageDraw extends JComponent {

    private List<MarcaDocumento> marksList;
    private String pathImagens;//carpeta de imagenes 
    Graphics2D graphics2D; //objeto que retiene los valores de gratphics 
    Image mark;       //Imagen creada a partir del archivo png utilizado
    Graphics graphicsFromCaller;
    boolean isBegin;
    JPanel originalPanel;
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Costructor por defecto, los valores por defecto son List <MarkItem>
     * marksList = null height = 0; weight = 0; String pathImagens =
     * "src\\SIGAMARKS2\\XMLMArksFile\\" Graphics graphics2D e Image
     * markedPanelImage no se inicializan
     *
     */
    public MarksPageDraw() {
        System.out.println("MarksPageDraw creado . . . . . sin lista de marcas, recervando memoria");
        marksList = null;
        pathImagens = "src\\SIGAMARKS2\\marksIconsFile\\";
        //C:\Users\auditor\JESUS\SIGAMarks\src\SIGAMARKS2\marksIconsFile
        setOpaque(true);
    }

    /**
     * Método que crea un JComponent a partir de un JPanel del que copia sus
     * atributos y una lista de marcas
     *
     * @param originalPanel
     * @param listMark
     *
     */
    public MarksPageDraw(JPanel originalPanel, List<MarcaDocumento> listMark, String pathIconMarcs) {
        this.marksList = listMark;
        this.setSize(originalPanel.getSize());
        this.setBorder(originalPanel.getBorder());
        pathImagens = pathIconMarcs;
        graphicsFromCaller = originalPanel.getGraphics();//Obtiene el objeto graphics del penale enviado por referencia
        setOpaque(true);
        isBegin = true;
    }

    public void setMarksList(List<MarcaDocumento> marksList) {
        this.marksList = marksList;
    }

    /**
     * Método que hace una consulta a la base de datos para obtener las marcas
     * de una pagina concreta en un documento
     */
    public void recuestMarksList(Documento doc, int numPag) {
        marksList = Marca_DocumentoDAOImpl.getInstance().select(doc, numPag);
    }

    /**
     * Dibuja las marcas de una lista sobre un objeto Graphics con las marcas
     * necesarias
     *
     */
    public void paintMarks(Graphics g) {
        //System.out.println("MarksPageDraw - paintMarks ..... Número de marcas a dibujar: " + numMarks);
        if (marksList.size() > 0) {
            for (MarcaDocumento marcaDocumento : marksList) {
                //TODO IMPRIMIR CORRECTAMENTE LA INFORMACIÓN
                //System.out.println("MarksPageDraw - paintMarks ..... Marca a dibujar ID  = " + pathImagens + marcaDocumento.getIdMarca());
                //System.out.println("MarksPageDraw - paintMarks ..... Pos X " + marcaDocumento.getPosicionX() + " Pos Y "
                //       + marcaDocumento.getPosicionY());
                try {
                    mark = new ImageIcon(pathImagens + marcaDocumento.getIdMarca().getNombreMarca() + ".png").getImage();
                } catch (NullPointerException npe) {
                    System.out.println(npe.toString());
                }
                //System.out.println("MarksPageDraw - paintMarks ..... El tamaño de panel es " + originalPanel.getSize().width + " " + originalPanel.getSize().height);
                int posMarkX = marcaDocumento.getPosicionX().intValue();
                int posMarkY = marcaDocumento.getPosicionY().intValue();
                //Toma la imagen mostrada por el panel y le adiere una marca y así suscesiva mente
                try {
                    g.drawImage(mark, (posMarkX - 20), (posMarkY - 20), null);
                } catch (NullPointerException ev) {
                    System.out.println("Fallo en dibujo de marcas ... " + ev.getMessage());
                }
                //System.out.println("MarksPageDraw - paintMarks ..... dibujando marca " + marcaDocumento.toString());
            }
        }
    }

    /**
     * Método paint sobre cargado que llama a paintMarks
     *
     * @param g Objeto graphics del mismo panel
     */
    @Override
    public void paintComponent(Graphics g) {
        if (isBegin) {
            graphics2D = (Graphics2D) graphicsFromCaller;
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            isBegin = false;
        }
        paintMarks(g);
    }
}
