/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Materia;

import Controlador.Conexion;
import com.mysql.jdbc.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class MateriaDao {

    public void ingresarMateria(MateriaVo materia) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call agregarMateria(?,?,?,?,?,?)}");
            cs.setString("codigo", materia.getCodigo());
            cs.setString("nombre", materia.getNombre());
            cs.setString("tipo", materia.getTipo());
            cs.setInt("creditos", materia.getCreditos());
            cs.setInt("nivel", materia.getNivel());
            cs.setString("carrera", materia.getCarrera());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "La materia se ha registrado correctamente.", "Ingreso de Materias", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarMateria(MateriaVo materia) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call editarMateria(?,?,?,?,?,?)}");
            cs.setString("codigo", materia.getCodigo());
            cs.setString("nombre", materia.getNombre());
            cs.setString("tipo", materia.getTipo());
            cs.setInt("creditos", materia.getCreditos());
            cs.setInt("nivel", materia.getNivel());
            cs.setString("carrera", materia.getCarrera());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "La materia se ha editado correctamente.", "Edicion de Materias", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarMateria(String codigo) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call eliminarMateria(?)}");
            cs.setString("codigo", codigo);
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "La materia se ha eliminado correctamente.", "Eliminacion de Materias", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<MateriaVo> materiasRegistradas() {
        ArrayList<MateriaVo> materias = new ArrayList<MateriaVo>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            String Query = "SELECT * FROM materia";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                MateriaVo materia = new MateriaVo();
                materia.setCodigo(resultSet.getString("CODIGOMATERIA"));
                materia.setNombre(resultSet.getString("NOMBREMATERIA"));
                materia.setTipo(resultSet.getString("TIPOMATERIA"));
                materia.setCreditos(resultSet.getInt("CREDITOSMATERIA"));
                materia.setNivel(resultSet.getInt("NIVELMATERIA"));
                materia.setCarrera(resultSet.getString("CARRERAMATERIA"));
                materias.add(materia);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        conexion.closeConnection();
        return materias;
    }

    public ArrayList<MateriaVo> buscarMateriasCoincidencias(String tipo, String valor) {
        ArrayList<MateriaVo> materias = new ArrayList<MateriaVo>();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT * FROM materia WHERE " + tipo + " LIKE " + "'" + valor + "%'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                MateriaVo materia = new MateriaVo();
                materia.setCodigo(resultSet.getString("CODIGOMATERIA"));
                materia.setNombre(resultSet.getString("NOMBREMATERIA"));
                materia.setTipo(resultSet.getString("TIPOMATERIA"));
                materia.setCreditos(resultSet.getInt("CREDITOSMATERIA"));
                materia.setNivel(resultSet.getInt("NIVELMATERIA"));
                materia.setCarrera(resultSet.getString("CARRERAMATERIA"));
                materias.add(materia);
            }
            conexion.closeConnection();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materias;
    }

    public MateriaVo buscarMateria(String tipo, String valor) {
        MateriaVo materia = new MateriaVo();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT * FROM materia WHERE " + tipo + "=" + "'" + valor + "'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                materia.setCodigo(resultSet.getString("CODIGOMATERIA"));
                materia.setNombre(resultSet.getString("NOMBREMATERIA"));
                materia.setTipo(resultSet.getString("TIPOMATERIA"));
                materia.setCreditos(resultSet.getInt("CREDITOSMATERIA"));
                materia.setNivel(resultSet.getInt("NIVELMATERIA"));
                materia.setCarrera(resultSet.getString("CARRERAMATERIA"));
                return materia;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
        return null;
    }

    public ArrayList<MateriaVo> buscarMaterias(String tipo, String valor) {
        ArrayList<MateriaVo> materias = new ArrayList<MateriaVo>();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT * FROM materia WHERE " + tipo + " LIKE " + "'" + valor + "%'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                MateriaVo materia = new MateriaVo();
                materia.setCodigo(resultSet.getString("CODIGOMATERIA"));
                materia.setNombre(resultSet.getString("NOMBREMATERIA"));
                materia.setTipo(resultSet.getString("TIPOMATERIA"));
                materia.setCreditos(resultSet.getInt("CREDITOSMATERIA"));
                materia.setNivel(resultSet.getInt("NIVELMATERIA"));
                materia.setCarrera(resultSet.getString("CARRERAMATERIA"));
                materias.add(materia);
            }
            conexion.closeConnection();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materias;

    }

    public boolean existeMateria(String tipo, String valor) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT * FROM materia WHERE " + tipo + "=" + "'" + valor + "'";
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

}
