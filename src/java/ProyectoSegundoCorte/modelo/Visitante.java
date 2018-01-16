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
@Named(value = "visitante")
@SessionScoped
public class Visitante implements Serializable {

    private String idVisitante;
    private String nombre;
    private Pais pais;

    public Visitante(String idVisitante, String nombre, Pais pais) {
        this.idVisitante = idVisitante;
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(String idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Creates a new instance of Visitante
     */
    public Visitante() {
    }

}
