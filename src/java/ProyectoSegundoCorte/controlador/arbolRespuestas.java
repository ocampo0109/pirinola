/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSegundoCorte.controlador;

import ProyectoSegundoCorte.modelo.NodoRespuesta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author BROTHER
 */
@Named(value = "arbolRespuestas")
@SessionScoped
public class arbolRespuestas implements Serializable {

    /**
     * Creates a new instance of arbolRespuestas
     */
    public arbolRespuestas() {
    }

    private NodoRespuesta raiz = null;

    public arbolRespuestas(NodoRespuesta raiz) {
        this.raiz = raiz;
    }

    public NodoRespuesta getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoRespuesta raiz) {
        this.raiz = raiz;
    }

    public NodoRespuesta insertarRecursivo(NodoRespuesta raizAux, NodoRespuesta datoNuevo) {
        if (raizAux == null) {
            raizAux = datoNuevo;
        } else if (datoNuevo.getResVis().getRespuesta() <= raizAux.getResVis().getRespuesta()) {
            raizAux.setIzquierda(insertarRecursivo(raizAux.getIzquierda(), datoNuevo));

        } else {
            raizAux.setDerecha(insertarRecursivo(raizAux.getDerecha(), datoNuevo));
        }
        return (raizAux);
    }

    public String recorrerArbol(NodoRespuesta nodoA) {
        String cadena = "";
        if (nodoA != null) {
            cadena = cadena + recorrerArbol(nodoA.getIzquierda());
            cadena = cadena + "" + nodoA.getResVis().getRespuesta() + '\n';
            cadena = cadena + recorrerArbol(nodoA.getDerecha());
            recorrerArbol(nodoA.getDerecha());

        }
        return cadena;
    }

    public boolean buscarVisitante(NodoRespuesta nodoAux, String idVis) {
        if (nodoAux != null) {
            if (nodoAux.getResVis().getIdVisitante().equals(idVis)) {
                return true;
            } else {
                if (nodoAux.getResVis().getIdVisitante().compareToIgnoreCase(idVis) >= 0) {
                    buscarVisitante(nodoAux.getIzquierda(), idVis);
                } else {
                    buscarVisitante(nodoAux.getDerecha(), idVis);
                }
            }
        }
        return false;
    }

    public int contar(NodoRespuesta nodoAux, int dato) {
        if (nodoAux != null) {
            if (nodoAux.getResVis().getRespuesta() == dato) {
                return 1 + contar(nodoAux.getIzquierda(), dato)
                        + contar(nodoAux.getDerecha(), dato);
            } else {
                return 0 + contar(nodoAux.getIzquierda(), dato)
                        + contar(nodoAux.getDerecha(), dato);
            }
        }
        return 0;
    }

    public boolean existe(NodoRespuesta nodoAux, String idVis) {
        if (nodoAux != null) {
            if (nodoAux.getResVis().getIdVisitante().equals(idVis)) {
                return true;
            } else {
                if (nodoAux.getResVis().getIdVisitante().compareToIgnoreCase(idVis) >= 0) {
                    existe(nodoAux.getIzquierda(), idVis);
                } else {
                    existe(nodoAux.getDerecha(), idVis);
                }
            }
        }
        return false;
    }
}
