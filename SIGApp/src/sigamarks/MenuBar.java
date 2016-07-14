/*
 * Un menú de selección, palea de simbolos para marcas
 * 
 */
package sigamarks;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author j3su5
 */
public class MenuBar {

    JPanel menuBarSimbolPanel;//Panel que contiene una barra de herramientas 
    Image markSelect;///Variable que utiliza el panel de Dibujo y almacena la marca seleccionada
    JToolBar JToolBarMarks;///Componene de JToolBar que contendrá los simbolos

    MenuBar() {
        //Inicializa lo elementos
        menuBarSimbolPanel = new JPanel();
        JToolBarMarks      = new JToolBar();
        
        //Carga la dimencion de los iconos en los botones
        int dimencion_icono = 35;
        //Carga los iconos de las imagenes
        Icon icon_AIQDC = new ImageIcon("Marcas/AIQDC.png");
        Icon icon_CC    = new ImageIcon("Marcas/CC.png");
        Icon icon_CO    = new ImageIcon("Marcas/CO.png");
        Icon icon_CP    = new ImageIcon("Marcas/CP.png");
        Icon icon_DDAI  = new ImageIcon("Marcas/DDAI.png");
        Icon icon_DNRR  = new ImageIcon("Marcas/DNRR.png");
        Icon icon_DR    = new ImageIcon("Marcas/DR.png");
        Icon icon_PA    = new ImageIcon("Marcas/PA.png");
        Icon icon_VDF   = new ImageIcon("Marcas/VDF.png");
        Icon icon_VF    = new ImageIcon("Marcas/VF.png");
        Icon icon_OAV   = new ImageIcon("Marcas/OAV.png");
        Icon icon_OBS   = new ImageIcon("Marcas/OBS.png");
        Icon icon_SPA   = new ImageIcon("Marcas/SPA.png");
        Icon icon_NA    = new ImageIcon("Marcas/NA.png");
        Icon icon_FDI   = new ImageIcon("Marcas/FDI.png");
        Icon icon_NAcl  = new ImageIcon("Marcas/NAcl.png");
        Icon icon_SUMA  = new ImageIcon("Marcas/SUMA.png");
        Icon icon_VS    = new ImageIcon("Marcas/VS.png");
        
        
        
        
        
        //////Crea los botones 
        JButton B_AIQDC = new JButton(icon_AIQDC);
        B_AIQDC.setToolTipText("Anotaciones incorrectas que NO deben considerarse");
        
        JButton B_CC = new JButton(icon_CC);
        B_CC.setToolTipText("Confirmaci\u00f3n por Compulsa: Indica que se obtuvo informaci\u00f3n \n"
                + "y documentaci\u00f3n de terceros relacionados para confirmar algunas de las operaci\u00f3nes \n"
                + "relacionadas con las Entidades o Dependencias");
        
        JButton B_CO = new JButton(icon_CO);
        B_CO.setToolTipText("Conector de Operaci\u00f3n");
        
        JButton B_CP = new JButton(icon_CP);
        B_CP.setToolTipText("Conector de p\u00e1gina");
        
        JButton B_DDAI = new JButton(icon_DDAI);
        B_DDAI.setToolTipText("Diferencia Determinada por Auditoria Interna");
        
        JButton B_DNRR = new JButton(icon_DNRR);
        B_DNRR.setToolTipText("Documentaci\u00f3n que no re\u00fane requisitos fiscanes,\n"
                + "normativos o de control");
        
        JButton B_DR = new JButton(icon_DR);
        B_DR.setToolTipText("Documento Revisado * ");
        
        JButton B_VDF = new JButton(icon_VDF);
        B_VDF.setToolTipText("Verificado con documentaci\u00f3n fuente");
        
        JButton B_VF = new JButton(icon_VF);
        B_VF.setToolTipText("Verificado f\u00edsicamente");
        
        JButton B_OAV = new JButton(icon_OAV);
        B_OAV.setToolTipText("Operaci\u00f3n aritm\u00e9tica verificada");
        
        JButton B_PA = new JButton(icon_PA);
        B_PA.setToolTipText("Pendiente atendido ");
        
        JButton B_OBS = new JButton(icon_OBS);
        B_OBS.setToolTipText("Observaci\u00f3n: Debilidad de control interno o hallazgo");
        
        JButton B_SPA = new JButton(icon_SPA);
        B_SPA.setToolTipText("Seleccionado para an\u00e1lisis");
        
        JButton B_NAcl = new JButton(icon_NAcl);
        B_NAcl.setToolTipText("Notas Aclaratorias");
        
        JButton B_FDI = new JButton(icon_FDI);
        B_FDI.setToolTipText("Fuentes de datos e informaci/u00f3n");
        
        JButton B_NA = new JButton(icon_NA);
        B_NA.setToolTipText("No Aplica");
        
        JButton B_SUMA = new JButton(icon_SUMA);
        B_SUMA.setToolTipText("Sumas realizadas por los auditores para integrar una cantidad a verificar");
        
        JButton B_VS = new JButton(icon_VS);
        B_VS.setToolTipText("Verificado con Sisema * ");
        
        
        
        
        //Define el tamaño de los botones
        B_AIQDC.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_CC.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_CO.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_CP.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_DDAI.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_DNRR.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_DR.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_VDF.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_VF.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_OAV.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_PA.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_OBS.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_SPA.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_NAcl.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_FDI.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_NA.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_SUMA.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        B_VS.setPreferredSize(new Dimension(dimencion_icono, dimencion_icono));
        
        
        
        
        
        
        //////////////////////////////////////////////////////////////////////////Crear una ayuda para cada uno
        //Crea las acciones relacionadas a los eventos 
        B_AIQDC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/AIQDC.png").getImage();
            }
        });
        B_CC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/CC.png").getImage();
            }
        });
        B_CO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/CO.png").getImage();
            }
        });
        B_CP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/CP.png").getImage();
            }
        });
        B_DDAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/DDAI.png").getImage();
            }
        });
        B_DNRR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/DNRR.png").getImage();
            }
        });
        B_DR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/DR.png").getImage();
            }
        });
        B_VDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/VDR.png").getImage();
            }
        });
        B_VF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/VR.png").getImage();
            }
        });
        B_OAV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/OAV.png").getImage();
            }
        });
        B_PA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/PA.png").getImage();
            }
        });
        B_OBS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/OBS.png").getImage();
            }
        });
        B_SPA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/SPA.png").getImage();
            }
        });
        B_NAcl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/NAcl.png").getImage();
            }
        });
        B_FDI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/FDI.png").getImage();
            }
        });
        B_NA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/NA.png").getImage();
            }
        });
        B_SUMA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/SUMA.png").getImage();
            }
        });
        B_VS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markSelect = new ImageIcon("/Marcas/VS.png").getImage();
            }
        });
        
        
        
        
        //Agrega los botones a la barra de herramientas, los más usados // a editarse
        JToolBarMarks.add(B_AIQDC);
        //JToolBarMarks.add(B_CC);
        //JToolBarMarks.add(B_CO);
        //JToolBarMarks.add(B_CP);
        //JToolBarMarks.add(B_DDAI);
        //JToolBarMarks.add(B_DNRR);
        JToolBarMarks.add(B_DR);
        JToolBarMarks.add(B_VDF);
        JToolBarMarks.add( B_VF);
        //JToolBarMarks.add(B_OAV);
        //JToolBarMarks.add(B_PA);
        //JToolBarMarks.add(B_OBS);
        //JToolBarMarks.add(B_SPA);
        //JToolBarMarks.add(B_NAcl);
        //JToolBarMarks.add(B_FDI);
        //JToolBarMarks.add(B_NA);
        JToolBarMarks.add(B_SUMA);
        //JToolBarMarks.add(B_VS);
        //Agrega botones a la barra con todos los iconos
        menuBarSimbolPanel.add(B_AIQDC);
        menuBarSimbolPanel.add(B_CC);
        menuBarSimbolPanel.add(B_CO);
        menuBarSimbolPanel.add(B_CP);
        menuBarSimbolPanel.add(B_DDAI);
        menuBarSimbolPanel.add(B_DNRR);
        menuBarSimbolPanel.add(B_DR);
        menuBarSimbolPanel.add(B_VDF);
        menuBarSimbolPanel.add( B_VF);
        menuBarSimbolPanel.add(B_OAV);
        menuBarSimbolPanel.add(B_PA);
        menuBarSimbolPanel.add(B_OBS);
        menuBarSimbolPanel.add(B_SPA);
        menuBarSimbolPanel.add(B_NAcl);
        menuBarSimbolPanel.add(B_FDI);
        menuBarSimbolPanel.add(B_NA);
        menuBarSimbolPanel.add(B_SUMA);
        menuBarSimbolPanel.add(B_VS);
        
        
        
         //JToolBarMarks.setOpaque(false);
        
        //Agrega la barra de herraientas al Panel 
        menuBarSimbolPanel.setSize(dimencion_icono, dimencion_icono * 7);
        //menuBarSimbolPanel.add(JToolBarMarks);
        //menuBarSimbolPanel.setOpaque(false);
        
    }
}
