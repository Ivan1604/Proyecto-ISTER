/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.io.File;
import java.util.Date;

/**
 *
 * @author 
 */
public abstract class Persona {

    String cedula;
    String nombre1;
    String nombre2;
    String apellido1;
    String apellido2;
    String telefono;
    String mail;
    String pass;
    int creditos;
    int creditosDisponibles;
    Date fecha;
    File foto;
    Image foto1;

    public Persona() {
    }

    public Persona(String cedula, String nombre1, String nombre2, String apellido1, String apellido2, String telefono, String mail, String pass, int creditos, int creditosDisponibles, Date fecha, File foto, Image foto1) {
        this.cedula = cedula;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.mail = mail;
        this.pass = pass;
        this.creditos = creditos;
        this.creditosDisponibles = creditosDisponibles;
        this.fecha = fecha;
        this.foto = foto;
        this.foto1 = foto1;
    }

    public Persona(String cedula, String nombre1, String nombre2, String apellido1, String apellido2, String telefono, String mail, String pass, int creditos, int creditosDisponibles, Date fecha, File foto) {
        this.cedula = cedula;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.mail = mail;
        this.pass = pass;
        this.creditos = creditos;
        this.creditosDisponibles = creditosDisponibles;
        this.fecha = fecha;
        this.foto = foto;
    }



    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCreditosDisponibles() {
        return creditosDisponibles;
    }

    public void setCreditosDisponibles(int creditosDisponibles) {
        this.creditosDisponibles = creditosDisponibles;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public Image getFoto1() {
        return foto1;
    }

    public void setFoto1(Image foto1) {
        this.foto1 = foto1;
    }

    
}
