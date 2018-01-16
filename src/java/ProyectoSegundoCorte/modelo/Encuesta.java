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
@Named(value = "encuesta")
@SessionScoped
public class Encuesta implements Serializable {

    /**
     * Creates a new instance of Encuesta
     */
    public Encuesta() {
    }

    private Atraccion atraccion;
    private Visitante visitante;
    private Pregunta pregunta;

    public Encuesta(Atraccion atraccion, Visitante visitante, Pregunta pregunta) {
        this.atraccion = atraccion;
        this.visitante = visitante;
        this.pregunta = pregunta;
    }

    public Atraccion getAtraccion() {
        return atraccion;
    }

    public void setAtraccion(Atraccion atraccion) {
        this.atraccion = atraccion;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

}
