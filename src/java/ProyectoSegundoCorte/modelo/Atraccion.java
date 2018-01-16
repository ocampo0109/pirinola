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
@Named(value = "atraccion")
@SessionScoped
public class Atraccion implements Serializable {

    /**
     * Creates a new instance of Atraccion
     */
    public Atraccion() {
    }

    private String descripcion;
    private String idAtraccion;
    private resTodaEncuesta encuesta;

    public Atraccion(String descripcion, String idAtraccion, resTodaEncuesta encuesta) {
        this.descripcion = descripcion;
        this.idAtraccion = idAtraccion;
        this.encuesta = encuesta;
    }

    public resTodaEncuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(resTodaEncuesta encuesta) {
        this.encuesta = encuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdAtraccion() {
        return idAtraccion;
    }

    public void setIdAtraccion(String idAtraccion) {
        this.idAtraccion = idAtraccion;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
