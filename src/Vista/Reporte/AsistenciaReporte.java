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
import Modelo.Materia.MateriaVo;
import Modelo.Tema.TemaVo;
import Vista.Curso.VerCurso;
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
import javax.swing.JPanel;

public class AsistenciaReporte extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;
    DefaultTableModel md1;
    String curso = "";
    String doc = "";
    String data1[][] = {};
    String cabeza1[] = {"Fecha", "Curso", "Entrada", "Salida"};
    ArrayList<asistenciaDocente> asistencia = new ArrayList<>();

    public AsistenciaReporte(Coordinador coord) {
        initComponents();
        lblDocente.setVisible(false);
        btnGenerar.setVisible(false);
        lblEtiquetaDocente.setVisible(false);
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
        lblDocente = new javax.swing.JLabel();
        txtContenido = new javax.swing.JTextField();
        lblEtiquetaDocente = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REPORTES DE ASISTENCIA DOCENTE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1380, -1));

        btnGenerar.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        btnGenerar.setText("Generar Reporte");
        btnGenerar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 120, 30));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Curso", "Entrada", "Salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 1350, 250));

        lblReloj.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("RELOJ");
        add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 360, -1));

        lblDocente.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        lblDocente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDocente.setText("Docente:");
        add(lblDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 470, 20));

        txtContenido.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        txtContenido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContenidoKeyReleased(evt);
            }
        });
        add(txtContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 150, 20));

        lblEtiquetaDocente.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        lblEtiquetaDocente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEtiquetaDocente.setText("Docente:");
        add(lblEtiquetaDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 110, 20));

        btnBuscar.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinBase.png"))); // NOI18N
        jLabel1.setText(".");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinFonfoRumi.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, -1, 180));

        jLabel13.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Ingrese el Curso:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 110, 20));
    }// </editor-fold>//GEN-END:initComponents

    public void limpiar() {
        md1 = new DefaultTableModel(data1, cabeza1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabla.setModel(md1);
        lblDocente.setText("");
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

        FileOutputStream salida = new FileOutputStream("Reportes/ReporteAsistenciaDocente_" + hourdateFormat.format(date) + ".pdf");
        PdfWriter writer = PdfWriter.getInstance(document, salida);
        writer.setInitialLeading(0);
        PdfPTable table = new PdfPTable(4);
        Paragraph columna = new Paragraph("Fecha");
        columna.getFont().setSize(10);
        table.addCell(columna);
        columna = new Paragraph("Curso");
        columna.getFont().setSize(10);
        table.addCell(columna);
        columna = new Paragraph("Entrada");
        columna.getFont().setSize(10);
        table.addCell(columna);
        columna = new Paragraph("Salida");
        columna.getFont().setSize(10);
        table.addCell(columna);

        for (int i = 0; i < asistencia.size(); i++) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Paragraph columna1 = new Paragraph(dateFormat.format(asistencia.get(i).getFecha()));
            columna1.getFont().setSize(7);
            table.addCell(columna1);

            Paragraph columna2 = new Paragraph(String.valueOf(asistencia.get(i).getCodigo()));
            columna2.getFont().setSize(7);
            table.addCell(columna2);

            Paragraph columna3 = new Paragraph(asistencia.get(i).getEntrada());
            columna3.getFont().setSize(7);
            table.addCell(columna3);

            Paragraph columna4 = new Paragraph(asistencia.get(i).getSalida());
            columna4.getFont().setSize(7);
            table.addCell(columna4);

        }
        document.open();
        Paragraph paragraph = new Paragraph();
        paragraph.add("\nREPORTE DE ASISTENCIA \nCurso: " + curso + "\n Docente: " + doc + "\n\n");
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
            File path = new File("Reportes/ReporteAsistenciaDocente_" + hourdateFormat3.format(date3) + ".pdf");
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
            Logger.getLogger(AsistenciaReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(AsistenciaReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AsistenciaReporte.class.getName()).log(Level.SEVERE, null, ex);
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
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String arr[] = {dateFormat.format(asistencia.get(i).getFecha()), String.valueOf(asistencia.get(i).getCodigo()), asistencia.get(i).getEntrada(), asistencia.get(i).getSalida()};
            md1.addRow(arr);
        }
    }

    private void txtContenidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContenidoKeyReleased

    }//GEN-LAST:event_txtContenidoKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

       
        try {
            
        
        CursoVo c = coordinador.buscarCurso(Integer.valueOf(txtContenido.getText()));
        if (c != null) {
            try {
                asistencia = coordinador.reporteAsistencia(Integer.valueOf(txtContenido.getText()));
                DocenteVo docente = coordinador.buscarDocente(c.getDocente());
                doc = docente.getNombre1() + " " + docente.getApellido1();
                actualizarTabla();
                lblDocente.setText(""+doc);
                curso = txtContenido.getText();
                
            lblDocente.setVisible(true);
            btnGenerar.setVisible(true);
            lblEtiquetaDocente.setVisible(true);
            
            } catch (IOException ex) {
                Logger.getLogger(AsistenciaReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El curso no se encuentra registrado en el sistema");
        }
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ingrese el número del curso");
        }

    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDocente;
    private javax.swing.JLabel lblEtiquetaDocente;
    public javax.swing.JLabel lblReloj;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtContenido;
    // End of variables declaration//GEN-END:variables
}