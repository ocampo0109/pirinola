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
@Named(value = "nodoVisitante")
@SessionScoped
public class NodoVisitante implements Serializable {

    private Visitante datos;
    private NodoVisitante izquierda;
    private NodoVisitante derecha;

    public NodoVisitante(Visitante datos) {
        this.datos = datos;
        this.izquierda = this.derecha = null;
    }

    public Visitante getDatos() {
        return datos;
    }

    public void setDatos(Visitante datos) {
        this.datos = datos;
    }

    public NodoVisitante getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoVisitante izquierda) {
        this.izquierda = izquierda;
    }

    public NodoVisitante getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoVisitante derecha) {
        this.derecha = derecha;
    }

    @Override
    public String toString() {
        return "NodoVisitante{" + "datos=" + datos + '}';
    }

    /**
     * Creates a new instance of NodoVisitante
     */
    public NodoVisitante() {
    }

}
