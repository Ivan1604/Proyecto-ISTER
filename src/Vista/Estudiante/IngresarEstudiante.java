/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Estudiante;

import Controlador.Coordinador;
import Modelo.Docente.DocenteVo;
import Modelo.Estudiante.EstudianteVo;
import Modelo.Materia.MateriaVo;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EDWIN
 */
public class IngresarEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;
    DefaultTableModel md;
    String data[][] = {};
    String cabeza[] = {"Cedula", "Nombre", "Apellido", "Carrera", "Creditos"};

    public IngresarEstudiante(Coordinador coord) {
        initComponents();
        coordinador = coord;
        actualizarTabla();
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

    public void limpiar() {
        txtApellidos.setText("");
        txtCedula.setText("");
        txtCreditos.setText("");
        txtEmail.setText("");
        txtNombres.setText("");
        txtTelefono.setText("");
        fecha.setDate(null);
    }

    public boolean validaCampos() {
        if (txtCedula.getText().equals("")) {
            return false;
        }
        if (txtCreditos.getText().equals("")) {
            return false;
        }
        if (txtNombres.getText().equals("")) {
            return false;
        }
        if (txtApellidos.getText().equals("")) {
            return false;
        }
        if (txtTelefono.getText().equals("")) {
            return false;
        }
        if (txtEmail.getText().equals("")) {
            return false;
        }
        if (fecha.getDate() == null) {
            return false;
        }
        return true;
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
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblReloj = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        fecha = new com.toedter.calendar.JDateChooser();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INGRESO DE ESTUDIANTES");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1380, -1));

        txtCedula.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 270, -1));

        txtNombres.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 270, -1));

        comboCarrera.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        comboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sistemas", "Electrónica", "Electricidad", "Gastronomía", "Turismo", "Diseño Gráfico", "Administración" }));
        add(comboCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 270, -1));

        txtCreditos.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        txtCreditos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCreditosKeyTyped(evt);
            }
        });
        add(txtCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 70, -1));

        btnLimpiar.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 120, 30));

        btnGuardar.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 120, 30));

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
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 770, 220));

        lblReloj.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("RELOJ");
        add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 360, -1));

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

        jLabel16.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Nombres:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 240, -1));

        jLabel17.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Apellidos:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 240, -1));

        jLabel18.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Carrera:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 240, -1));

        jLabel19.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Fecha de Nacimiento:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 240, -1));

        jLabel20.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Teléfono:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 240, -1));

        jLabel21.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("e-mail:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 240, -1));

        jLabel22.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Créditos:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 240, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinBase.png"))); // NOI18N
        jLabel1.setText(".");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, 230));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinFonfoRumi.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, -1, 180));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "Pasaporte" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });
        add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCreditosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreditosKeyTyped
        coordinador.logica.validaNumero(evt);
    }//GEN-LAST:event_txtCreditosKeyTyped

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (comboTipo.getSelectedItem().toString().equals("Cedula")) {
            if (validaCampos()) {
                if (coordinador.logica.validaCedula(txtCedula.getText())) {
                    if (!coordinador.existeEstudiante(txtCedula.getText())) {
                        String cedula = txtCedula.getText();
                        String pass = txtCedula.getText();
                        String[] nombres = txtNombres.getText().split(" ");
                        if (nombres.length != 2) {
                            JOptionPane.showMessageDialog(null, "Ingrese los dos nombres e intente de nuevo.", "Error de Registro", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        String[] apellidos = txtApellidos.getText().split(" ");
                        if (apellidos.length != 2) {
                            JOptionPane.showMessageDialog(null, "Ingrese los dos apellidos e intente de nuevo.", "Error de Registro", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        String carrera = (String) comboCarrera.getSelectedItem();
                        Date date = fecha.getDate();
                        String telefono = txtTelefono.getText();
                        String mail = txtEmail.getText();
                        int creditos = Integer.parseInt(txtCreditos.getText());
                        int creditos1 = Integer.parseInt(txtCreditos.getText());
                        File fichero = new File("foto.jpg");
                        EstudianteVo estudiante = new EstudianteVo(carrera.toUpperCase(), cedula, nombres[0].toUpperCase(), nombres[1].toUpperCase(), apellidos[0].toUpperCase(), apellidos[1].toUpperCase(), telefono, mail, pass, creditos, creditos1, date, fichero);
                        coordinador.ingresarEstudiante(estudiante);
                        limpiar();
                        actualizarTabla();
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "El estudiante ya se encuentra registrado en el sistema.", "Error de Registro", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una cedula correcta", "Error de Registro", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, "LLene todos los campos e inténte de nuevo", "Campos sin llenar", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (comboTipo.getSelectedItem().toString().equals("Pasaporte")) {
            if (validaCampos()) {
                if (!coordinador.existeEstudiante(txtCedula.getText())) {
                    String cedula = txtCedula.getText();
                    String pass = txtCedula.getText();
                    String[] nombres = txtNombres.getText().split(" ");
                    if (nombres.length != 2) {
                        JOptionPane.showMessageDialog(null, "Ingrese los dos nombres e intente de nuevo.", "Error de Registro", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String[] apellidos = txtApellidos.getText().split(" ");
                    if (apellidos.length != 2) {
                        JOptionPane.showMessageDialog(null, "Ingrese los dos apellidos e intente de nuevo.", "Error de Registro", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String carrera = (String) comboCarrera.getSelectedItem();
                    Date date = fecha.getDate();
                    String telefono = txtTelefono.getText();
                    String mail = txtEmail.getText();
                    int creditos = Integer.parseInt(txtCreditos.getText());
                    int creditos1 = Integer.parseInt(txtCreditos.getText());
                    File fichero = new File("foto.jpg");
                    EstudianteVo estudiante = new EstudianteVo(carrera.toUpperCase(), cedula, nombres[0].toUpperCase(), nombres[1].toUpperCase(), apellidos[0].toUpperCase(), apellidos[1].toUpperCase(), telefono, mail, pass, creditos, creditos1, date, fichero);
                    coordinador.ingresarEstudiante(estudiante);
                    limpiar();
                    actualizarTabla();
                    return;
                }
                JOptionPane.showMessageDialog(null, "El estudiante ya se encuentra registrado en el sistema.", "Error de Registro", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "LLene todos los campos e inténte de nuevo", "Campos sin llenar", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        coordinador.logica.validaNumero(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        coordinador.logica.validaNumero(evt);
    }//GEN-LAST:event_txtCedulaKeyTyped


    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased

        String valor = txtCedula.getText();
        ArrayList<EstudianteVo> estudiante = new ArrayList<EstudianteVo>();
        estudiante = coordinador.estudiantesCoincidencia(valor);
        actualizarTablaCoincidencias(estudiante);
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboCarrera;
    private javax.swing.JComboBox<String> comboTipo;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
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
