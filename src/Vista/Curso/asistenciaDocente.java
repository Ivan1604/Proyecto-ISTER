/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Curso;

import java.util.Date;

/**
 *
 * @author 
 */
public class asistenciaDocente {
    Date fecha;
    int codigo;
    String cedula;
    String entrada;
    String salida;
    boolean asiste;

    public asistenciaDocente() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public boolean isAsiste() {
        return asiste;
    }

    public void setAsiste(boolean asiste) {
        this.asiste = asiste;
    }

    public asistenciaDocente(Date fecha, int codigo, String cedula, String entrada, String salida, boolean asiste) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.cedula = cedula;
        this.entrada = entrada;
        this.salida = salida;
        this.asiste = asiste;
    }

    
}
