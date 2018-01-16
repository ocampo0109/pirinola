/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSegundoCorte.modelo;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author BROTHER
 */
@Named(value = "pregunta")
@SessionScoped
public class Pregunta implements Serializable {

    /**
     * Creates a new instance of Pregunta
     */
    public Pregunta() {
    }

    private String descripcion;
    private resPregunta respuesta;

    public Pregunta(String descripcion, resPregunta respuesta) {
        this.descripcion = descripcion;
        this.respuesta = respuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public resPregunta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(resPregunta respuesta) {
        this.respuesta = respuesta;
    }


    @Override
    public String toString() {
        return descripcion;
    }

}
