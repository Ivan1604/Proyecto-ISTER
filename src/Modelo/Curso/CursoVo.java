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
public class CursoVo {
    int codigo;
    String materia;
    String docente;

    public CursoVo() {
    }

    public CursoVo(int codigo, String materia, String docente) {
        this.codigo = codigo;
        this.materia = materia;
        this.docente = docente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }
    
    
}
