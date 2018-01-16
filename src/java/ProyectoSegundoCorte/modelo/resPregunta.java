/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSegundoCorte.modelo;

import ProyectoSegundoCorte.controlador.arbolRespuestas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author BROTHER
 */
@Named(value = "resPregunta")
@SessionScoped
public class resPregunta implements Serializable {

    /**
     * Creates a new instance of resPregunta
     */
    public resPregunta() {
    }
    
    private arbolRespuestas arbRes;
    private String idPregunta;

    public resPregunta(arbolRespuestas arbRes) {
        this.arbRes = arbRes;
    }

    public arbolRespuestas getArbRes() {
        return arbRes;
    }

    public void setArbRes(arbolRespuestas arbRes) {
        this.arbRes = arbRes;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }
    
}
