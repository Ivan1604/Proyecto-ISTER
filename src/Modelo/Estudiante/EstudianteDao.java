/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Estudiante;

import Controlador.Conexion;
import Modelo.Materia.MateriaDao;
import Modelo.Materia.MateriaVo;
import com.mysql.jdbc.CallableStatement;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class EstudianteDao {

    public void ingresarEstudiante(EstudianteVo estudiante) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call agregarEstudiante(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("cedula", estudiante.getCedula());
            cs.setString("n1", estudiante.getNombre1());
            cs.setString("n2", estudiante.getNombre2());
            cs.setString("a1", estudiante.getApellido1());
            cs.setString("a2", estudiante.getApellido2());
            cs.setInt("creditos", estudiante.getCreditos());
            java.sql.Date date = new java.sql.Date(estudiante.getFecha().getTime());
            cs.setDate("fecha", date);
            cs.setString("telefono", estudiante.getTelefono());
            cs.setString("mail", estudiante.getMail());
            cs.setString("carrera", estudiante.getCarrera());
            cs.setString("pass", estudiante.getPass());
            cs.setInt("disponible", estudiante.getCreditosDisponibles());
            FileInputStream fis = new FileInputStream(estudiante.getFoto());
            cs.setBinaryStream("foto", fis, (int) estudiante.getFoto().length());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "El estudiante se ha registrado correctamente.", "Ingreso de Estudiantes", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarEstudiante(EstudianteVo estudiante) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call editarEstudiante(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("cedula", estudiante.getCedula());
            cs.setString("n1", estudiante.getNombre1());
            cs.setString("n2", estudiante.getNombre2());
            cs.setString("a1", estudiante.getApellido1());
            cs.setString("a2", estudiante.getApellido2());
            cs.setInt("creditos", estudiante.getCreditos());
            java.sql.Date date = new java.sql.Date(estudiante.getFecha().getTime());
            cs.setDate("fecha", date);
            cs.setString("telefono", estudiante.getTelefono());
            cs.setString("mail", estudiante.getMail());
            cs.setString("carrera", estudiante.getCarrera());
            cs.setString("pass", estudiante.getPass());
            FileInputStream fis = new FileInputStream(estudiante.getFoto());
            cs.setBinaryStream("foto", fis, (int) estudiante.getFoto().length());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "El estudiante se ha editado correctamente.", "Edicion de Estudiantes", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEstudiante(String cedula) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call eliminarEstudiante(?)}");
            cs.setString("cedula", cedula);
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "El estudiante se ha eliminado correctamente.", "Eliminacion de Estudiantes", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<EstudianteVo> estudiantesRegistrados() {
        ArrayList<EstudianteVo> estudiantes = new ArrayList<EstudianteVo>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            String Query = "SELECT CEDULAESTUDIANTE, NOMBRE1ESTUDIANTE, NOMBRE2ESTUDIANTE, APELLIDO1ESTUDIANTE, APELLIDO2ESTUDIANTE, CARRERAESTUDIANTE, TELEFONOESTUDIANTE, CREDITOSESTUDIANTE, AES_DECRYPT(PASSESTUDIANTE,'base_nelson') as PASS, MAILESTUDIANTE, CREDITOSDISPESTUDIANTE, FECHAESTUDIANTE FROM estudiante";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                EstudianteVo estudiante = new EstudianteVo();
                estudiante.setCedula(resultSet.getString("CEDULAESTUDIANTE"));
                estudiante.setNombre1(resultSet.getString("NOMBRE1ESTUDIANTE"));
                estudiante.setNombre2(resultSet.getString("NOMBRE2ESTUDIANTE"));
                estudiante.setApellido1(resultSet.getString("APELLIDO1ESTUDIANTE"));
                estudiante.setApellido2(resultSet.getString("APELLIDO2ESTUDIANTE"));
                estudiante.setCarrera(resultSet.getString("CARRERAESTUDIANTE"));
                estudiante.setTelefono(resultSet.getString("TELEFONOESTUDIANTE"));
                estudiante.setCreditos(resultSet.getInt("CREDITOSESTUDIANTE"));
                estudiante.setPass(resultSet.getString("PASS"));
                estudiante.setMail(resultSet.getString("MAILESTUDIANTE"));
                estudiante.setCreditosDisponibles(resultSet.getInt("CREDITOSDISPESTUDIANTE"));
                java.util.Date date = new java.util.Date(resultSet.getDate("FECHAESTUDIANTE").getTime());
                estudiante.setFecha(date);
                estudiantes.add(estudiante);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        conexion.closeConnection();
        return estudiantes;
    }

    public ArrayList<EstudianteVo> estudiantesCoincidencia(String cedula) {
        ArrayList<EstudianteVo> estudiantes = new ArrayList<EstudianteVo>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            String Query = "SELECT CEDULAESTUDIANTE, NOMBRE1ESTUDIANTE, NOMBRE2ESTUDIANTE, APELLIDO1ESTUDIANTE, APELLIDO2ESTUDIANTE, CARRERAESTUDIANTE, TELEFONOESTUDIANTE, CREDITOSESTUDIANTE, AES_DECRYPT(PASSESTUDIANTE,'base_nelson') as PASS, MAILESTUDIANTE, CREDITOSDISPESTUDIANTE, FECHAESTUDIANTE FROM estudiante WHERE CEDULAESTUDIANTE LIKE " + "'" + cedula + "%'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                EstudianteVo estudiante = new EstudianteVo();
                estudiante.setCedula(resultSet.getString("CEDULAESTUDIANTE"));
                estudiante.setNombre1(resultSet.getString("NOMBRE1ESTUDIANTE"));
                estudiante.setNombre2(resultSet.getString("NOMBRE2ESTUDIANTE"));
                estudiante.setApellido1(resultSet.getString("APELLIDO1ESTUDIANTE"));
                estudiante.setApellido2(resultSet.getString("APELLIDO2ESTUDIANTE"));
                estudiante.setCarrera(resultSet.getString("CARRERAESTUDIANTE"));
                estudiante.setTelefono(resultSet.getString("TELEFONOESTUDIANTE"));
                estudiante.setCreditos(resultSet.getInt("CREDITOSESTUDIANTE"));
                estudiante.setPass(resultSet.getString("PASS"));
                estudiante.setMail(resultSet.getString("MAILESTUDIANTE"));
                estudiante.setCreditosDisponibles(resultSet.getInt("CREDITOSDISPESTUDIANTE"));
                java.util.Date date = new java.util.Date(resultSet.getDate("FECHAESTUDIANTE").getTime());
                estudiante.setFecha(date);
                estudiantes.add(estudiante);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        conexion.closeConnection();
        return estudiantes;
    }

    public EstudianteVo buscarEstudiante(String cedula) {
        EstudianteVo estudiante = new EstudianteVo();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT CEDULAESTUDIANTE, NOMBRE1ESTUDIANTE, NOMBRE2ESTUDIANTE, APELLIDO1ESTUDIANTE, APELLIDO2ESTUDIANTE, CARRERAESTUDIANTE, TELEFONOESTUDIANTE, CREDITOSESTUDIANTE, AES_DECRYPT(PASSESTUDIANTE,'base_nelson') as PASS, MAILESTUDIANTE, CREDITOSDISPESTUDIANTE, FECHAESTUDIANTE,  FOTOESTUDIANTE FROM estudiante WHERE CEDULAESTUDIANTE=" + "'" + cedula + "'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                estudiante.setCedula(resultSet.getString("CEDULAESTUDIANTE"));
                estudiante.setNombre1(resultSet.getString("NOMBRE1ESTUDIANTE"));
                estudiante.setNombre2(resultSet.getString("NOMBRE2ESTUDIANTE"));
                estudiante.setApellido1(resultSet.getString("APELLIDO1ESTUDIANTE"));
                estudiante.setApellido2(resultSet.getString("APELLIDO2ESTUDIANTE"));
                estudiante.setCarrera(resultSet.getString("CARRERAESTUDIANTE"));
                estudiante.setTelefono(resultSet.getString("TELEFONOESTUDIANTE"));
                estudiante.setCreditos(resultSet.getInt("CREDITOSESTUDIANTE"));
                estudiante.setPass(resultSet.getString("PASS"));
                estudiante.setMail(resultSet.getString("MAILESTUDIANTE"));
                estudiante.setCreditosDisponibles(resultSet.getInt("CREDITOSDISPESTUDIANTE"));
                Blob blob = resultSet.getBlob("FOTOESTUDIANTE");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                img = ImageIO.read(new ByteArrayInputStream(data));
                BufferedImage bi = img;
                File outputfile = new File("temporal.png");
                if (img == null) {
                    File fichero = new File("foto.png");
                    estudiante.setFoto(fichero);
                } else {
                    ImageIO.write(bi, "png", outputfile);
                }

                estudiante.setFoto(outputfile);
                estudiante.setFoto1(img);

                java.util.Date date = new java.util.Date(resultSet.getDate("FECHAESTUDIANTE").getTime());
                estudiante.setFecha(date);
                return estudiante;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
        return null;
    }

        public EstudianteVo buscarEstudianteRecuperar(String cedula, String mail) {
        EstudianteVo estudiante = new EstudianteVo();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT CEDULAESTUDIANTE, NOMBRE1ESTUDIANTE, NOMBRE2ESTUDIANTE, APELLIDO1ESTUDIANTE, APELLIDO2ESTUDIANTE, CARRERAESTUDIANTE, TELEFONOESTUDIANTE, CREDITOSESTUDIANTE, AES_DECRYPT(PASSESTUDIANTE,'base_nelson') as PASS, MAILESTUDIANTE, CREDITOSDISPESTUDIANTE, FECHAESTUDIANTE,  FOTOESTUDIANTE FROM estudiante WHERE CEDULAESTUDIANTE=" + "'" + cedula + "' and MAILESTUDIANTE="+ "'" + mail + "'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                estudiante.setCedula(resultSet.getString("CEDULAESTUDIANTE"));
                estudiante.setNombre1(resultSet.getString("NOMBRE1ESTUDIANTE"));
                estudiante.setNombre2(resultSet.getString("NOMBRE2ESTUDIANTE"));
                estudiante.setApellido1(resultSet.getString("APELLIDO1ESTUDIANTE"));
                estudiante.setApellido2(resultSet.getString("APELLIDO2ESTUDIANTE"));
                estudiante.setCarrera(resultSet.getString("CARRERAESTUDIANTE"));
                estudiante.setTelefono(resultSet.getString("TELEFONOESTUDIANTE"));
                estudiante.setCreditos(resultSet.getInt("CREDITOSESTUDIANTE"));
                estudiante.setPass(resultSet.getString("PASS"));
                estudiante.setMail(resultSet.getString("MAILESTUDIANTE"));
                estudiante.setCreditosDisponibles(resultSet.getInt("CREDITOSDISPESTUDIANTE"));
                Blob blob = resultSet.getBlob("FOTOESTUDIANTE");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                img = ImageIO.read(new ByteArrayInputStream(data));
                BufferedImage bi = img;
                File outputfile = new File("temporal.png");
                if (img == null) {
                    File fichero = new File("foto.png");
                    estudiante.setFoto(fichero);
                } else {
                    ImageIO.write(bi, "png", outputfile);
                }

                estudiante.setFoto(outputfile);
                estudiante.setFoto1(img);

                java.util.Date date = new java.util.Date(resultSet.getDate("FECHAESTUDIANTE").getTime());
                estudiante.setFecha(date);
                return estudiante;
            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean existeEstudiante(String cedula) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT * FROM estudiante WHERE CEDULAESTUDIANTE=" + "'" + cedula + "'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean existeEstudianteMatriculado(String cedula, int codigo) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT * FROM estudiantemateria WHERE CEDULAESTUDIANTE=" + "'" + cedula + "' AND CODIGOCURSO=" + codigo;
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "El estudiante ya se encuentra registrado en esa materia.", "Matriculacion de Estudiantes", JOptionPane.WARNING_MESSAGE);
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void matriculaEstudiante(int codigo, String cedula) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call matricularEstudiante(?,?)}");
            cs.setString("cedula", cedula);
            cs.setInt("curso1", codigo);
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "El estudiante se ha inscrito en la materia " + codigo + " exitosamente.", "Matriculacion de Estudiantes", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
