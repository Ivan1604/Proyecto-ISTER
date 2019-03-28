/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tema;

import Controlador.Conexion;
import Modelo.Curso.CursoVo;
import Modelo.Materia.MateriaDao;
import com.mysql.jdbc.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class TemaDao {

    public void ingresarTema(TemaVo tema) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call registraTema(?,?,?,?,?)}");
            cs.setInt("codigo", tema.getCodigo());
            cs.setString("tema1", tema.getTema());
            cs.setString("objetivo", tema.getObjetivo());
            cs.setString("obs", tema.getObs());
            java.sql.Date date = new java.sql.Date(tema.getFecha().getTime());
            cs.setDate("fecha", date);
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "El tema se ha registrado correctamente.", "Registro de tematica diaria", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<TemaVo> TemaCurso(int codigo) {
        ArrayList<TemaVo> temas = new ArrayList<TemaVo>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            String Query = "SELECT * FROM tema WHERE CODIGOCURSO=" + codigo;
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                TemaVo tema = new TemaVo();
                tema.setCodigo(resultSet.getInt("CODIGOCURSO"));
                tema.setTema(resultSet.getString("NOMBRETEMA"));
                tema.setObjetivo(resultSet.getString("OBJETIVOTEMA"));
                tema.setObs(resultSet.getString("OBSTEMA"));
                java.util.Date date = new java.util.Date(resultSet.getDate("FECHATEMA").getTime());
                tema.setFecha(date);
                temas.add(tema);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        conexion.closeConnection();
        return temas;
    }

    public ArrayList<TemaVo> TemaReporte(String Query) {
        ArrayList<TemaVo> temas = new ArrayList<TemaVo>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                System.out.println("entro");
                TemaVo tema = new TemaVo();
                tema.setCodigo(resultSet.getInt("CODIGOCURSO"));
                tema.setTema(resultSet.getString("NOMBRETEMA"));
                tema.setObjetivo(resultSet.getString("OBJETIVOTEMA"));
                tema.setObs(resultSet.getString("OBSTEMA"));
                java.util.Date date = new java.util.Date(resultSet.getDate("FECHATEMA").getTime());
                tema.setFecha(date);
                temas.add(tema);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        conexion.closeConnection();
        return temas;
    }

}
