/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Docente;

import Controlador.Conexion;
import Modelo.Estudiante.EstudianteVo;
import Modelo.Materia.MateriaDao;
import Vista.Curso.asistenciaDocente;
import com.mysql.jdbc.CallableStatement;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class DocenteDao {

    public void ingresarDocente(DocenteVo docente) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall(
                    "{call agregarDocente(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("cedula", docente.getCedula());
            cs.setString("n1", docente.getNombre1());
            cs.setString("n2", docente.getNombre2());
            cs.setString("a1", docente.getApellido1());
            cs.setString("a2", docente.getApellido2());
            cs.setInt("creditos", docente.getCreditos());
            java.sql.Date date = new java.sql.Date(
                    docente.getFecha().getTime());
            cs.setDate("fecha", date);
            cs.setString("telefono", docente.getTelefono());
            cs.setString("mail", docente.getMail());
            cs.setString("pass", docente.getPass());
            cs.setInt("disponible", docente.getCreditosDisponibles());
            FileInputStream fis = new FileInputStream(docente.getFoto());
            cs.setBinaryStream("foto", fis, (int) docente.getFoto().length());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "El docente se ha "
                    + "registrado correctamente.", "Ingreso de Docentes",
                    JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DocenteDao.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void editarDocente(DocenteVo docente) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall(
                    "{call editarDocente(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("cedula", docente.getCedula());
            cs.setString("n1", docente.getNombre1());
            cs.setString("n2", docente.getNombre2());
            cs.setString("a1", docente.getApellido1());
            cs.setString("a2", docente.getApellido2());
            cs.setString("pass", docente.getPass());
            cs.setInt("creditos", docente.getCreditos());
            java.sql.Date date = new java.sql.Date(
                    docente.getFecha().getTime());
            cs.setDate("fecha", date);
            cs.setString("telefono", docente.getTelefono());
            cs.setString("mail", docente.getMail());
            FileInputStream fis = new FileInputStream(docente.getFoto());
            cs.setBinaryStream("foto", fis, (int) docente.getFoto().length());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "El docente se ha editado "
                    + "correctamente.", "Edicion de Docentes",
                    JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DocenteDao.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void eliminarDocente(String cedula) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall(
                    "{call eliminarDocente(?)}");
            cs.setString("cedula", cedula);
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "El docente se ha eliminado"
                    + " correctamente.", "Eliminacion de Docentes",
                    JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public void asistenciaDocente(asistenciaDocente asistencia) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall(
                    "{call docenteAsistencia(?,?,?,?,?)}");
            java.sql.Date date = new java.sql.Date(
                    asistencia.getFecha().getTime());
            cs.setDate("fecha", date);
            cs.setInt("codigo", asistencia.getCodigo());
            cs.setString("cedula", asistencia.getCedula());
            cs.setString("entrada", asistencia.getEntrada());
            cs.setString("salida", asistencia.getSalida());
            cs.executeUpdate();
            
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public ArrayList<asistenciaDocente> reporteAsistencia(int codigo) {
        ArrayList<asistenciaDocente> asistencia = 
                new ArrayList<asistenciaDocente>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            String Query = "SELECT * FROM asistenciadocente WHERE CODIGOCURSO="
                    + codigo;
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                asistenciaDocente a = new asistenciaDocente();
                a.setCedula(resultSet.getString("CEDULADOCENTE"));
                a.setCodigo(resultSet.getInt("CODIGOCURSO"));
                a.setEntrada(resultSet.getString("ENTRADAASISTENCIAD"));
                a.setSalida(resultSet.getString("SALIDAASISTENCIAD"));
                java.util.Date date = new java.util.Date(resultSet.getDate(
                        "FECHAASISTENCIAD").getTime());
                a.setFecha(date);
                asistencia.add(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Error en la adquisición de datos");
        }
        conexion.closeConnection();
        return asistencia;
    }

    public ArrayList<DocenteVo> docentesRegistrados() {
        ArrayList<DocenteVo> docentes = new ArrayList<DocenteVo>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            String Query = "SELECT CEDULADOCENTE, NOMBRE1DOCENTE, "
                    + "NOMBRE2DOCENTE, APELLIDO1DOCENTE, APELLIDO2DOCENTE, "
                    + "TELEFONODOCENTE, CREDITOSDOCENTE, "
                    + "AES_DECRYPT(PASSDOCENTE,'base_nelson') as PASS, MAILDOCENTE, "
                    + "CREDITOSDISPDOCENTE, FOTODOCENTE, FECHADOCENTE "
                    + "FROM docente";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                DocenteVo docente = new DocenteVo();
                docente.setCedula(resultSet.getString("CEDULADOCENTE"));
                docente.setNombre1(resultSet.getString("NOMBRE1DOCENTE"));
                docente.setNombre2(resultSet.getString("NOMBRE2DOCENTE"));
                docente.setApellido1(resultSet.getString("APELLIDO1DOCENTE"));
                docente.setApellido2(resultSet.getString("APELLIDO2DOCENTE"));
                docente.setTelefono(resultSet.getString("TELEFONODOCENTE"));
                docente.setCreditos(resultSet.getInt("CREDITOSDOCENTE"));
                docente.setPass(resultSet.getString("PASS"));
                docente.setMail(resultSet.getString("MAILDOCENTE"));
                docente.setCreditosDisponibles(resultSet.getInt(
                        "CREDITOSDISPDOCENTE"));
                java.util.Date date = new java.util.Date(resultSet.getDate(
                        "FECHADOCENTE").getTime());
                docente.setFecha(date);
                docentes.add(docente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Error en la adquisición de datos");
        }
        conexion.closeConnection();
        return docentes;
    }

    public ArrayList<DocenteVo> docentesCoincidencia(String cedula) {
        ArrayList<DocenteVo> docentes = new ArrayList<DocenteVo>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            String Query = "SELECT CEDULADOCENTE, NOMBRE1DOCENTE, "
                    + "NOMBRE2DOCENTE, APELLIDO1DOCENTE, APELLIDO2DOCENTE,"
                    + "TELEFONODOCENTE, CREDITOSDOCENTE,"
                    + "AES_DECRYPT(PASSDOCENTE,'base_nelson') as PASS, MAILDOCENTE, "
                    + "CREDITOSDISPDOCENTE, FOTODOCENTE, FECHADOCENTE FROM "
                    + "docente WHERE CEDULADOCENTE LIKE " + "'" + cedula + "%'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                DocenteVo docente = new DocenteVo();
                docente.setCedula(resultSet.getString("CEDULADOCENTE"));
                docente.setNombre1(resultSet.getString("NOMBRE1DOCENTE"));
                docente.setNombre2(resultSet.getString("NOMBRE2DOCENTE"));
                docente.setApellido1(resultSet.getString("APELLIDO1DOCENTE"));
                docente.setApellido2(resultSet.getString("APELLIDO2DOCENTE"));
                docente.setTelefono(resultSet.getString("TELEFONODOCENTE"));
                docente.setCreditos(resultSet.getInt("CREDITOSDOCENTE"));
                docente.setPass(resultSet.getString("PASS"));
                docente.setMail(resultSet.getString("MAILDOCENTE"));
                docente.setCreditosDisponibles(resultSet.getInt(
                        "CREDITOSDISPDOCENTE"));
                java.util.Date date = new java.util.Date(resultSet.getDate(
                        "FECHADOCENTE").getTime());
                docente.setFecha(date);
                docentes.add(docente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Error en la adquisición de datos");
        }
        conexion.closeConnection();
        return docentes;
    }

    public DocenteVo buscarDocente(String cedula) throws IOException {
        DocenteVo docente = new DocenteVo();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            
            String Query = "SELECT CEDULADOCENTE, NOMBRE1DOCENTE, "
                    + "NOMBRE2DOCENTE, APELLIDO1DOCENTE, APELLIDO2DOCENTE, "
                    + "TELEFONODOCENTE, CREDITOSDOCENTE, "
                    + "AES_DECRYPT(PASSDOCENTE,'base_nelson') as PASS, MAILDOCENTE,"
                    + "CREDITOSDISPDOCENTE, FOTODOCENTE, FECHADOCENTE "
                    + "FROM docente WHERE CEDULADOCENTE=" + "'" + cedula + "'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                docente.setCedula(resultSet.getString("CEDULADOCENTE"));
                docente.setNombre1(resultSet.getString("NOMBRE1DOCENTE"));
                docente.setNombre2(resultSet.getString("NOMBRE2DOCENTE"));
                docente.setApellido1(resultSet.getString("APELLIDO1DOCENTE"));
                docente.setApellido2(resultSet.getString("APELLIDO2DOCENTE"));
                docente.setTelefono(resultSet.getString("TELEFONODOCENTE"));
                docente.setCreditos(resultSet.getInt("CREDITOSDOCENTE"));
                docente.setPass(resultSet.getString("PASS"));
                docente.setMail(resultSet.getString("MAILDOCENTE"));
                docente.setCreditosDisponibles(resultSet.getInt(
                        "CREDITOSDISPDOCENTE"));
                Blob blob = resultSet.getBlob("FOTODOCENTE");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                img = ImageIO.read(new ByteArrayInputStream(data));
                BufferedImage bi = img;
                File outputfile = new File("temporal.png");
                if (img == null) {
                    File fichero = new File("foto.png");
                    docente.setFoto(fichero);
                } else {
                    ImageIO.write(bi, "png", outputfile);
                }
                docente.setFoto(outputfile);
                docente.setFoto1(img);
                java.util.Date date = new java.util.Date(resultSet.getDate(
                        "FECHADOCENTE").getTime());
                docente.setFecha(date);
                return docente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        JOptionPane.showMessageDialog(null,
                "No se han encontrado coincidencias");
        return null;
    }

    public DocenteVo buscarDocenteRecuperar(String cedula, String mail) 
            throws IOException {
        DocenteVo docente = new DocenteVo();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT CEDULADOCENTE, NOMBRE1DOCENTE, "
                    + "NOMBRE2DOCENTE, APELLIDO1DOCENTE, APELLIDO2DOCENTE, "
                    + "TELEFONODOCENTE, CREDITOSDOCENTE, "
                    + "AES_DECRYPT(PASSDOCENTE,'base_nelson') as PASS, MAILDOCENTE, "
                    + "CREDITOSDISPDOCENTE, FOTODOCENTE, FECHADOCENTE "
                    + "FROM docente WHERE CEDULADOCENTE=" + "'" + cedula + 
                    "' and MAILDOCENTE=" + "'" + mail + "'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                docente.setCedula(resultSet.getString("CEDULADOCENTE"));
                docente.setNombre1(resultSet.getString("NOMBRE1DOCENTE"));
                docente.setNombre2(resultSet.getString("NOMBRE2DOCENTE"));
                docente.setApellido1(resultSet.getString("APELLIDO1DOCENTE"));
                docente.setApellido2(resultSet.getString("APELLIDO2DOCENTE"));
                docente.setTelefono(resultSet.getString("TELEFONODOCENTE"));
                docente.setCreditos(resultSet.getInt("CREDITOSDOCENTE"));
                docente.setPass(resultSet.getString("PASS"));
                docente.setMail(resultSet.getString("MAILDOCENTE"));
                docente.setCreditosDisponibles(resultSet.getInt(
                        "CREDITOSDISPDOCENTE"));
                Blob blob = resultSet.getBlob("FOTODOCENTE");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                img = ImageIO.read(new ByteArrayInputStream(data));
                BufferedImage bi = img;
                File outputfile = new File("temporal.png");
                if (img == null) {
                    File fichero = new File("foto.png");
                    docente.setFoto(fichero);
                } else {
                    ImageIO.write(bi, "png", outputfile);
                }
                docente.setFoto(outputfile);
                docente.setFoto1(img);
                java.util.Date date = new java.util.Date(resultSet.getDate(
                        "FECHADOCENTE").getTime());
                docente.setFecha(date);
                return docente;
            }
        } catch (SQLException ex) {
           
        }
        return null;
    }

    public boolean existeDocente(String cedula) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT * FROM docente WHERE CEDULADOCENTE=" + 
                    "'" + cedula + "'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Error en la adquisición de datos");
           
        }
        System.out.println("asas");
        return false;
    }

    public ArrayList<DocenteVo> docentesCoincidenciaMateria(String tipo,
            String valor) {
        ArrayList<DocenteVo> docentes = new ArrayList<DocenteVo>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            String Query = "SELECT M.NOMBREMATERIA, C.CEDULADOCENTE, "
                    + "C.NOMBRE1DOCENTE, C.NOMBRE2DOCENTE, C.APELLIDO1DOCENTE,"
                    + " C.APELLIDO2DOCENTE, C.TELEFONODOCENTE,"
                    + " C.CREDITOSDOCENTE, AES_DECRYPT(C.PASSDOCENTE,'base_nelson')"
                    + " as PASS, C.MAILDOCENTE, C.CREDITOSDISPDOCENTE, "
                    + "C.FOTODOCENTE, C.FECHADOCENTE FROM docente C "
                    + "INNER JOIN curso O ON C.CEDULADOCENTE = "
                    + "O.CEDULADOCENTE INNER JOIN materia M on"
                    + " M.CODIGOMATERIA=O.CODIGOMATERIA WHERE "
                    + "O.CODIGOMATERIA IN (SELECT CODIGOMATERIA"
                    + "FROM materia WHERE " + tipo + " LIKE '" + valor + "%')";

            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                DocenteVo docente = new DocenteVo();
                docente.setCedula(resultSet.getString("CEDULADOCENTE"));
                docente.setNombre1(resultSet.getString("NOMBRE1DOCENTE"));
                docente.setNombre2(resultSet.getString("NOMBRE2DOCENTE"));
                docente.setApellido1(resultSet.getString("APELLIDO1DOCENTE"));
                docente.setApellido2(resultSet.getString("APELLIDO2DOCENTE"));
                docente.setTelefono(resultSet.getString("TELEFONODOCENTE"));
                docente.setCreditos(resultSet.getInt("CREDITOSDOCENTE"));
                docente.setPass(resultSet.getString("PASS"));
                docente.setMail(resultSet.getString("MAILDOCENTE"));
                docente.setMateria(resultSet.getString("NOMBREMATERIA"));
                docente.setCreditosDisponibles(resultSet.getInt(
                        "CREDITOSDISPDOCENTE"));
                java.util.Date date = new java.util.Date(resultSet.getDate(
                        "FECHADOCENTE").getTime());
                docente.setFecha(date);
                docentes.add(docente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        conexion.closeConnection();
        return docentes;
    }

}
