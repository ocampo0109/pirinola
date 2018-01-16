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
@Named(value = "respuestaVisitante")
@SessionScoped
public class RespuestaVisitante implements Serializable {

    /**
     * Creates a new instance of RespuestaVisitante
     */
    public RespuestaVisitante() {
    }

    private Byte respuesta;
    private String idVisitante;

    public RespuestaVisitante(Byte respuesta, String idVisitante) {
        this.respuesta = respuesta;
        this.idVisitante = idVisitante;
    }

    public Byte getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Byte respuesta) {
        this.respuesta = respuesta;
    }

    public String getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(String idVisitante) {
        this.idVisitante = idVisitante;
    }

    @Override
    public String toString() {
        return "" + respuesta;
    }

}
