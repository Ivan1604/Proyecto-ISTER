/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Estudiante;

import Controlador.Coordinador;
import Modelo.Estudiante.EstudianteVo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDWIN
 */
public class EliminarEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;
    DefaultTableModel md;
    String data[][] = {};
    String cabeza[] = {"Cedula", "Nombre", "Apellido", "Carrera", "Creditos"};

    public EliminarEstudiante(Coordinador coord) {
        initComponents();
        offCampos();
        coordinador = coord;
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
        txtCedula = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        comboCarrera = new javax.swing.JComboBox<>();
        txtCreditos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblReloj = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        fecha = new com.toedter.calendar.JDateChooser();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ELIMINACIÓN DE ESTUDIANTES");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1380, -1));

        txtCedula.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
        });
        add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 270, -1));

        txtNombres.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 270, -1));

        comboCarrera.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        comboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sistemas", "Electrónica", "Electricidad", "Gastronomía", "Turismo", "Diseño Gráfico", "Administración" }));
        add(comboCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 160, -1));

        txtCreditos.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        txtCreditos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCreditosKeyTyped(evt);
            }
        });
        add(txtCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 70, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Carrera", "Creditos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 770, 160));

        lblReloj.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("RELOJ");
        add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 360, -1));

        txtApellidos.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 270, -1));

        fecha.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 270, 20));

        txtTelefono.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 270, -1));

        txtEmail.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 270, -1));

        btnLimpiar.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 100, 30));

        btnEditar.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        btnEditar.setText("ELIMINAR");
        btnEditar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 100, 30));

        btnBuscar.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 100, 30));

        jLabel15.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Cédula:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 240, -1));

        jLabel16.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Nombres:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 240, -1));

        jLabel17.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Créditos:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 240, -1));

        jLabel18.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("e-mail:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 240, -1));

        jLabel19.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Teléfono:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 240, -1));

        jLabel20.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Fecha de Nacimiento:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 240, -1));

        jLabel21.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Carrera:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 240, -1));

        jLabel22.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Apellidos:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 240, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinBase.png"))); // NOI18N
        jLabel1.setText(".");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, 230));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinFonfoRumi.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, -1, 180));
    }// </editor-fold>//GEN-END:initComponents

    public void offCampos() {
        txtApellidos.setEnabled(false);
        txtCreditos.setEnabled(false);
        txtEmail.setEnabled(false);
        txtNombres.setEnabled(false);
        txtTelefono.setEnabled(false);
        fecha.setEnabled(false);
        comboCarrera.setEnabled(false);
        txtCedula.setEnabled(true);
        btnEditar.setEnabled(false);
        btnBuscar.setEnabled(true);
    }

    public void limpiar() {
        txtApellidos.setText("");
        txtCedula.setText("");
        txtCreditos.setText("");
        txtEmail.setText("");
        txtNombres.setText("");
        txtTelefono.setText("");
        fecha.setDate(null);
    }

    public void actualizarTablaCoincidencias(ArrayList<EstudianteVo> estudiantes) {

        md = new DefaultTableModel(data, cabeza) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabla.setModel(md);
        this.tabla.setModel(md);
        for (int i = 0; i < estudiantes.size(); i++) {
            String arr[] = {estudiantes.get(i).getCedula(), estudiantes.get(i).getNombre1(), estudiantes.get(i).getApellido1(), estudiantes.get(i).getCarrera(), String.valueOf(estudiantes.get(i).getCreditos())};
            md.addRow(arr);
        }
    }

    private void txtCreditosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreditosKeyTyped
        coordinador.logica.validaNumero(evt);
    }//GEN-LAST:event_txtCreditosKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        coordinador.logica.validaNumero(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        offCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro?");
        if (resp == 0) {
            coordinador.eliminarEstudiante(txtCedula.getText());
            actualizarTabla();
            limpiar();
            offCampos();
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void cargaTxt(EstudianteVo estudiante) {
        txtCedula.setText(estudiante.getCedula());
        txtNombres.setText(estudiante.getNombre1() + " " + estudiante.getNombre2());
        txtApellidos.setText(estudiante.getApellido1() + " " + estudiante.getApellido2());
        comboCarrera.setSelectedItem(estudiante.getCarrera());
        fecha.setDate(estudiante.getFecha());
        txtEmail.setText(estudiante.getMail());
        txtTelefono.setText(estudiante.getTelefono());
        txtCreditos.setText(String.valueOf(estudiante.getCreditos()));
    }

    public void actualizarTabla() {
        ArrayList<EstudianteVo> estudiantes = new ArrayList<EstudianteVo>();
        estudiantes = coordinador.estudiantesRegistrados();
        md = new DefaultTableModel(data, cabeza) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabla.setModel(md);
        for (int i = 0; i < estudiantes.size(); i++) {
            String arr[] = {estudiantes.get(i).getCedula(), estudiantes.get(i).getNombre1(), estudiantes.get(i).getApellido1(), estudiantes.get(i).getCarrera(), String.valueOf(estudiantes.get(i).getCreditos())};
            md.addRow(arr);
        }
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        EstudianteVo estudiante = coordinador.buscarEstudiante(txtCedula.getText());
        if (estudiante == null) {
            return;
        }
        cargaTxt(estudiante);
        onCampos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        String valor = txtCedula.getText();
        ArrayList<EstudianteVo> estudiante = new ArrayList<EstudianteVo>();
        estudiante = coordinador.estudiantesCoincidencia(valor);
        actualizarTablaCoincidencias(estudiante);
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

            int fila = tabla.rowAtPoint(evt.getPoint());
        if (fila > -1) {
            txtCedula.setText(String.valueOf(tabla.getValueAt(fila, 0)));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaMouseClicked

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    public void onCampos() {
        btnBuscar.setEnabled(false);
        txtCedula.setEnabled(false);
        btnEditar.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboCarrera;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblReloj;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCreditos;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
