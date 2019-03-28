/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Docente;

import Modelo.Persona;
import java.awt.Image;
import java.io.File;
import java.util.Date;

public class DocenteVo extends Persona{
    
    String materia;
    
    
    public DocenteVo() {
    }

    public DocenteVo(String cedula, String nombre1, String nombre2, 
            String apellido1, String apellido2, String telefono, 
            String mail, String pass, int creditos, int creditosDisponibles, 
            Date fecha, File foto, Image foto1) {
        super(cedula, nombre1, nombre2, apellido1,
                apellido2, telefono, mail, pass, 
                creditos, creditosDisponibles, fecha, 
                foto, foto1);
    }
    public DocenteVo(String cedula, String nombre1, String nombre2, 
            String apellido1, String apellido2, String telefono, String mail, 
            String pass, int creditos, int creditosDisponibles, Date fecha, 
            File foto) {
        super(cedula, nombre1, nombre2, apellido1, apellido2, telefono, mail,
                pass, creditos, creditosDisponibles, fecha, foto);
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    }
