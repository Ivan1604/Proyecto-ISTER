/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.PanelDocente;

import Vista.PanelEstudiante.*;
import Vista.Curso.*;
import Controlador.Coordinador;
import Modelo.Curso.ClaseVo;
import Modelo.Curso.CursoVo;
import Modelo.Docente.DocenteVo;
import Modelo.Estudiante.EstudianteVo;
import Modelo.Materia.MateriaVo;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AsistenciaDocente extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;
    MateriaVo materia1 = new MateriaVo();
    DocenteVo docente1 = new DocenteVo();
    ArrayList<EstudianteVo> estudiantes;

    boolean verifica1 = false;
    boolean verifica2 = false;

    DefaultTableModel md;
    String data[][] = {};
    String cabeza[] = {"Cedula", "Nombres", "Apellidos", "Asiste"};

    ArrayList<DocenteVo> docentes = new ArrayList<DocenteVo>();
    ArrayList<CursoVo> cursos = new ArrayList<CursoVo>();
    ArrayList<MateriaVo> materias = new ArrayList<MateriaVo>();

    public AsistenciaDocente(Coordinador coord) {
        initComponents();
        coordinador = coord;

    }

    public void llenaTablaLista() {
        md = new DefaultTableModel(data, cabeza) {

            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                }
                return false;
            }
        };
        this.TLista.setModel(md);
        estudiantes = new ArrayList<EstudianteVo>();
        estudiantes = coordinador.EstudiantesCurso(coordinador.getClase().getCurso());
        for (int i = 0; i < estudiantes.size(); i++) {
            Object arr[] = {estudiantes.get(i).getCedula(), estudiantes.get(i).getNombre1() + " " + estudiantes.get(i).getNombre2(), estudiantes.get(i).getApellido1() + " " + estudiantes.get(i).getApellido2(), false};
            md.addRow(arr);
        }
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < 3; i++) {
            TLista.getColumnModel().getColumn(i).setCellRenderer(tcr);
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

        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        Scursos = new javax.swing.JScrollPane();
        TLista = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONTROL DE ASISTENCIA");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 680, -1));

        btnGuardar.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 130, 40));

        TLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombres", "Apellidos", "Asiste"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TLista.setRowHeight(25);
        TLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TListaMouseClicked(evt);
            }
        });
        Scursos.setViewportView(TLista);

        add(Scursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 1360, 460));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TELFS: 2331-599 / 2332-554 / 2331-628");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 1360, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("E-mail: info@ister.edu.ec");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 670, 520, -1));

        lblReloj.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("RELOJ");
        add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 670, 360, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinBase.png"))); // NOI18N
        jLabel1.setText(".");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, 230));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinFonfoRumi.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, -1, 180));
    }// </editor-fold>//GEN-END:initComponents


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro?");
        if (resp == 0) {
            for (int i = 0; i < estudiantes.size(); i++) {
                coordinador.registraAsistencia(TLista.getValueAt(i, 0).toString(), coordinador.getClase().getCurso(), (boolean) TLista.getValueAt(i, 3));
            }
            JOptionPane.showMessageDialog(null, "Se ha tomado lista de forma exitosa", "Registro de Asistencia", JOptionPane.WARNING_MESSAGE);
            coordinador.verificaAsistencia(coordinador.getClase().getCurso());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    private void TListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TListaMouseClicked

    }//GEN-LAST:event_TListaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scursos;
    public javax.swing.JTable TLista;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel lblReloj;
    // End of variables declaration//GEN-END:variables
}