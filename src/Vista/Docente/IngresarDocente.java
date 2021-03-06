/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Docente;

import Vista.Estudiante.*;
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
 * @author
 */
public class IngresarDocente extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;
    DefaultTableModel md;
    String data[][] = {};
    String cabeza[] = {"Cedula", "Nombre", "Apellido", "Carga Horaria"};

    public IngresarDocente(Coordinador coord) {
        initComponents();
        coordinador = coord;
        actualizarTabla();
    }

    public void actualizarTabla() {
        ArrayList<DocenteVo> docentes = new ArrayList<DocenteVo>();
        docentes = coordinador.docentesRegistrados();
        md = new DefaultTableModel(data, cabeza) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabla.setModel(md);
        for (int i = 0; i < docentes.size(); i++) {
            String arr[] = {docentes.get(i).getCedula(), docentes.get(i).getNombre1(), docentes.get(i).getApellido1(), String.valueOf(docentes.get(i).getCreditos())};
            md.addRow(arr);
        }
    }

    public void actualizarTablaCoincidencias(ArrayList<DocenteVo> docentes) {

        md = new DefaultTableModel(data, cabeza) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabla.setModel(md);
        for (int i = 0; i < docentes.size(); i++) {
            String arr[] = {docentes.get(i).getCedula(), docentes.get(i).getNombre1(), docentes.get(i).getApellido1(), String.valueOf(docentes.get(i).getCreditos())};
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INGRESO DE DOCENTES");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1380, -1));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 270, -1));

        txtNombres.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 270, -1));

        txtCreditos.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        txtCreditos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCreditosKeyTyped(evt);
            }
        });
        add(txtCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 70, -1));

        btnLimpiar.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 110, 30));

        btnGuardar.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 420, 110, 30));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 770, 130));

        lblReloj.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("RELOJ");
        add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 360, -1));

        txtApellidos.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 270, -1));

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

        jLabel11.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Nombres:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 240, -1));

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Apellidos:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 240, -1));

        jLabel13.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Fecha de Nacimiento:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 240, -1));

        jLabel14.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Teléfono:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 240, -1));

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("e-mail:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 240, -1));

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Carga Horaria:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 240, -1));

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
        add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));
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
                    if (!coordinador.existeDocente(txtCedula.getText())) {
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
                        Date date = fecha.getDate();
                        String telefono = txtTelefono.getText();
                        String mail = txtEmail.getText();
                        int creditos = Integer.parseInt(txtCreditos.getText());
                        int creditos1 = Integer.parseInt(txtCreditos.getText());
                        File fichero = new File("foto.jpg");
                        DocenteVo docente = new DocenteVo(cedula, nombres[0].toUpperCase(), nombres[1].toUpperCase(), apellidos[0].toUpperCase(), apellidos[1].toUpperCase(), telefono, mail, pass, creditos, creditos1, date, fichero);
                        coordinador.ingresarDocente(docente);
                        limpiar();
                        actualizarTabla();
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "El docente ya se encuentra registrado en el sistema.", "Error de Registro", JOptionPane.WARNING_MESSAGE);
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
                if (!coordinador.existeDocente(txtCedula.getText())) {
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
                    Date date = fecha.getDate();
                    String telefono = txtTelefono.getText();
                    String mail = txtEmail.getText();
                    int creditos = Integer.parseInt(txtCreditos.getText());
                    int creditos1 = Integer.parseInt(txtCreditos.getText());
                    File fichero = new File("foto.jpg");
                    DocenteVo docente = new DocenteVo(cedula, nombres[0].toUpperCase(), nombres[1].toUpperCase(), apellidos[0].toUpperCase(), apellidos[1].toUpperCase(), telefono, mail, pass, creditos, creditos1, date, fichero);
                    coordinador.ingresarDocente(docente);
                    limpiar();
                    actualizarTabla();
                    return;
                }
                JOptionPane.showMessageDialog(null, "El docente ya se encuentra registrado en el sistema.", "Error de Registro", JOptionPane.WARNING_MESSAGE);
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
        ArrayList<DocenteVo> docente = new ArrayList<DocenteVo>();
        docente = coordinador.docentesCoincidencia(valor);
        actualizarTablaCoincidencias(docente);
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int fila = tabla.rowAtPoint(evt.getPoint());
        if (fila > -1) {
            txtCedula.setText(String.valueOf(tabla.getValueAt(fila, 0)));
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tablaMouseClicked

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboTipo;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
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
