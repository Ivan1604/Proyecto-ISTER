/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Reporte;

import Vista.Materias.*;
import Controlador.Coordinador;
import Modelo.Docente.DocenteVo;
import Modelo.Materia.MateriaVo;
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

public class MateriaReporte extends javax.swing.JPanel {

    /**
     * Creates new form ini
     */
    Coordinador coordinador;
    ArrayList<MateriaVo> materias1 = new ArrayList<MateriaVo>();
    String seleccion = "CARRERAMATERIA";
    DefaultTableModel md1;
    String reporte = "CARRERA";
    String data1[][] = {};
    String cabeza1[] = {"Codigo", "Nombre", "Tipo", "Creditos", "Carrera", "Nivel"};

    public MateriaReporte(Coordinador coord) {
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
        comboBusqueda = new javax.swing.JComboBox<>();
        btnGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtContenido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REPORTES DE MATERIAS");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1380, -1));

        comboBusqueda.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        comboBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carrera", "Area", "Nivel" }));
        comboBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBusquedaActionPerformed(evt);
            }
        });
        add(comboBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 160, 20));

        btnGenerar.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        btnGenerar.setText("Generar Reporte");
        btnGenerar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 130, 30));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Tipo", "Créditos", "Carrera", "Nivel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 1350, 400));

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

        jLabel11.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Búsqueda por:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 240, 40));

        txtContenido.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        txtContenido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContenidoKeyReleased(evt);
            }
        });
        add(txtContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 280, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinBase.png"))); // NOI18N
        jLabel1.setText(".");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoSinFonfoRumi.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 130, -1, 180));
    }// </editor-fold>//GEN-END:initComponents

    public void actualizarTabla() {

    }

    public void limpiar() {
        md1 = new DefaultTableModel(data1, cabeza1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabla.setModel(md1);
        comboBusqueda.setSelectedIndex(0);
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

        FileOutputStream salida = new FileOutputStream("Reportes/ReporteMaterias_" + hourdateFormat.format(date) + ".pdf");
        PdfWriter writer = PdfWriter.getInstance(document, salida);
        writer.setInitialLeading(0);
        PdfPTable table = new PdfPTable(6);
        table.addCell("Codigo");
        table.addCell("Nombre");
        table.addCell("Tipo");
        table.addCell("Creditos");
        table.addCell("Carrera");
        table.addCell("Nivel");

        for (int i = 0; i < materias1.size(); i++) {
            Paragraph columna1 = new Paragraph(materias1.get(i).getCodigo());
            columna1.getFont().setSize(7);
            table.addCell(columna1);

            Paragraph columna2 = new Paragraph(materias1.get(i).getNombre());
            columna2.getFont().setSize(7);
            table.addCell(columna2);

            Paragraph columna3 = new Paragraph(materias1.get(i).getTipo());
            columna3.getFont().setSize(7);
            table.addCell(columna3);

            Paragraph columna4 = new Paragraph(String.valueOf(materias1.get(i).getCreditos()));
            columna4.getFont().setSize(7);
            table.addCell(columna4);

            Paragraph columna5 = new Paragraph(materias1.get(i).getCarrera());
            columna5.getFont().setSize(7);
            table.addCell(columna5);

            Paragraph columna6 = new Paragraph(String.valueOf(materias1.get(i).getNivel()));
            columna6.getFont().setSize(7);
            table.addCell(columna6);

        }
        document.open();
        Paragraph paragraph = new Paragraph();
        paragraph.add("\nREPORTE DE MATERIAS POR " + reporte + "\n\n");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        date = new Date();
        hourdateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        Paragraph paragraph1 = new Paragraph();
        paragraph1.add("\n\nREPORTE GENERADO:  " + hourdateFormat.format(date));
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(imagen);
        document.add(paragraph);
        document.add(table);
        document.add(paragraph1);
        document.close();
        try {
            File path = new File("Reportes/ReporteMaterias_" + hourdateFormat3.format(date3) + ".pdf");
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
            Logger.getLogger(MateriaReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(MateriaReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MateriaReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void comboBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBusquedaActionPerformed
        if (comboBusqueda.getSelectedItem().equals("Carrera")) {
            seleccion = "CARRERAMATERIA";
            reporte = "CARRERA";
            return;
        }
        if (comboBusqueda.getSelectedItem().equals("Area")) {
            seleccion = "TIPOMATERIA";
            reporte = "AREA";
            return;
        }
        if (comboBusqueda.getSelectedItem().equals("Nivel")) {
            seleccion = "NIVELMATERIA";
            reporte = "NIVEL";
        }
    }//GEN-LAST:event_comboBusquedaActionPerformed

    public void actualizarTablaCoincidenciasMaterias(ArrayList<MateriaVo> materias) {
        md1 = new DefaultTableModel(data1, cabeza1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabla.setModel(md1);
        for (int i = 0; i < materias.size(); i++) {
            String arr[] = {materias.get(i).getCodigo(), materias.get(i).getNombre(), materias.get(i).getTipo(), String.valueOf(materias.get(i).getCreditos()), materias.get(i).getCarrera(), String.valueOf(materias.get(i).getNivel())};
            md1.addRow(arr);
        }
    }

    public void cargaTabla() {
        materias1 = coordinador.materiasRegistradas();
        actualizarTablaCoincidenciasMaterias(materias1);
    }


    private void txtContenidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContenidoKeyReleased
        String valor = txtContenido.getText().toUpperCase();
        materias1 = new ArrayList<MateriaVo>();
        materias1 = coordinador.buscarMaterias(seleccion, valor);
        actualizarTablaCoincidenciasMaterias(materias1);

    }//GEN-LAST:event_txtContenidoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> comboBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblReloj;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtContenido;
    // End of variables declaration//GEN-END:variables
}
