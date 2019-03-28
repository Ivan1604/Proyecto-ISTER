/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Curso;

import Controlador.Conexion;
import Modelo.Estudiante.EstudianteVo;
import Modelo.Materia.MateriaDao;
import Modelo.Materia.MateriaVo;
import com.mysql.jdbc.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class CursoDao {

    public boolean existeClase(ClaseVo clase) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            //String Query = "SELECT * FROM curso WHERE " + tipo + "=" + "'" + valor + "'";
            String Query = "SELECT CEDULADOCENTE from curso where CODIGOCURSO IN (SELECT CODIGOCURSO FROM clase WHERE DIACLASE=" + clase.getDia() + " AND HORACLASE=" + clase.getHora() + ")";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                if (resultSet.getString("CEDULADOCENTE").equals(clase.getDocente())) {
                    JOptionPane.showMessageDialog(null, "El docente ya tiene asignado una clase en este dia y esta hora");
                    return true;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean existeClaseEstudiante(ClaseVo clase) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            //String Query = "SELECT * FROM curso WHERE " + tipo + "=" + "'" + valor + "'";
            String Query = "SELECT CEDULAESTUDIANTE from estudiantemateria where CODIGOCURSO=(SELECT CODIGOCURSO FROM clase WHERE DIACLASE=" + clase.getDia() + " AND HORACLASE=" + clase.getHora() + ")";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {

                //JOptionPane.showMessageDialog(null, "El estudiante ya tiene asignado una clase en este dia y esta hora");
                return true;

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean existeCurso(int codigo) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT * FROM curso WHERE CODIGOCURSO=" + codigo;
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

    public void ingresarCurso(CursoVo curso) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call agregarCurso(?,?,?)}");
            cs.setString("materia1", curso.getMateria());
            cs.setString("docente1", curso.getDocente());
            cs.setInt("curso1", curso.getCodigo());
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "El curso se ha registrado correctamente.", "Ingreso de Cursos", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ingresarClase(ClaseVo clase) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call agregarClase(?,?,?,?)}");
            cs.setInt("dia", clase.getDia());
            cs.setInt("hora", clase.getHora());
            cs.setString("aula", clase.getAula());
            cs.setInt("curso1", clase.getCurso());
            cs.executeUpdate();
            //JOptionPane.showMessageDialog(null, "El curso se ha registrado correctamente.", "Ingreso de Cursos", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CursoVo buscarCurso(int codigo) {
        CursoVo curso = new CursoVo();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT * FROM curso WHERE CODIGOCURSO=" + codigo;
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                curso.setCodigo(resultSet.getInt("CODIGOCURSO"));
                curso.setMateria(resultSet.getString("CODIGOMATERIA"));
                curso.setDocente(resultSet.getString("CEDULADOCENTE"));
                return curso;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
        return null;
    }

    public void eliminarCurso(int codigo) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call eliminarCurso(?)}");
            cs.setInt("codigo", codigo);
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null, "El curso se ha eliminado correctamente.", "Eliminacion de Cursos", JOptionPane.WARNING_MESSAGE);
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registraAsistencia(String cedula, int codigo, boolean asiste) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            CallableStatement cs;
            cs = (CallableStatement) conexion.getConexion().prepareCall("{call registraAsistencia(?,?,?,?)}");
            cs.setInt("codigo", codigo);
            cs.setString("cedula", cedula);
            cs.setBoolean("asiste", asiste);
            Date fecha = new Date();
            java.sql.Date date = new java.sql.Date(fecha.getTime());
            cs.setDate("fecha", date);
            cs.executeUpdate();
            conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<EstudianteVo> EstudiantesAsistencia(String codigo, String fecha) {
        ArrayList<EstudianteVo> estudiantes = new ArrayList<EstudianteVo>();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT * from asistenciaestudiante a INNER JOIN estudiante e ON E.CEDULAESTUDIANTE=A.CEDULAESTUDIANTE WHERE FECHAASISTENCIAE='" + fecha + "' AND CODIGOCURSO='" + codigo + "'" + " AND PRESENTEASISTENCIAE =" + 1;
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
                estudiantes.add(estudiante);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estudiantes;
    }

    public ArrayList<CursoVo> cursosRegistrados() {
        ArrayList<CursoVo> cursos = new ArrayList<CursoVo>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            String Query = "SELECT C.CODIGOCURSO, M.NOMBREMATERIA, D.NOMBRE1DOCENTE, D.APELLIDO1DOCENTE FROM curso C INNER JOIN materia M ON M.CODIGOMATERIA=C.CODIGOMATERIA INNER JOIN docente D ON D.CEDULADOCENTE=C.CEDULADOCENTE";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                CursoVo curso = new CursoVo();
                curso.setCodigo(resultSet.getInt("CODIGOCURSO"));
                curso.setMateria(resultSet.getString("NOMBREMATERIA"));
                curso.setDocente(resultSet.getString("NOMBRE1DOCENTE") + " " + resultSet.getString("APELLIDO1DOCENTE"));
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        conexion.closeConnection();
        return cursos;
    }

    public ArrayList<CursoVo> cursosCoincidencia(String codigo) {
        ArrayList<CursoVo> cursos = new ArrayList<CursoVo>();
        Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
        try {
            String Query = "SELECT C.CODIGOCURSO, M.NOMBREMATERIA, D.NOMBRE1DOCENTE, D.APELLIDO1DOCENTE FROM curso C INNER JOIN materia M ON M.CODIGOMATERIA=C.CODIGOMATERIA INNER JOIN docente D ON D.CEDULADOCENTE=C.CEDULADOCENTE WHERE CODIGOCURSO LIKE '" + codigo + "%'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                CursoVo curso = new CursoVo();
                curso.setCodigo(resultSet.getInt("CODIGOCURSO"));
                curso.setMateria(resultSet.getString("NOMBREMATERIA"));
                curso.setDocente(resultSet.getString("NOMBRE1DOCENTE") + " " + resultSet.getString("APELLIDO1DOCENTE"));
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        conexion.closeConnection();
        return cursos;
    }

    public ArrayList<ClaseVo> horarioDocente(String cedula) {
        ArrayList<ClaseVo> clases = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT c.DIACLASE, c.HORACLASE, c.CODIGOCURSO, c.AULACLASE, M.NOMBREMATERIA FROM clase c INNER JOIN curso b ON b.CODIGOCURSO = c.CODIGOCURSO INNER JOIN CURSO s ON S.CODIGOCURSO=C.CODIGOCURSO INNER JOIN materia M ON M.CODIGOMATERIA=S.CODIGOMATERIA WHERE b.CEDULADOCENTE='" + cedula + "'";
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                ClaseVo clase = new ClaseVo();
                clase.setDia(resultSet.getInt("DIACLASE"));
                clase.setHora(resultSet.getInt("HORACLASE"));
                clase.setDocente(cedula);
                clase.setAula(resultSet.getString("AULACLASE"));
                clase.setCurso(resultSet.getInt("CODIGOCURSO"));
                clase.setMateria(resultSet.getString("NOMBREMATERIA"));
                clases.add(clase);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clases;
    }

    public ArrayList<ClaseVo> horarioEstudiante(String cedula) {
        ArrayList<ClaseVo> clases = new ArrayList<ClaseVo>();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT c.DIACLASE, c.HORACLASE, c.CODIGOCURSO, c.AULACLASE, b.CEDULAESTUDIANTE, M.NOMBREMATERIA FROM clase c INNER JOIN estudiantemateria b ON b.CODIGOCURSO = c.CODIGOCURSO INNER JOIN CURSO s ON S.CODIGOCURSO=C.CODIGOCURSO INNER JOIN materia M ON M.CODIGOMATERIA=S.CODIGOMATERIA WHERE b.CEDULAESTUDIANTE=" + cedula;
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                ClaseVo clase = new ClaseVo();
                clase.setDia(resultSet.getInt("DIACLASE"));
                clase.setHora(resultSet.getInt("HORACLASE"));
                clase.setAula(resultSet.getString("AULACLASE"));
                clase.setCurso(resultSet.getInt("CODIGOCURSO"));
                clase.setMateria(resultSet.getString("NOMBREMATERIA"));
                clases.add(clase);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clases;
    }

    public ArrayList<ClaseVo> horarioCurso(int codigo) {
        ArrayList<ClaseVo> clases = new ArrayList<ClaseVo>();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT c.DIACLASE, c.HORACLASE, c.CODIGOCURSO, c.AULACLASE, b.CEDULADOCENTE FROM clase c INNER JOIN curso b ON b.CODIGOCURSO = c.CODIGOCURSO WHERE b.CODIGOCURSO=" + codigo;
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                ClaseVo clase = new ClaseVo();
                clase.setDia(resultSet.getInt("DIACLASE"));
                clase.setHora(resultSet.getInt("HORACLASE"));
                clase.setDocente("CEDULADOCENTE");
                clase.setAula(resultSet.getString("AULACLASE"));
                clase.setCurso(resultSet.getInt("CODIGOCURSO"));
                clases.add(clase);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clases;
    }

    public ArrayList<EstudianteVo> EstudiantesCurso(int codigo) {
        ArrayList<EstudianteVo> estudiantes = new ArrayList<EstudianteVo>();
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT b.CEDULAESTUDIANTE, b.NOMBRE1ESTUDIANTE, b.NOMBRE2ESTUDIANTE, b.APELLIDO1ESTUDIANTE, b.APELLIDO2ESTUDIANTE FROM estudiantemateria c INNER JOIN estudiante b ON b.CEDULAESTUDIANTE = c.CEDULAESTUDIANTE WHERE c.CODIGOCURSO=" + codigo;
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
                estudiantes.add(estudiante);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estudiantes;
    }

    public ClaseVo ClaseActual(int hora, int dia, String cedula) {
        try {
            Conexion conexion = Conexion.getInstance("root","root", "programacionvisual");
            String Query = "SELECT c.DIACLASE, c.HORACLASE, c.CODIGOCURSO, c.AULACLASE, b.CEDULADOCENTE FROM clase c INNER JOIN curso b ON b.CODIGOCURSO = c.CODIGOCURSO WHERE b.CEDULADOCENTE='" + cedula + "' and c.HORACLASE=" + hora + " and c.DIACLASE=" + dia;
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                ClaseVo clase = new ClaseVo();
                clase.setDia(resultSet.getInt("DIACLASE"));
                clase.setHora(resultSet.getInt("HORACLASE"));
                clase.setDocente(resultSet.getString("CEDULADOCENTE"));
                clase.setAula(resultSet.getString("AULACLASE"));
                clase.setCurso(resultSet.getInt("CODIGOCURSO"));
                return clase;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MateriaVo MateriaCurso(int codigo) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            String Query = "SELECT c.CODIGOMATERIA, c.TIPOMATERIA, c.CREDITOSMATERIA, c.NOMBREMATERIA FROM materia c INNER JOIN curso b ON b.CODIGOMATERIA = c.CODIGOMATERIA WHERE b.CODIGOCURSO=" + codigo;
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                MateriaVo materia = new MateriaVo();
                materia.setCodigo(resultSet.getString("CODIGOMATERIA"));
                materia.setCreditos(resultSet.getInt("CREDITOSMATERIA"));
                materia.setNombre(resultSet.getString("NOMBREMATERIA"));
                materia.setTipo(resultSet.getString("TIPOMATERIA"));
                return materia;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean verificaAsistencia(int codigo) {
        try {
            Conexion conexion = Conexion.getInstance("root", "root", "programacionvisual");
            Date fecha = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            java.sql.Date date = new java.sql.Date(fecha.getTime());
            String Query = "SELECT CEDULAESTUDIANTE FROM asistenciaestudiante WHERE FECHAASISTENCIAE='" + dateFormat.format(date) + "' AND CODIGOCURSO=" + codigo;
            Statement st = conexion.getConexion().createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            //Logger.getLogger(MateriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
