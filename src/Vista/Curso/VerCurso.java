/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Curso;

import Controlador.Coordinador;
import Modelo.Curso.ClaseVo;
import Modelo.Curso.CursoVo;
import Modelo.Docente.DocenteVo;
import Modelo.Materia.MateriaVo;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerCurso extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;
    MateriaVo materia1 = new MateriaVo();
    DocenteVo docente1 = new DocenteVo();

    boolean verifica1 = false;
    boolean verifica2 = false;

    DefaultTableModel md;
    String data[][] = {};
    String cabeza[] = {"Curso", "Codigo Materia", "Cedula Docente"};

    DefaultTableModel md1;
    String data1[][] = {};
    String cabeza1[] = {"Codigo", "Nombre", "Tipo", "Creditos"};

    DefaultTableModel md2;
    String data2[][] = {};
    String cabeza2[] = {"Cedula", "Nombre", "Apellido", "Creditos"};

    ArrayList<DocenteVo> docentes = new ArrayList<DocenteVo>();
    ArrayList<CursoVo> cursos = new ArrayList<CursoVo>();
    ArrayList<MateriaVo> materias = new ArrayList<MateriaVo>();

    public VerCurso(Coordinador coord) {
        initComponents();
        coordinador = coord;
        actualizarTablaCursos();
        Tcursos.setVisible(true);
        Scursos.setVisible(true);

    }



    public void actualizarTablaCursos() {
        ArrayList<CursoVo> cursos = new ArrayList<CursoVo>();
        cursos = coordinador.cursosRegistrados();
        md = new DefaultTableModel(data, cabeza) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.Tcursos.setModel(md);
        for (int i = 0; i < cursos.size(); i++) {
            String arr[] = {String.valueOf(cursos.get(i).getCodigo()), cursos.get(i).getMateria(), cursos.get(i).getDocente()};
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

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Scursos = new javax.swing.JScrollPane();
        Tcursos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INSTITUTO TECNOLÓGICO SUPERIOR \"RUMIÑAHUI\"");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1380, -1));

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CURSOS");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1380, -1));

        Tcursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Curso", "Materia", "Cod. Materia", "Docente", "C. Docente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Scursos.setViewportView(Tcursos);

        add(Scursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 1340, 250));

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TELFS: 2331-599 / 2332-554 / 2331-628");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 1360, -1));

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinFonfoRumi.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, -1, 180));
    }// </editor-fold>//GEN-END:initComponents



    public int asignaCurso() {
        Random rnd = new Random();
        int codigo = (int) (rnd.nextDouble() * 1000 + 1);
        while (coordinador.existeCurso(codigo)) {
            codigo = (int) (rnd.nextDouble() * 1000 + 1);
            System.out.println(codigo);
        }
        return codigo;
    }






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scursos;
    private javax.swing.JTable Tcursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel lblReloj;
    // End of variables declaration//GEN-END:variables
}
