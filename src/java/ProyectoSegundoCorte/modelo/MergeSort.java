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

/**
 *
 * @author BROTHER
 */
@Named(value = "mergeSort")
@SessionScoped
public class MergeSort implements Serializable {

    /**
     * Creates a new instance of MergeSort
     */
    public MergeSort() {
    }

    ArrayList<Integer> datosnum;

    public MergeSort(ArrayList<Integer> datosnum) {
        this.datosnum = datosnum;
    }


    public ArrayList<Integer> getDatosnum() {
        return datosnum;
    }

    public int getDatosNumPos(int pos) {
        return getDatosnum().get(pos);
    }

    public void setDatosnum(int pos, int valor) {
        getDatosnum().set(pos, valor);
    }

    //Metodos de ordenimiento
    //MergeSort
    public void mergeSort(int inicio, int fin) {
        int n1, n2;
        if (fin > 1) {
            n1 = fin / 2;
            n2 = fin - n1;
            mergeSort(inicio, n1);
            mergeSort(inicio + n1, n2);
            merge(inicio, n1, n2);

        }//fin del if

    }//fin merSort

    public void merge(int inicio, int n1, int n2) {
        ArrayList<Integer> buffer = new ArrayList<>(getDatosnum().size());
        for (int j = 0; j < getDatosnum().size(); j++) {
            buffer.add(0);
        }
        int temp = 0, temp1 = 0, temp2 = 0, i;
        while ((temp1 < n1) && (temp2 < n2)) {
            if (getDatosNumPos(inicio + temp1) < getDatosNumPos(inicio + n1 + temp2)) {
                //buffer[temp++]=(set) arreglo
                buffer.set(temp++, getDatosNumPos(inicio + (temp1++)));

            }//fin del if
            else {
                buffer.set(temp++, getDatosNumPos(inicio + n1 + (temp2++)));

            }//fin sino
        }
        while (temp1 < n1) {
            buffer.set(temp++, getDatosNumPos(inicio + (temp1++)));   //se cierra bajo del while cuando no se abre el corchete      
        }
        while (temp2 < n2) {
            buffer.set(temp++, getDatosNumPos(inicio + n1 + (temp2++)));

        }//fin miestras
        for (i = 0; i < n1 + n2; i++) {

            setDatosnum(inicio + i, buffer.get(i));
        }

    }

    public String toString() {
        String datos = "";
        for (Integer integer : datosnum) {
            datos = datos + integer + '\n';

        }
        return datos;

    }

}
