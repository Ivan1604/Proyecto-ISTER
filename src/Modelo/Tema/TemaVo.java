/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tema;

import java.util.Date;

/**
 *
 * @author 
 */
public class TemaVo {

    Date fecha;
    int codigo;
    String tema;
    String objetivo;
    String obs;

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public TemaVo(Date fecha, int codigo, String tema, String objetivo, String obs) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.tema = tema;
        this.objetivo = objetivo;
        this.obs = obs;
    }



    public TemaVo() {
    }

}
