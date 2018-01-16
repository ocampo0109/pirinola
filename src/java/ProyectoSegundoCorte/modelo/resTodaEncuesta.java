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
@Named(value = "resTodaEncuesta")
@SessionScoped
public class resTodaEncuesta implements Serializable {

    /**
     * Creates a new instance of resTodaEncuesta
     */
    public resTodaEncuesta() {
    }

    private List<resEncuesta> listaResEncuesta = new ArrayList<>();

    public resTodaEncuesta(List<resEncuesta> listaResEncuesta) {
        this.listaResEncuesta = listaResEncuesta;
    }

    public List<resEncuesta> getListaResEncuesta() {
        return listaResEncuesta;
    }

    public void setListaResEncuesta(List<resEncuesta> listaResEncuesta) {
        this.listaResEncuesta = listaResEncuesta;
    }

}
