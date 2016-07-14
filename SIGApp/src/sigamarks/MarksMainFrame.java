/*
 * Frame principal que contiene todos los paneles relacionados con 
 * la edicion de marcas en documentos PDF
 */
package sigamarks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author j3su5
 */
public class MarksMainFrame {

    JFrame principalFrame;
    JMenuBar MenuSerchFile;        //Crea un menu en el panel superior del Fame 
    JFileChooser PDFFileChooser;//Crea un selector de archivos para la barra de menu
    ByteBuffer buffferDir;
    PDFFond PDFPanel; //La obcion correcta es crear el PDFPAnel como una extención de JPanel
    JPanel PDFDocumentPane;//Panel para mostrar la página del PDF
    Container conteiner1;
    /////Constructor que recibe el objeto PDFPanel 
    int index;

    MarksMainFrame() {
        //
        conteiner1 = new Container();
        //
        PDFPanel = new PDFFond();
        PDFDocumentPane = new JPanel();
        principalFrame = new JFrame();
        MenuSerchFile = new JMenuBar();
        PDFFileChooser = new JFileChooser();
        index = 1;
    }

    void addMenuBarr() {
        JMenu JMenuFiles = new JMenu("Archivo");//Inicio del Menu en barra de menus
        JMenuItem JMenuItemToChooseFile = new JMenuItem("Abrir Archivo");//El boton dentro del menu
        JFileChooser JFileChoos = new JFileChooser();//El menu emergente para seleccionar archivos
        /*Accion de busqueda en el menú que envía al panel de
         documento PDF un buffer de direccion de archivo*/
        JMenuItemToChooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int op = PDFFileChooser.showOpenDialog(principalFrame);
                if (op == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = PDFFileChooser.getSelectedFile();
                        RandomAccessFile raf = new RandomAccessFile(file, "r");
                        FileChannel channel = raf.getChannel();
                        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                        //Re-dibuja el panel de fondo 
                        PDFPanel.paintPagePDF(buf, index);
                        System.out.println("Archivo con  " + PDFPanel.archivoPDF.getNumPages() + " paginas");
                        System.out.printf("Alto del documento:" + PDFPanel.getWidth() + "\nAncho del Documento: " + PDFPanel.getHeight());
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null, "Error al abrir el archivo" + ioe);
                    }
                }
            }
        });
        JMenuFiles.add(JMenuItemToChooseFile);
        MenuSerchFile.add(JMenuFiles);
    }

    void agregaCapas() {
        JLayeredPane JLayerPanel = new JLayeredPane();
        MenuBar MB = new MenuBar();
        principalFrame.setTitle("SIGA MARK5");
        principalFrame.setBackground(Color.white);

        addMenuBarr();
        //Se agregan los paneles en capas 
        /*PDFPanel.setBackground(Color.WHITE);
         principalFrame.setContentPane(PDFPanel);//
         principalFrame.getLayeredPane().add(PDFPanel,JLayeredPane.DEFAULT_LAYER,0);//
         MB.menuBarSimbolPanel.setBackground(Color.red);
         principalFrame.setContentPane(MB.menuBarSimbolPanel);
         principalFrame.getLayeredPane().add(MB.menuBarSimbolPanel,JLayeredPane.PALETTE_LAYER,0);
         //Agrega capas 
         //JLayerPanel.add(PDFPanel, new Integer(0));
         //JLayerPanel.add(MB.menuBarSimbolPanel,new Integer(500));
         //JLayerPanel.setOpaque(true);
         */

        //Experimental
        /*
         PDFDocumentPane.add(PDFPanel);
         conteiner1.add(PDFDocumentPane, BorderLayout.CENTER);
         conteiner1.add(MB.menuBarSimbolPanel,BorderLayout.NORTH);
         principalFrame.add(MB.JToolBarMarks,BorderLayout.EAST);
         principalFrame.add(conteiner1);
         */
        //  FUNCIONAL
        principalFrame.setLayout(new BorderLayout());//Layout
        //PDFDocumentPane.add(PDFPanel);
        //PDFDocumentPane.setBackground(Color.WHITE);
        principalFrame.add(PDFDocumentPane, BorderLayout.CENTER);
        //principalFrame.add(PDFPanel, BorderLayout.CENTER);
        //principalFrame.add(MB.menuBarSimbolPanel,BorderLayout.EAST);
        //principalFrame.add(MB.JToolBarMarks,BorderLayout.NORTH);

        //Funcional*/ 

        //Carga el menu de archivos y las caracteristicas de la ventana
        principalFrame.setJMenuBar(MenuSerchFile);
        principalFrame.setVisible(true);
        principalFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        principalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        MarksMainFrame MMF = new MarksMainFrame();
        MMF.agregaCapas();
    }
}
