/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Reporte;

import Vista.Materias.*;
import Controlador.Coordinador;
import Modelo.Curso.CursoVo;
import Modelo.Docente.DocenteVo;
import Modelo.Estudiante.EstudianteVo;
import Modelo.Materia.MateriaVo;
import Modelo.Tema.TemaVo;
import Vista.Curso.asistenciaDocente;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import java.awt.Desktop;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class AsistenciaReporteEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;
    DefaultTableModel md1;
    String curso = "";
    String fecha1 = "";
    String data1[][] = {};
    String cabeza1[] = {"Cedula", "Nombres", "Apellidos"};
    ArrayList<EstudianteVo> asistencia = new ArrayList<EstudianteVo>();

    public AsistenciaReporteEstudiante(Coordinador coord) {
        initComponents();
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
        btnGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblReloj = new javax.swing.JLabel();
        txtContenido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REPORTES DE ASISTENCIA ESTUDIANTE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1380, -1));

        btnGenerar.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        btnGenerar.setText("Generar Reporte");
        btnGenerar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 160, 30));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cédula", "Nombres", "Apellidos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 1350, 260));

        lblReloj.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("RELOJ");
        add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 360, -1));

        txtContenido.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        txtContenido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContenidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContenidoKeyTyped(evt);
            }
        });
        add(txtContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 190, 20));

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Curso:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 110, 20));

        btnBuscar.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 120, 30));

        jLabel13.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Fecha:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 120, 20));

        fecha.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 190, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinBase.png"))); // NOI18N
        jLabel1.setText(".");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinFonfoRumi.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, -1, 180));
    }// </editor-fold>//GEN-END:initComponents

    public void limpiar() {
        md1 = new DefaultTableModel(data1, cabeza1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabla.setModel(md1);
        txtContenido.setText("");
    }

    public void GenerarPdf() throws FileNotFoundException, DocumentException, BadElementException, IOException {
        Date date = new Date();
        Date date3 = date;
        DateFormat hourdateFormat3 = new SimpleDateFormat("HH-mm_dd-MM-yyyy");
        DateFormat hourdateFormat = new SimpleDateFormat("HH-mm_dd-MM-yyyy");
        Document document = new Document(PageSize.A4, 30, 20, 20, 20);
        Image imagen = Image.getInstance("Logo1.png");
        imagen.scalePercent(35f);
        imagen.setAlignment(Image.MIDDLE);

        FileOutputStream salida = new FileOutputStream("Reportes/ReporteAsistenciaEstudiante_" + hourdateFormat.format(date) + ".pdf");
        PdfWriter writer = PdfWriter.getInstance(document, salida);
        writer.setInitialLeading(0);
        PdfPTable table = new PdfPTable(3);
        Paragraph columna = new Paragraph("Cedula");
        columna.getFont().setSize(10);
        table.addCell(columna);
        columna = new Paragraph("Nombres");
        columna.getFont().setSize(10);
        table.addCell(columna);
        columna = new Paragraph("Apellidos");
        columna.getFont().setSize(10);
        table.addCell(columna);

        for (int i = 0; i < asistencia.size(); i++) {
            Paragraph columna1 = new Paragraph(asistencia.get(i).getCedula());
            columna1.getFont().setSize(7);
            table.addCell(columna1);

            Paragraph columna2 = new Paragraph(asistencia.get(i).getNombre1() + " " + asistencia.get(i).getNombre2());
            columna2.getFont().setSize(7);
            table.addCell(columna2);

            Paragraph columna3 = new Paragraph(asistencia.get(i).getApellido1() + " " + asistencia.get(i).getApellido2());
            columna3.getFont().setSize(7);
            table.addCell(columna3);

        }
        document.open();
        Paragraph paragraph = new Paragraph();
        paragraph.add("\nREPORTE DE ASISTENCIA ESTUDIANTIL \nCurso: " + curso + "\n Fecha: " + fecha1 + "\n\n");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        date = new Date();
        hourdateFormat = new SimpleDateFormat("HH:mm yyyy-MM-dd");
        Paragraph paragraph1 = new Paragraph();
        paragraph1.add("\n\nREPORTE GENERADO:  " + hourdateFormat.format(date));
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(imagen);
        document.add(paragraph);
        document.add(table);
        document.add(paragraph1);
        document.close();
        try {
            File path = new File("Reportes/ReporteAsistenciaEstudiante_" + hourdateFormat3.format(date3) + ".pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        try {
            GenerarPdf();
            JOptionPane.showMessageDialog(null, "Se ha generado el reporte exitosamente!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AsistenciaReporteEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(AsistenciaReporteEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AsistenciaReporteEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    public void actualizarTabla() {
        md1 = new DefaultTableModel(data1, cabeza1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabla.setModel(md1);
        for (int i = 0; i < asistencia.size(); i++) {
            String arr[] = {asistencia.get(i).getCedula(), asistencia.get(i).getNombre1() + " " + asistencia.get(i).getNombre2(), asistencia.get(i).getApellido1() + " " + asistencia.get(i).getApellido2()};
            md1.addRow(arr);
        }
    }

    private void txtContenidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContenidoKeyReleased

    }//GEN-LAST:event_txtContenidoKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            CursoVo c = coordinador.buscarCurso(Integer.valueOf(txtContenido.getText()));
            if (c != null) {
                Date date = fecha.getDate();
                curso = String.valueOf(c.getCodigo());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                fecha1 = dateFormat.format(date);
                asistencia = coordinador.EstudiantesAsistencia(txtContenido.getText(), dateFormat.format(date));
                actualizarTabla();
                if (asistencia.size() == 0) {
                    JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias.");
                }
            } else {
                //JOptionPane.showMessageDialog(null, "El curso no se encuentra registrado en el sistema");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese el número del curso a consultar");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtContenidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContenidoKeyTyped
        coordinador.logica.validaNumero(evt);
    }//GEN-LAST:event_txtContenidoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGenerar;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblReloj;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtContenido;
    // End of variables declaration//GEN-END:variables
}