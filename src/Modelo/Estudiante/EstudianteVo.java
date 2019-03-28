/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Estudiante;

import Modelo.Persona;
import java.awt.Image;
import java.io.File;
import java.util.Date;

/**
 *
 * @author 
 */
public class EstudianteVo extends Persona{


    String carrera;

    public EstudianteVo() {
    }

    public EstudianteVo(String carrera, String cedula, String nombre1, String nombre2, String apellido1, String apellido2, String telefono, String mail, String pass, int creditos, int creditosDisponibles, Date fecha, File foto, Image foto1) {
        super(cedula, nombre1, nombre2, apellido1, apellido2, telefono, mail, pass, creditos, creditosDisponibles, fecha, foto, foto1);
        this.carrera = carrera;
    }

    public EstudianteVo(String carrera, String cedula, String nombre1, String nombre2, String apellido1, String apellido2, String telefono, String mail, String pass, int creditos, int creditosDisponibles, Date fecha, File foto) {
        super(cedula, nombre1, nombre2, apellido1, apellido2, telefono, mail, pass, creditos, creditosDisponibles, fecha, foto);
        this.carrera = carrera;
    }





    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }


  

  



    

}
