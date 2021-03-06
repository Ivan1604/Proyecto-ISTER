/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.PanelEstudiante;

import Controlador.Coordinador;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author 
 */
public class InicioEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;

    public InicioEstudiante(Coordinador coord) {
        initComponents();
        coordinador = coord;
        ImageIcon imagen8 = new ImageIcon("");
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

        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        Logo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TELFS: 2331-599 / 2332-554 / 2331-628");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 1360, -1));

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("E-mail: info@ister.edu.ec");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 520, -1));

        lblReloj.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        lblReloj.setForeground(new java.awt.Color(0, 153, 153));
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("RELOJ");
        add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 340, 30));

        lblNombre.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText(".");
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1380, 50));

        Logo1.setText(".");
        add(Logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 400, 170, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinFonfoRumi.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 180, 180));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblReloj;
    // End of variables declaration//GEN-END:variables
}
