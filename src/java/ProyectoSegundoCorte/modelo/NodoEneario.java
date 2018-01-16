/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSegundoCorte.modelo;

import ProyectoSegundoCorte.controlador.cDatos;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author BROTHER
 */
@Named(value = "nodoEneario")
@Dependent
public class NodoEneario {

    /**
     * Creates a new instance of NodoEneario
     */
    public NodoEneario() {
    }

    private cDatos dato;
    private List<NodoEneario> hijos;

    public NodoEneario(cDatos dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    public cDatos getDato() {
        return dato;
    }

    public void setDato(cDatos dato) {
        this.dato = dato;
    }

    public List<NodoEneario> getHijos() {
        return hijos;
    }

    public void setHijos(List<NodoEneario> hijos) {
        this.hijos = hijos;
    }

    public void insertar(NodoEneario nodoAux) {
        hijos.add(nodoAux);
    }

    public void insertarOrdenado(NodoEneario nodoAux) {
        int i = 0;
        while ((i < hijos.size()) && (hijos.get(i).getDato().getDescripcion().compareTo(nodoAux.getDato().getDescripcion()) < 0)) {
            i++;
        }
        if (i < hijos.size()) {
            hijos.add(i, nodoAux);
        } else {
            hijos.add(nodoAux);
        }
    }

    public NodoEneario buscarNodo(String datoBuscar) {
        int bajo = 0;
        int alto = 0;
        int central = 0;
        alto = hijos.size();
        while (bajo < alto) {
            central = (bajo + alto) / 2;
            if (hijos.get(central).getDato().getId().equals(datoBuscar)) {
                return hijos.get(central);
            } else if (datoBuscar.compareTo(hijos.get(central).getDato().getId()) < 0) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String cadena;
        cadena = dato.toString() + "HIJOS " + '\n';

        for (NodoEneario hijo : hijos) {
            cadena = cadena + "HIJOS" + '\n' + hijo.toString();
        }
        return cadena;
    }
}
