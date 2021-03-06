/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.PanelDocente;

import Vista.Curso.*;
import Controlador.Coordinador;
import Modelo.Curso.ClaseVo;
import Modelo.Curso.CursoVo;
import Modelo.Docente.DocenteVo;
import Modelo.Materia.MateriaVo;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class HorarioDocente extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;
    MateriaVo materia1 = new MateriaVo();
    DocenteVo docente1 = new DocenteVo();

    boolean verifica1 = false;
    boolean verifica2 = false;

    public HorarioDocente(Coordinador coord) {
        initComponents();
        coordinador = coord;

        Shorario.setVisible(true);
        horario.setVisible(true);

    }

    public void limpiarHorario() {
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                horario.setValueAt("", i, j);
            }
        }
    }

    public void llenaHorario() {
        ArrayList<ClaseVo> clases = new ArrayList<ClaseVo>();
        System.out.println(coordinador.getDocenteVo().getCedula());
        clases = coordinador.horarioDocente(coordinador.getDocenteVo().getCedula());
        for (int i = 0; i < 6; i++) {

            for (int j = 1; j < 6; j++) {
                for (int t = 0; t < clases.size(); t++) {
                    if (clases.get(t).getDia() == j && clases.get(t).getHora() - 1 == i) {
                        horario.setValueAt(String.valueOf(clases.get(t).getMateria()) + "-" + clases.get(t).getAula(), i, j);
                    }
                }
            }
        }
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < 6; i++) {
            horario.getColumnModel().getColumn(i).setCellRenderer(tcr);
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
        lblReloj = new javax.swing.JLabel();
        Shorario = new javax.swing.JScrollPane();
        horario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HORARIO DE CLASES");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1380, -1));

        lblReloj.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("RELOJ");
        add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 360, -1));

        Shorario.setBorder(null);
        Shorario.setToolTipText("");

        horario.setFont(new java.awt.Font("Century Schoolbook", 1, 8)); // NOI18N
        horario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1) 08H00 - 09H00", null, null, null, null, null},
                {"2) 09H00 -10H00", null, null, null, null, null},
                {"3) 10H00 - 11H00", null, null, null, null, null},
                {"4) 11H00 - 12H00", null, null, null, null, null},
                {"5) 12H00 - 13H00", null, null, null, null, null},
                {"6) 13H00 - 14H00", null, null, null, null, null}
            },
            new String [] {
                "Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        horario.setEnabled(false);
        horario.setRowHeight(40);
        horario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horarioMouseClicked(evt);
            }
        });
        Shorario.setViewportView(horario);

        add(Shorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 1260, 290));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinBase.png"))); // NOI18N
        jLabel1.setText(".");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, 230));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinFonfoRumi.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, -1, 180));
    }// </editor-fold>//GEN-END:initComponents


    private void horarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horarioMouseClicked
        int fila = horario.rowAtPoint(evt.getPoint());
        int columna = horario.columnAtPoint(evt.getPoint());
        if ((fila > -1) && horario.getValueAt(fila, columna).toString().equals("true")) {
            System.out.println(fila + "-" + columna);

        }
    }//GEN-LAST:event_horarioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Shorario;
    private javax.swing.JTable horario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel lblReloj;
    // End of variables declaration//GEN-END:variables
}
