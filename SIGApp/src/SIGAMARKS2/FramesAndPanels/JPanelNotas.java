/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SIGAMARKS2.FramesAndPanels;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author José de Jesús Herrera Ledón
 */
public class JPanelNotas extends javax.swing.JPanel {

    /**
     * Creates new form JPanelNotas
     */
    public JPanelNotas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(153, 204, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(153, 204, 255), new java.awt.Color(153, 204, 255), new java.awt.Color(204, 255, 255)));
        setToolTipText("Notas Aclaratorias");
        setMaximumSize(new java.awt.Dimension(220, 400));
        setMinimumSize(new java.awt.Dimension(220, 100));
        setPreferredSize(new java.awt.Dimension(220, 100));
        setLayout(new java.awt.GridLayout());

        jScrollPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane1.setMaximumSize(new java.awt.Dimension(190, 100));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(190, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(190, 100));
        jScrollPane1.setWheelScrollingEnabled(false);

        jTextArea1.setColumns(1);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setTabSize(4);
        jTextArea1.setToolTipText("Nota Aclaratoria");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setMaximumSize(new java.awt.Dimension(180, 80));
        jTextArea1.setMinimumSize(new java.awt.Dimension(180, 80));
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}