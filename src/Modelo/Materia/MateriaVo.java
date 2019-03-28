/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Materia;

/**
 *
 * @author 
 */
public class MateriaVo {
    String codigo;
    String nombre;
    String tipo;
    int creditos;
    int nivel;
    String carrera;

    public MateriaVo() {
    }

    public MateriaVo(String codigo, String nombre, String tipo, int creditos, int nivel, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.creditos = creditos;
        this.nivel = nivel;
        this.carrera = carrera;
    }



    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }


    
    
}
