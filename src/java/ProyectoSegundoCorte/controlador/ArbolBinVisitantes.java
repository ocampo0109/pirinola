/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSegundoCorte.controlador;

import ProyectoSegundoCorte.modelo.NodoVisitante;
import ProyectoSegundoCorte.modelo.Pais;
import ProyectoSegundoCorte.modelo.Visitante;
import java.util.*;

/**
 *
 * @author BROTHER
 */
public class ArbolBinVisitantes {

    private NodoVisitante raiz = null;

    public ArbolBinVisitantes(NodoVisitante raiz) {
        this.raiz = raiz;
    }

    public ArbolBinVisitantes() {
    }

    public NodoVisitante getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoVisitante raiz) {
        this.raiz = raiz;
    }

    public String recorrerArbol(NodoVisitante nodoA) {
        String cadena = "";
        if (nodoA != null) {
            cadena = cadena + recorrerArbol(nodoA.getIzquierda());
            cadena = cadena + "" + nodoA.getDatos().toString() + '\n';
            cadena = cadena + recorrerArbol(nodoA.getDerecha());
            recorrerArbol(nodoA.getDerecha());

        }
        return cadena;
    }

    public NodoVisitante insertarRecursivo(NodoVisitante raizAux, NodoVisitante datoNuevo) {
        if (raizAux == null) {
            raizAux = datoNuevo;
        } else if (raizAux.getDatos().getIdVisitante().compareToIgnoreCase(datoNuevo.getDatos().getIdVisitante()) >= 0) {
            raizAux.setIzquierda(insertarRecursivo(raizAux.getIzquierda(), datoNuevo));

        } else {
            raizAux.setDerecha(insertarRecursivo(raizAux.getDerecha(), datoNuevo));
        }
        return (raizAux);
    }

    public List<Visitante> llenarLista(NodoVisitante nodoA, List<Visitante> listaAux) {
        if (nodoA != null) {
            llenarLista(nodoA.getIzquierda(), listaAux);
            listaAux.add(nodoA.getDatos());
            llenarLista(nodoA.getDerecha(), listaAux);
        }
        return listaAux;
    }

    public int peso(NodoVisitante nodoAux) {
        if (nodoAux == null) {
            return 0;
        } else {
            return (1 + peso(nodoAux.getIzquierda()) + peso(nodoAux.getDerecha()));
        }
    }

    public Pais paisNuevo(String nombreNuevo, String nombreCortoNuevo) {
        Pais paisNuevo = new Pais(nombreNuevo, nombreCortoNuevo);

        return paisNuevo;
    }

    public Visitante buscarVisitante(NodoVisitante nodoAux, String idVis) {

        Visitante visTemp = null;

        while (!(idVis.equals(nodoAux.getDatos().getIdVisitante()))) {
            if (idVis.compareToIgnoreCase(nodoAux.getDatos().getIdVisitante()) <= 0) {
                nodoAux = nodoAux.getIzquierda();
            } else {
                nodoAux = nodoAux.getDerecha();
            }
            if (nodoAux == null) {
                return null; //No lo encontró.
            }
        }
        visTemp = nodoAux.getDatos();
        return visTemp;
    }
    
    public boolean existe(NodoVisitante nodoAux, String idVis) {
        if (nodoAux != null) {
            if (nodoAux.getDatos().getIdVisitante().equals(idVis)) {
                return true;
            } else {
                if (nodoAux.getDatos().getIdVisitante().compareToIgnoreCase(idVis) >= 0) {
                    existe(nodoAux.getIzquierda(), idVis);
                } else {
                    existe(nodoAux.getDerecha(), idVis);
                }
            }
        }
        return false;
    }


}
