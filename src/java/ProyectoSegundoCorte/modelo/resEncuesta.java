/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSegundoCorte.modelo;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BROTHER
 */
@Named(value = "resEncuesta")
@SessionScoped
public class resEncuesta implements Serializable {

    /**
     * Creates a new instance of resEncuesta
     */
    public resEncuesta() {
    }

    private String idEncuesta;
    private List<Pregunta> listaResPre = new ArrayList<>();

    public resEncuesta(String idEncuesta, List<Pregunta> listaResPre) {
        this.idEncuesta = idEncuesta;
        this.listaResPre = listaResPre;
    }

    public String getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(String idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public List<Pregunta> getListaResPre() {
        return listaResPre;
    }

    public void setListaResPre(List<Pregunta> listaResPre) {
        this.listaResPre = listaResPre;
    }


}
