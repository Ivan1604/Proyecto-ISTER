/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.PanelEstudiante.InicioEstudiante;
import Vista.PanelEstudiante.EstudianteControl;
import Vista.PanelDocente.InicioDocente;
import Vista.PanelDocente.DocenteControl;
import Modelo.Curso.ClaseVo;
import Modelo.Curso.CursoDao;
import Modelo.Curso.CursoVo;
import Modelo.Docente.DocenteDao;
import Modelo.Docente.DocenteVo;
import Modelo.Estudiante.EstudianteDao;
import Modelo.Estudiante.EstudianteVo;
import Modelo.Materia.MateriaDao;
import Modelo.Materia.MateriaVo;
import Modelo.Tema.TemaDao;
import Modelo.Tema.TemaVo;
import Vista.Materias.*;
import Vista.Estudiante.*;
import Vista.Docente.*;
import Vista.*;
import Vista.Administrador;
import Vista.Curso.EliminarCurso;
import Vista.Curso.IngresarCurso;
import Vista.Curso.VerCurso;
import Vista.Curso.asistenciaDocente;
import Vista.PanelDocente.AsistenciaDocente;
import Vista.PanelDocente.EditarDocentePanel;
import Vista.PanelDocente.HorarioDocente;
import Vista.PanelDocente.TematicaDocente;
import Vista.PanelEstudiante.EditarEstudiantePanel;
import Vista.PanelEstudiante.HorarioEstudiante;
import Vista.PanelEstudiante.MatricularEstudiante;
import Vista.PanelEstudiante.TematicaEstudiante;
import Vista.Reporte.AsistenciaReporte;
import Vista.Reporte.AsistenciaReporteEstudiante;
import Vista.Reporte.CursoReporte;
import Vista.Reporte.DocenteReporte;
import Vista.Reporte.DocenteReporte1;
import Vista.Reporte.HorarioDocenteReporte;
import Vista.Reporte.HorarioEstudianteReporte;
import Vista.Reporte.ListaCurso;
import Vista.Reporte.ListaDocente;
import Vista.Reporte.ListaEstudiante;
import Vista.Reporte.MateriaReporte;
import Vista.Reporte.TematicaReporte;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Coordinador {

    Reloj reloj;
    public Logica logica = new Logica();
    Login login = new Login(this);
    Administrador administrador = new Administrador(this);
    Inicio inicio = new Inicio(this);
    CursoDao curso = new CursoDao();
    MateriaDao materia = new MateriaDao();
    EditarMateria editarMateria = new EditarMateria(this);
    IngresarMateria ingresarMateria = new IngresarMateria(this);
    EliminarMateria eliminarMateria = new EliminarMateria(this);
    BuscarMateria buscarMateria = new BuscarMateria(this);
    MateriaReporte materiaReporte = new MateriaReporte(this);

    DocenteDao docente = new DocenteDao();
    IngresarDocente ingresarDocente = new IngresarDocente(this);
    EditarDocente editarDocente = new EditarDocente(this);
    EliminarDocente eliminarDocente = new EliminarDocente(this);
    BuscarDocente buscarDocente = new BuscarDocente(this);
    DocenteControl docenteControl = new DocenteControl(this);
    InicioDocente inicioDocente = new InicioDocente(this);
    HorarioDocente horarioDocente = new HorarioDocente(this);
    AsistenciaDocente asistenciaDocente = new AsistenciaDocente(this);

    DocenteVo docenteVo = new DocenteVo();

    EstudianteDao estudiante = new EstudianteDao();
    IngresarEstudiante ingresarEstudiante = new IngresarEstudiante(this);
    EditarEstudiante editarEstudiante = new EditarEstudiante(this);
    EliminarEstudiante eliminarEstudiante = new EliminarEstudiante(this);
    BuscarEstudiante buscarEstudiante = new BuscarEstudiante(this);
    EstudianteControl estudianteControl = new EstudianteControl(this);
    InicioEstudiante inicioEstudiante = new InicioEstudiante(this);
    MatricularEstudiante matricularEstudiante = new MatricularEstudiante(this);
    MatricularEstudianteAdmin matricularEstudianteAdmin = new MatricularEstudianteAdmin(this);
    HorarioEstudiante horarioEstudiante = new HorarioEstudiante(this);
    VerMaterias verMaterias = new VerMaterias(this);
    VerCurso verCursos = new VerCurso(this);
    EstudianteVo estudianteVo = new EstudianteVo();
    EditarEstudiantePanel editarEstudiantePanel = new EditarEstudiantePanel(this);
    EditarDocentePanel editarDocentePanel = new EditarDocentePanel(this);

    IngresarCurso ingresarCurso = new IngresarCurso(this);
    EliminarCurso eliminarCurso = new EliminarCurso(this);
    TematicaEstudiante tematicaEstudiante = new TematicaEstudiante(this);
    ClaseVo clase = new ClaseVo();
    TemaDao tema = new TemaDao();
    DocenteReporte docenteReporte = new DocenteReporte(this);

    DocenteReporte1 docenteReporte1 = new DocenteReporte1(this);

    HorarioEstudianteReporte estudianteReporte = new HorarioEstudianteReporte(this);
    CursoReporte cursoReporte = new CursoReporte(this);
    TematicaReporte tematicaReporte = new TematicaReporte(this);
    asistenciaDocente asistenciaDocente1 = new asistenciaDocente();
    AsistenciaReporte asistenciaReporte = new AsistenciaReporte(this);
    AsistenciaReporteEstudiante asistenciaReporteEstudiante = new AsistenciaReporteEstudiante(this);
    RecuperarPass recupera = new RecuperarPass(this);
    HorarioDocenteReporte horarioDocenteReporte = new HorarioDocenteReporte(this);
    ListaDocente listaDocente = new ListaDocente(this);
    ListaEstudiante listaEstudiante = new ListaEstudiante(this);
    ListaCurso listaCurso = new ListaCurso(this);

    public void showRecupera() {
        recupera.setVisible(true);
    }

    public void hideRecupera() {
        recupera.setVisible(false);
    }

    public void enviaMail(String cedula, String mail, String pass) {
        String Username = "syscontroldocente@gmail.com";
        String PassWord = "proyecto2017";
        String Mensage = "Su contraseña es: " + pass;
        String To = mail;
        String Subject = "Recuperacion de Contraseña";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, PassWord);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Mensage);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public void verificaRecuperacion(String cedula, String mail) throws IOException {
        DocenteVo d = docente.buscarDocenteRecuperar(cedula, mail);
        if (d != null) {
            enviaMail(cedula, mail, d.getPass());
            return;
        }
        EstudianteVo e = estudiante.buscarEstudianteRecuperar(cedula, mail);
        if (e != null) {
            enviaMail(cedula, mail, e.getPass());
        }
    }

    public asistenciaDocente getAsistenciaDocente1() {
        return asistenciaDocente1;
    }

    public void setAsistenciaDocente1(asistenciaDocente asistenciaDocente1) {
        this.asistenciaDocente1 = asistenciaDocente1;
    }

    public TematicaDocente getTematicaDocente() {
        return tematicaDocente;
    }

    public CursoDao getCurso() {
        return curso;
    }

    TematicaDocente tematicaDocente = new TematicaDocente(this);

    public AsistenciaDocente getAsistenciaDocente() {
        return asistenciaDocente;
    }

    public void setAsistenciaDocente(AsistenciaDocente asistenciaDocente) {
        this.asistenciaDocente = asistenciaDocente;
    }

    public ClaseVo getClase() {
        return clase;
    }

    public void hideDocenteControl() {
        docenteControl.btnTematica.setEnabled(false);
        docenteControl.asistenciaEstudiante.setEnabled(false);
        docenteControl.setVisible(false);
    }

    public void hideEstudianteControl() {
        estudianteControl.setVisible(false);
    }

    public void setClase(ClaseVo clase) {
        this.clase = clase;
    }

    public Coordinador() {
        JLabel label1 = new JLabel();
        reloj = new Reloj(label1);
        Thread t1 = new Thread(reloj);
        t1.start();
    }

    public EstudianteVo getEstudianteVo() {
        return estudianteVo;
    }

    public void setEstudianteVo(EstudianteVo estudianteVo1) {
        this.estudianteVo = estudianteVo1;
    }

    public void setDocenteVo(DocenteVo docenteVo1) {
        this.docenteVo = docenteVo1;
    }

    public DocenteVo getDocenteVo() {
        return docenteVo;
    }

    public void iniciaReloj(JLabel label1) {
        reloj.setLabel(label1);
    }

    public void showLogin() {
        iniciaReloj(login.lblReloj);
        login.setVisible(true);
    }

    public void hideLogin() {
        login.setVisible(false);
    }

    public void showAdministrador() {
        //iniciaReloj(inicioAdministrador.lblReloj);
        administrador.setVisible(true);
    }

    public void hideAdministrador() {
        administrador.setVisible(false);
    }

//--------------------------MATERIAS-------------------------------------------//
    public void showIngresarMateria() {
        ingresarMateria.setSize(1500, 1500);
        ingresarMateria.limpiar();
        ingresarMateria.actualizarTabla();
        iniciaReloj(ingresarMateria.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(ingresarMateria);
        ingresarMateria.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showEditarMateria() {
        editarMateria.setSize(1500, 1500);
        editarMateria.actualizarTabla();
        editarMateria.limpiar();
        editarMateria.offCampos();
        iniciaReloj(editarMateria.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(editarMateria);
        editarMateria.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showEliminarMateria() {
        eliminarMateria.setSize(1500, 1500);
        eliminarMateria.limpiar();
        eliminarMateria.actualizarTabla();
        eliminarMateria.offCampos();
        iniciaReloj(eliminarMateria.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(eliminarMateria);
        eliminarMateria.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showBuscarMateria() {
        buscarMateria.setSize(1500, 1500);
        iniciaReloj(buscarMateria.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(buscarMateria);
        buscarMateria.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showMateriaReporte() {
        materiaReporte.setSize(1500, 1500);
        materiaReporte.limpiar();
        materiaReporte.cargaTabla();
        iniciaReloj(materiaReporte.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(materiaReporte);
        materiaReporte.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showDocenteReporte() {
        docenteReporte.setSize(1500, 1500);
        docenteReporte.limpiar();
        docenteReporte.cargaTabla();
        iniciaReloj(docenteReporte.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(docenteReporte);
        docenteReporte.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showDocenteReporte1() {
        docenteReporte1.setSize(1500, 1500);
        docenteReporte1.limpiar();
        docenteReporte1.cargaTabla();
        iniciaReloj(docenteReporte1.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(docenteReporte1);
        docenteReporte1.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showEstudianteReporteAsistencia() {
        asistenciaReporteEstudiante.setSize(1500, 1500);
        asistenciaReporteEstudiante.limpiar();
        iniciaReloj(asistenciaReporteEstudiante.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(asistenciaReporteEstudiante);
        asistenciaReporteEstudiante.setVisible(true);
        administrador.escritorio.repaint();
    }

    public ArrayList<MateriaVo> materiasRegistradas() {
        ArrayList<MateriaVo> materias = new ArrayList<MateriaVo>();
        materias = materia.materiasRegistradas();
        return materias;
    }

    public MateriaVo buscarMateria(String tipo, String valor) {
        MateriaVo materia1 = new MateriaVo();
        materia1 = materia.buscarMateria(tipo, valor);
        return materia1;
    }

    public boolean existeMateria(String tipo, String valor) {
        return materia.existeMateria(tipo, valor);
    }

    public void ingresarMateria(MateriaVo materia1) {
        materia.ingresarMateria(materia1);
    }

    public void editarMateria(MateriaVo materia1) {
        materia.editarMateria(materia1);
    }

    public void eliminarMateria(String codigo) {
        materia.eliminarMateria(codigo);
    }

    public ArrayList<MateriaVo> buscarMateriasCoincidencias(String tipo, String valor) {
        return materia.buscarMateriasCoincidencias(tipo, valor);
    }

    public ArrayList<MateriaVo> buscarMaterias(String tipo, String valor) {
        return materia.buscarMaterias(tipo, valor);
    }
//----------------------------------------------------------------------------//

//--------------------------ESTUDIANTE-----------------------------------------//    
    public void showIngresarEstudiante() {
        ingresarEstudiante.setSize(1500, 1500);
        ingresarEstudiante.limpiar();
        ingresarEstudiante.actualizarTabla();
        iniciaReloj(ingresarEstudiante.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(ingresarEstudiante);
        ingresarEstudiante.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showTematicaEstudiante() {
        tematicaEstudiante.setSize(1500, 1500);
        iniciaReloj(tematicaEstudiante.lblReloj);
        estudianteControl.escritorio.removeAll();
        estudianteControl.escritorio.add(tematicaEstudiante);
        tematicaEstudiante.setVisible(true);
        estudianteControl.escritorio.repaint();
    }

    public void showEditarEstudiantePanel() {
        editarEstudiantePanel.setSize(1500, 1500);
        editarEstudiantePanel.cargaTxt();
        iniciaReloj(editarEstudiantePanel.lblReloj);
        estudianteControl.escritorio.removeAll();
        estudianteControl.escritorio.add(editarEstudiantePanel);
        editarEstudiantePanel.setVisible(true);
        estudianteControl.escritorio.repaint();
    }

    public void showEstudianteReporte() {
        estudianteReporte.setSize(1500, 1500);
        estudianteReporte.limpiar();
        iniciaReloj(estudianteReporte.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(estudianteReporte);
        estudianteReporte.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showDocenteHorarioReporte() {
        horarioDocenteReporte.setSize(1500, 1500);
        horarioDocenteReporte.limpiar();
        iniciaReloj(horarioDocenteReporte.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(horarioDocenteReporte);
        horarioDocenteReporte.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showListaDocente() {
        listaDocente.setSize(1500, 1500);
        listaDocente.limpiar();
        iniciaReloj(listaDocente.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(listaDocente);
        listaDocente.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showListaEstudiante() {
        listaEstudiante.setSize(1500, 1500);
        listaEstudiante.limpiar();
        iniciaReloj(listaEstudiante.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(listaEstudiante);
        listaEstudiante.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showListaCurso() {
        listaCurso.setSize(1500, 1500);
        listaCurso.limpiar();
        iniciaReloj(listaCurso.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(listaCurso);
        listaCurso.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showCursosEstudiante() {

        estudianteReporte.setSize(1500, 1500);
        estudianteReporte.limpiar();
        iniciaReloj(estudianteReporte.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(estudianteReporte);
        estudianteReporte.setVisible(true);
        administrador.escritorio.repaint();

        verCursos.setSize(1500, 1500);

        iniciaReloj(verCursos.lblReloj);
        verCursos.actualizarTablaCursos();
        estudianteControl.escritorio.removeAll();
        estudianteControl.escritorio.add(verCursos);
        verCursos.setVisible(true);
        estudianteControl.escritorio.repaint();
    }

    public void showMateriasEstudiante() {
        verMaterias.setSize(1500, 1500);
        iniciaReloj(verMaterias.lblReloj);
        verMaterias.actualizarTabla();
        estudianteControl.escritorio.removeAll();
        estudianteControl.escritorio.add(verMaterias);
        verMaterias.setVisible(true);
        estudianteControl.escritorio.repaint();
    }

    public void showHorarioEstudiante() {
        horarioEstudiante.setSize(1500, 1500);
        horarioEstudiante.llenaHorario();
        iniciaReloj(horarioEstudiante.lblReloj);
        estudianteControl.escritorio.removeAll();
        estudianteControl.escritorio.add(horarioEstudiante);
        horarioEstudiante.setVisible(true);
        estudianteControl.escritorio.repaint();
    }

    public void showMatricularEstudianteAdmin() {
        matricularEstudianteAdmin.setSize(1500, 1500);
        matricularEstudianteAdmin.limpiar();
        matricularEstudianteAdmin.actualizarTablaCursos();
        iniciaReloj(matricularEstudianteAdmin.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(matricularEstudianteAdmin);
        matricularEstudianteAdmin.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showEditarEstudiante() {
        editarEstudiante.setSize(1500, 1500);
        editarEstudiante.actualizarTabla();
        editarEstudiante.limpiar();
        iniciaReloj(editarEstudiante.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(editarEstudiante);
        editarEstudiante.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showEliminarEstudiante() {
        eliminarEstudiante.setSize(1500, 1500);
        eliminarEstudiante.limpiar();
        eliminarEstudiante.actualizarTabla();
        iniciaReloj(eliminarEstudiante.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(eliminarEstudiante);
        eliminarEstudiante.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showBuscarEstudiante() {
        buscarEstudiante.setSize(1500, 1500);
        buscarEstudiante.limpiar();
        iniciaReloj(buscarEstudiante.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(buscarEstudiante);
        buscarEstudiante.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void ingresarEstudiante(EstudianteVo estudiante1) {
        estudiante.ingresarEstudiante(estudiante1);
    }

    public boolean existeEstudiante(String cedula) {
        return estudiante.existeEstudiante(cedula);
    }

    public EstudianteVo buscarEstudiante(String cedula) {
        return estudiante.buscarEstudiante(cedula);
    }

    public void editarEstudiante(EstudianteVo estudiante1) {
        estudiante.editarEstudiante(estudiante1);
    }

    public void eliminarEstudiante(String cedula) {
        estudiante.eliminarEstudiante(cedula);
    }

    public ArrayList<EstudianteVo> estudiantesRegistrados() {
        return estudiante.estudiantesRegistrados();
    }

    public void showEstudiante(EstudianteVo estudiante1) {
        //iniciaReloj(inicioAdministrador.lblReloj);
        estudianteControl.setVisible(true);
        estudianteVo = estudiante1;
        estudianteControl.setEstudiante(estudiante1);
        inicioEstudiante.lblNombre.setText("BIENVENIDO " + estudianteVo.getNombre1() + " " + estudianteVo.getApellido1());
    }

    public void showInicioEstudiante() {
        inicioEstudiante.setSize(1500, 1500);
        iniciaReloj(inicioEstudiante.lblReloj);
        estudianteControl.escritorio.removeAll();
        estudianteControl.escritorio.add(inicioEstudiante);
        inicioEstudiante.setVisible(true);
        estudianteControl.escritorio.repaint();
    }

    public void showMatricularEstudiante() {
        matricularEstudiante.setSize(1500, 1500);
        matricularEstudiante.actualizarTablaCursos();
        iniciaReloj(matricularEstudiante.lblReloj);
        estudianteControl.escritorio.removeAll();
        estudianteControl.escritorio.add(matricularEstudiante);
        matricularEstudiante.setVisible(true);
        estudianteControl.escritorio.repaint();
    }

    public void matriculaEstudiante(int codigo, String cedula) {
        estudiante.matriculaEstudiante(codigo, cedula);
    }

    public boolean existeEstudianteMatriculado(String cedula, int codigo) {
        return estudiante.existeEstudianteMatriculado(cedula, codigo);
    }

    public ArrayList<EstudianteVo> estudiantesCoincidencia(String cedula) {
        return estudiante.estudiantesCoincidencia(cedula);
    }

    public ArrayList<EstudianteVo> EstudiantesAsistencia(String codigo, String fecha) {
        return curso.EstudiantesAsistencia(codigo, fecha);
    }
//----------------------------------------------------------------------------//  
//--------------------------DOCENTE-----------------------------------------//    

    public void showIngresarDocente() {
        ingresarDocente.setSize(1500, 1500);
        ingresarDocente.actualizarTabla();
        iniciaReloj(ingresarDocente.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(ingresarDocente);
        ingresarDocente.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showEditarDocentePanel() {
        editarDocentePanel.setSize(1500, 1500);
        iniciaReloj(editarDocentePanel.lblReloj);
        editarDocentePanel.cargaTxt();
        docenteControl.escritorio.removeAll();
        docenteControl.escritorio.add(editarDocentePanel);
        editarDocentePanel.setVisible(true);
        docenteControl.escritorio.repaint();
    }

    public void showCursosDocente() {
        verCursos.setSize(1500, 1500);
        iniciaReloj(verCursos.lblReloj);
        verCursos.actualizarTablaCursos();
        docenteControl.escritorio.removeAll();
        docenteControl.escritorio.add(verCursos);
        verCursos.setVisible(true);
        docenteControl.escritorio.repaint();
    }

    public void showMateriasDocente() {
        verMaterias.setSize(1500, 1500);
        verMaterias.actualizarTabla();
        iniciaReloj(verMaterias.lblReloj);
        docenteControl.escritorio.removeAll();
        docenteControl.escritorio.add(verMaterias);
        verMaterias.setVisible(true);
        docenteControl.escritorio.repaint();
    }

    public void showTematicaDocente() {
        tematicaDocente.setSize(1500, 1500);
        tematicaDocente.actualizarTabla();
        iniciaReloj(tematicaDocente.lblReloj);
        docenteControl.escritorio.removeAll();
        docenteControl.escritorio.add(tematicaDocente);
        MateriaVo materiaVo = curso.MateriaCurso(clase.getCurso());
        tematicaDocente.lblTematica.setText(materiaVo.getNombre());
        tematicaDocente.setVisible(true);
        docenteControl.escritorio.repaint();
    }

    public void showDocente(DocenteVo docente1) {
        //iniciaReloj(inicioAdministrador.lblReloj);
        docenteControl.setVisible(true);
        docenteVo = docente1;
        docenteControl.setDocente(docente1);
        docenteControlTematica(docente1);
        if (clase != null) {
            docenteControl.controla();
        }

    }

    public void docenteControlTematica(DocenteVo docente1) {
        if (clase == null) {
            docenteControl.asistenciaEstudiante.setEnabled(false);
            inicioDocente.lblNombre.setText("BIENVENIDO " + docenteVo.getNombre1() + " " + docenteVo.getApellido1());
        } else {
            asistenciaDocente1 = new asistenciaDocente();
            asistenciaDocente1.setCedula(docente1.getCedula());
            asistenciaDocente1.setCodigo(clase.getCurso());
            java.util.Date fecha = new java.util.Date();
            asistenciaDocente1.setFecha(fecha);
            java.util.Date d = new java.util.Date();
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(d);
            SimpleDateFormat ff = new SimpleDateFormat("HH:mm:ss");
            String entrada = ff.format(d);
            asistenciaDocente1.setEntrada(entrada);
            MateriaVo materiaVo = curso.MateriaCurso(clase.getCurso());
            docenteControl.asistenciaEstudiante.setEnabled(true);
            inicioDocente.lblNombre.setText(materiaVo.getNombre());
            docenteControl.btnTematica.setEnabled(true);
            docenteControl.setClase(clase);
        }
    }

    public ArrayList<asistenciaDocente> reporteAsistencia(int codigo) {
        return docente.reporteAsistencia(codigo);
    }

    public void asistenciaDocente() {
        docente.asistenciaDocente(asistenciaDocente1);
    }

    public void showEditarDocente() {
        editarDocente.setSize(1500, 1500);
        editarDocente.actualizarTabla();
        iniciaReloj(editarDocente.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(editarDocente);
        editarDocente.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showHorarioDocente() {
        horarioDocente.setSize(1500, 1500);
        horarioDocente.llenaHorario();
        iniciaReloj(horarioDocente.lblReloj);
        docenteControl.escritorio.removeAll();
        docenteControl.escritorio.add(horarioDocente);
        horarioDocente.setVisible(true);
        docenteControl.escritorio.repaint();
    }

    public void showAsistenciaDocente() {
        asistenciaDocente.setSize(1500, 1500);
        iniciaReloj(asistenciaDocente.lblReloj);
        docenteControl.escritorio.removeAll();
        docenteControl.escritorio.add(asistenciaDocente);
        asistenciaDocente.setVisible(true);
        docenteControl.escritorio.repaint();
    }

    public void showEliminarDocente() {
        eliminarDocente.setSize(1500, 1500);
        eliminarDocente.actualizarTabla();
        iniciaReloj(eliminarDocente.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(eliminarDocente);
        eliminarDocente.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showBuscarDocente() {
        buscarDocente.setSize(1500, 1500);
        iniciaReloj(buscarDocente.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(buscarDocente);
        buscarDocente.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void ingresarDocente(DocenteVo docente1) {
        docente.ingresarDocente(docente1);
    }

    public boolean existeDocente(String cedula) {
        return docente.existeDocente(cedula);
    }

    public DocenteVo buscarDocente(String cedula) throws IOException {
        return docente.buscarDocente(cedula);
    }

    public void editarDocente(DocenteVo docente1) {
        docente.editarDocente(docente1);

    }

    public void eliminarDocente(String cedula) {
        docente.eliminarDocente(cedula);
    }

    public ArrayList<DocenteVo> docentesCoincidenciaMateria(String tipo, String valor) {
        return docente.docentesCoincidenciaMateria(tipo, valor);
    }

    public ArrayList<DocenteVo> docentesRegistrados() {
        return docente.docentesRegistrados();
    }

    public void showInicioDocente() {
        inicioDocente.setSize(1500, 1500);
        iniciaReloj(inicioDocente.lblReloj);
        docenteControl.escritorio.removeAll();
        docenteControl.escritorio.add(inicioDocente);
        inicioDocente.setVisible(true);
        docenteControl.escritorio.repaint();
    }

    public ArrayList<DocenteVo> docentesCoincidencia(String cedula) {
        return docente.docentesCoincidencia(cedula);
    }
//----------------------------------------------------------------------------//     

    public void showIngresarCurso() {
        ingresarCurso.setSize(1500, 1500);
        iniciaReloj(ingresarCurso.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(ingresarCurso);
        ingresarCurso.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showCursoReporte() {
        cursoReporte.setSize(1500, 1500);
        cursoReporte.limpiar();
        iniciaReloj(cursoReporte.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(cursoReporte);
        cursoReporte.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showEliminarCurso() {
        eliminarCurso.setSize(1500, 1500);
        eliminarCurso.limpiar();
        eliminarCurso.offCampos();
        iniciaReloj(eliminarCurso.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(eliminarCurso);
        eliminarCurso.setVisible(true);
        administrador.escritorio.repaint();
    }

    public boolean existeClase(ClaseVo clase1) {
        return curso.existeClase(clase1);
    }

    public ArrayList<CursoVo> cursosCoincidencia(String codigo) {
        return curso.cursosCoincidencia(codigo);
    }

    public void ingresarCurso(CursoVo curso1) {
        curso.ingresarCurso(curso1);
    }

    public boolean existeClaseEstudiante(ClaseVo clase) {
        return curso.existeClaseEstudiante(clase);
    }

    public boolean existeCurso(int codigo) {
        return curso.existeCurso(codigo);
    }

    public void ingresarClase(ClaseVo clase) {
        curso.ingresarClase(clase);
    }

    public ArrayList<CursoVo> cursosRegistrados() {
        return curso.cursosRegistrados();
    }

    public CursoVo buscarCurso(int codigo) {
        return curso.buscarCurso(codigo);
    }

    public void eliminarCurso(int codigo) {
        curso.eliminarCurso(codigo);
    }

    public ArrayList<ClaseVo> horarioDocente(String cedula) {
        return curso.horarioDocente(cedula);
    }

    public ArrayList<ClaseVo> horarioCurso(int codigo) {
        return curso.horarioCurso(codigo);
    }

    public ArrayList<EstudianteVo> EstudiantesCurso(int codigo) {
        return curso.EstudiantesCurso(codigo);
    }

    public void showTematicaReporte() {
        tematicaReporte.setSize(1500, 1500);
        tematicaReporte.limpiar();
        iniciaReloj(tematicaReporte.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(tematicaReporte);
        tematicaReporte.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void showAsistenciaReporte() {
        asistenciaReporte.setSize(1500, 1500);
        asistenciaReporte.limpiar();
        iniciaReloj(asistenciaReporte.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(asistenciaReporte);
        asistenciaReporte.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void registraAsistencia(String cedula, int codigo, boolean asiste) {
        curso.registraAsistencia(cedula, codigo, asiste);
    }

    public void ClaseActual(int hora, int dia, String cedula) {
        clase = curso.ClaseActual(hora, dia, cedula);
    }

    public void ingresarTema(TemaVo tema1) {
        tema.ingresarTema(tema1);
    }

    public ArrayList<TemaVo> TemaCurso(int codigo) {
        return tema.TemaCurso(codigo);
    }

    public MateriaVo MateriaCurso(int codigo) {
        return curso.MateriaCurso(codigo);
    }

    public ArrayList<ClaseVo> horarioEstudiante(String cedula) {
        return curso.horarioEstudiante(cedula);
    }

    public ArrayList<TemaVo> TemaReporte(String Query) {
        return tema.TemaReporte(Query);
    }

    public void showInicio() {
        inicio.setSize(1500, 1500);
        iniciaReloj(inicio.lblReloj);
        administrador.escritorio.removeAll();
        administrador.escritorio.add(inicio);
        inicio.setVisible(true);
        administrador.escritorio.repaint();
    }

    public void verificaAsistencia(int codigo) {
        if (!curso.verificaAsistencia(codigo)) {
            asistenciaDocente.btnGuardar.setEnabled(true);
            asistenciaDocente.TLista.setEnabled(true);
        } else {
            asistenciaDocente.btnGuardar.setEnabled(false);
            asistenciaDocente.TLista.setEnabled(false);
        }

    }

}
