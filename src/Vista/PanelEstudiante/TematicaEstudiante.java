/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.PanelEstudiante;

import Vista.PanelDocente.*;
import Vista.PanelEstudiante.*;
import Vista.Curso.*;
import Controlador.Coordinador;
import Modelo.Curso.ClaseVo;
import Modelo.Curso.CursoVo;
import Modelo.Docente.DocenteVo;
import Modelo.Materia.MateriaVo;
import Modelo.Tema.TemaVo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TematicaEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;
    MateriaVo materia1 = new MateriaVo();
    DocenteVo docente1 = new DocenteVo();

    DefaultTableModel md;
    String data[][] = {};
    String cabeza[] = {"Curso", "Tema", "Objetivo", "Observaciones", "Fecha"};

    ArrayList<DocenteVo> docentes = new ArrayList<DocenteVo>();
    ArrayList<CursoVo> cursos = new ArrayList<CursoVo>();
    ArrayList<MateriaVo> materias = new ArrayList<MateriaVo>();

    public TematicaEstudiante(Coordinador coord) {
        initComponents();
        coordinador = coord;
        txtMateria.setEnabled(false);
    }

    public void actualizarTabla(int codigo) {
        ArrayList<TemaVo> temas = new ArrayList<TemaVo>();
        temas = coordinador.TemaCurso(codigo);
        md = new DefaultTableModel(data, cabeza) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.Temas.setModel(md);
        for (int i = 0; i < temas.size(); i++) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String arr[] = {String.valueOf(temas.get(i).getCodigo()), temas.get(i).getTema(), temas.get(i).getObjetivo(), temas.get(i).getObs(), dateFormat.format(temas.get(i).getFecha())};
            md.addRow(arr);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        Scursos = new javax.swing.JScrollPane();
        Temas = new javax.swing.JTable();
        lblReloj = new javax.swing.JLabel();
        btnVerifica = new javax.swing.JButton();
        txtCurso = new javax.swing.JTextField();
        txtMateria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Curso:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 60, 20));

        Temas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Curso", "Tema", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Scursos.setViewportView(Temas);

        add(Scursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 1290, 330));

        lblReloj.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("RELOJ");
        add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 360, -1));

        btnVerifica.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        btnVerifica.setText("Consultar");
        btnVerifica.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnVerifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificaActionPerformed(evt);
            }
        });
        add(btnVerifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 140, 30));

        txtCurso.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        txtCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCursoActionPerformed(evt);
            }
        });
        add(txtCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 160, -1));

        txtMateria.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        txtMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMateriaActionPerformed(evt);
            }
        });
        add(txtMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 330, -1));

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Materia:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 70, 20));

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("REGISTRO TEMÁTICAS DIARIAS");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1380, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinBase.png"))); // NOI18N
        jLabel1.setText(".");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinFonfoRumi.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, -1, 180));
    }// </editor-fold>//GEN-END:initComponents


    private void btnVerificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificaActionPerformed
        if (!txtCurso.getText().equals("") && coordinador.existeCurso(Integer.parseInt(txtCurso.getText()))) {
            actualizarTabla(Integer.parseInt(txtCurso.getText()));
            txtMateria.setText(coordinador.MateriaCurso(Integer.parseInt(txtCurso.getText())).getNombre());
            txtCurso.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el curso e intentelo de nuevo", "Consulta de Tematica", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnVerificaActionPerformed

    private void txtCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCursoActionPerformed

    private void txtMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scursos;
    private javax.swing.JTable Temas;
    private javax.swing.JButton btnVerifica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JLabel lblReloj;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtMateria;
    // End of variables declaration//GEN-END:variables
}
