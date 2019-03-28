/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Curso;

/**
 *
 * @author
 */
public class ClaseVo {

    int hora;
    int dia;
    String aula;
    String docente;
    int curso;
    String materia;

    public ClaseVo() {
    }

    public ClaseVo(int hora, int dia, String aula, String docente, int curso) {
        this.hora = hora;
        this.dia = dia;
        this.aula = aula;
        this.docente = docente;
        this.curso = curso;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "ClaseVo{" + "hora=" + hora + ", dia=" + dia + ", aula=" + aula + ", docente=" + docente + '}';
    }

}
