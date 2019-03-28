/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author 
 */
public class Inicio extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;

    public Inicio(Coordinador coord) {
        initComponents();
        coordinador = coord;
        ImageIcon imagen8 = new ImageIcon("sellosinfondo.png");
        Icon icono8 = new ImageIcon(imagen8.getImage().getScaledInstance(390, 320, Image.SCALE_DEFAULT));
        Logo1.setIcon(icono8);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Logo1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INSTITUTO TECNOLÓGICO SUPERIOR \"RUMIÑAHUI\"");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1380, -1));

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TELFS: 2331-599 / 2332-554 / 2331-628");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 1380, -1));

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("E-mail: info@ister.edu.ec");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1380, -1));

        lblReloj.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        lblReloj.setForeground(new java.awt.Color(0, 153, 153));
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("RELOJ");
        add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 552, 1380, 30));

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sistema de Gestión Académico Docente");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1380, -1));

        Logo1.setText(".");
        add(Logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 390, 320));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel lblReloj;
    // End of variables declaration//GEN-END:variables
}
