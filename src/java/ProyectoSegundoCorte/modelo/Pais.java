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
@Named(value = "pais")
@SessionScoped
public class Pais implements Serializable {

    private String nombre;
    private String nombreCorto;

    public Pais(String nombre, String nombreCorto) {
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Creates a new instance of Pais
     */
    public Pais() {
    }

}
