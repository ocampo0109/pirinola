/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSegundoCorte.controlador;

import ProyectoSegundoCorte.modelo.NodoEneario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author BROTHER
 */
@Named(value = "arbolEneario")
@SessionScoped
public class ArbolEneario implements Serializable {

    /**
     * Creates a new instance of ArbolEneario
     */
    public ArbolEneario() {
    }

    private NodoEneario raiz;

    public ArbolEneario(NodoEneario raiz) {
        this.raiz = raiz;
    }

    public NodoEneario getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoEneario raiz) {
        this.raiz = raiz;
    }

    public void recorrerArbol(NodoEneario subArbol) {
        if (subArbol != null) {
            NodoEneario temp = subArbol;
            System.out.println(temp.getDato().getDescripcion());
            for (NodoEneario hijo : temp.getHijos()) {
                recorrerArbol(hijo);
            }
        }

    }

    public int peso(NodoEneario subArbol) {
        int cont = 0;
        if (subArbol != null) {
            NodoEneario temp = subArbol;
            for (NodoEneario hijo : temp.getHijos()) {
                cont = cont + 1 + peso(hijo);
            }
        }
        return cont;
    }

    public NodoEneario buscar(NodoEneario raizTemp, String datoBuscar) {
        if (raizTemp != null) {
            return raizTemp;
        } else {
            NodoEneario nodoT = raizTemp.buscarNodo(datoBuscar);
            if (nodoT != null) {
                return nodoT;
            }//Lo encontro
            else {
                for (NodoEneario miHijo : raizTemp.getHijos()) {
                    return buscar(miHijo, datoBuscar);
                }
            }
        }
        return null;
    }

    public void insertarNodo(String idPadre, cDatos nDato) {
        if (raiz.getDato().getId().equals(idPadre)) {
            raiz.insertarOrdenado(new NodoEneario(nDato));
        } else {
            NodoEneario nodoT2 = this.buscar(raiz, idPadre);
            if (nodoT2 != null) {
                nodoT2.insertarOrdenado(new NodoEneario(nDato));
            }
        }

    }

}
