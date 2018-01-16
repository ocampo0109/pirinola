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
@Named(value = "nodoRespuesta")
@SessionScoped
public class NodoRespuesta implements Serializable {

    /**
     * Creates a new instance of NodoRespuesta
     */
    public NodoRespuesta() {
    }

    private RespuestaVisitante resVis;
    private NodoRespuesta izquierda;
    private NodoRespuesta derecha;

    public NodoRespuesta(RespuestaVisitante resVis) {
        this.resVis = resVis;
        this.izquierda = this.derecha = null;
    }

    public RespuestaVisitante getResVis() {
        return resVis;
    }

    public void setResVis(RespuestaVisitante resVis) {
        this.resVis = resVis;
    }

    public NodoRespuesta getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoRespuesta izquierda) {
        this.izquierda = izquierda;
    }

    public NodoRespuesta getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoRespuesta derecha) {
        this.derecha = derecha;
    }

    @Override
    public String toString() {
        return "NodoRespuesta=" + resVis;
    }

}
