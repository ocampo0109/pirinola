/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSegundoCorte.controlador;

import ProyectoSegundoCorte.modelo.Atraccion;
import ProyectoSegundoCorte.modelo.Encuesta;
import ProyectoSegundoCorte.modelo.NodoEneario;
import ProyectoSegundoCorte.modelo.NodoRespuesta;
import ProyectoSegundoCorte.modelo.NodoVisitante;
import ProyectoSegundoCorte.modelo.Pais;
import ProyectoSegundoCorte.modelo.Pregunta;
import ProyectoSegundoCorte.modelo.RespuestaVisitante;
import ProyectoSegundoCorte.modelo.Visitante;
import ProyectoSegundoCorte.modelo.resEncuesta;
import ProyectoSegundoCorte.modelo.resPregunta;
import ProyectoSegundoCorte.modelo.resTodaEncuesta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import java.util.Map;
import java.util.Map.Entry;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author BROTHER
 */
@Named(value = "arbolControlador")
@SessionScoped
public class ArbolControlador implements Serializable {

    /**
     * Creates a new instance of ArbolControlador
     */
    public ArbolControlador() {
        crearPaises();
        crearAtracciones();
        crearPreguntas();
        crearRespuestas();
        
    }

    //Crear arbol de visitantes
    ArbolBinVisitantes arbolVisitantes = new ArbolBinVisitantes();

    //Crear arboles de respuestas
    arbolRespuestas arbolPreguntaUno = new arbolRespuestas();
    arbolRespuestas arbolPreguntaDos = new arbolRespuestas();
    arbolRespuestas arbolPreguntaTres = new arbolRespuestas();
    arbolRespuestas arbolPreguntaCuatro = new arbolRespuestas();
    arbolRespuestas arbolPreguntaCinco = new arbolRespuestas();

    //Crear preguntas y respuestas 
    resPregunta respPregUno = new resPregunta(arbolPreguntaUno);
    resPregunta respPregDos = new resPregunta(arbolPreguntaDos);
    resPregunta respPregTres = new resPregunta(arbolPreguntaTres);
    resPregunta respPregCuatro = new resPregunta(arbolPreguntaCuatro);
    resPregunta respPregCinco = new resPregunta(arbolPreguntaCinco);
    Pregunta preguntaCIC1 = new Pregunta("Cumplio sus expectativas?", respPregUno);
    Pregunta preguntaCIC2 = new Pregunta("La recomendaria?", respPregDos);
    Pregunta preguntaHUL1 = new Pregunta("Las sensaciones generaron impacto y adrenalina?", respPregTres);
    Pregunta preguntaHUL2 = new Pregunta("Subiria de nuevo?", respPregCuatro);
    Pregunta preguntaCOM = new Pregunta("Valorar por favor servicios de comida?", respPregCinco);

    //Crear lista de paises
    List<Pais> listaPaises = new ArrayList<>();

    //Crear lista de visitantes
    List<Visitante> arrayVisitante = new ArrayList<>();

    //Crear lista de atracciones
    List<Atraccion> listaAtracciones = new ArrayList<>();

    //Crear lista de preguntas
    List<Pregunta> listaPreguntasCiclon = new ArrayList<>();
    List<Pregunta> listaPreguntasHulk = new ArrayList<>();
    List<Pregunta> listaPreguntaComida = new ArrayList<>();

    //Crear lista de encuestas para cada atraccion
    List<resEncuesta> listaEncuestasCiclon = new ArrayList<>();
    List<resEncuesta> listaEncuestasHulk = new ArrayList<>();
    List<resEncuesta> listaEncuestasComida = new ArrayList<>();

    //Crear encuestas de cada atraccion
    resTodaEncuesta encuestasCiclon = new resTodaEncuesta(listaEncuestasCiclon);
    resTodaEncuesta encuestasHulk = new resTodaEncuesta(listaEncuestasHulk);
    resTodaEncuesta encuestasComida = new resTodaEncuesta(listaEncuestasComida);

    //Crear lista de respuestas
    List<Byte> respuestasLargas = new ArrayList<>();
    List<Byte> respuestasCortas = new ArrayList<>();

    //Crear visitante que va a ser encontrado con el metodo BUSCAR
    Visitante visEncontrado = new Visitante();

    //Crear conteo de cada una de las respuestas existentes.
    private int conteoUnoLarga;
    private int conteoDosLarga;
    private int conteoTresLarga;
    private int conteoCuatroLarga;
    private int conteoCincoLarga;
    private int conteoUnoCorta;
    private int conteoDosCorta;
    private int conteoTresCorta;

    //Crear atraccion que va a ser encontrada con el metodo asignarAtraccion para consultar el reporte.
    Atraccion atrEncontrada = new Atraccion();

    private String buscarVisitante;
    private boolean verPanelEncuestas = false;
    private boolean verEncuestas = false;
    private boolean verVisitantes = false;
    private boolean verIngresar = false;
    private Visitante objVisitante = new Visitante();
    private String selectedItem;
    private String respSelected;
    private String respSelectedDos;
    private String selectedItemAtraccion;
    private String selectedItemAtraccionReporte;
    private int tamanio = 0;
    private boolean renderedCiclon = false;
    private boolean renderedHulk = false;
    private boolean renderedComida = false;
    private boolean renderedCiclonReporte = false;
    private boolean renderedHulkReporte = false;
    private boolean renderedComidaReporte = false;
    private boolean verReporte = false;

    //Getters & Setters
    public int getConteoUnoLarga() {
        return conteoUnoLarga;
    }

    public void setConteoUnoLarga(int conteoUnoLarga) {
        this.conteoUnoLarga = conteoUnoLarga;
    }

    public int getConteoDosLarga() {
        return conteoDosLarga;
    }

    public void setConteoDosLarga(int conteoDosLarga) {
        this.conteoDosLarga = conteoDosLarga;
    }

    public int getConteoTresLarga() {
        return conteoTresLarga;
    }

    public void setConteoTresLarga(int conteoTresLarga) {
        this.conteoTresLarga = conteoTresLarga;
    }

    public int getConteoCuatroLarga() {
        return conteoCuatroLarga;
    }

    public void setConteoCuatroLarga(int conteoCuatroLarga) {
        this.conteoCuatroLarga = conteoCuatroLarga;
    }

    public int getConteoCincoLarga() {
        return conteoCincoLarga;
    }

    public void setConteoCincoLarga(int conteoCincoLarga) {
        this.conteoCincoLarga = conteoCincoLarga;
    }

    public int getConteoUnoCorta() {
        return conteoUnoCorta;
    }

    public void setConteoUnoCorta(int conteoUnoCorta) {
        this.conteoUnoCorta = conteoUnoCorta;
    }

    public int getConteoDosCorta() {
        return conteoDosCorta;
    }

    public void setConteoDosCorta(int conteoDosCorta) {
        this.conteoDosCorta = conteoDosCorta;
    }

    public int getConteoTresCorta() {
        return conteoTresCorta;
    }

    public void setConteoTresCorta(int conteoTresCorta) {
        this.conteoTresCorta = conteoTresCorta;
    }

    public boolean isRenderedCiclonReporte() {
        return renderedCiclonReporte;
    }

    public void setRenderedCiclonReporte(boolean renderedCiclonReporte) {
        this.renderedCiclonReporte = renderedCiclonReporte;
    }

    public boolean isRenderedHulkReporte() {
        return renderedHulkReporte;
    }

    public void setRenderedHulkReporte(boolean renderedHulkReporte) {
        this.renderedHulkReporte = renderedHulkReporte;
    }

    public boolean isRenderedComidaReporte() {
        return renderedComidaReporte;
    }

    public void setRenderedComidaReporte(boolean renderedComidaReporte) {
        this.renderedComidaReporte = renderedComidaReporte;
    }

    public boolean isVerReporte() {
        return verReporte;
    }

    public void setVerReporte(boolean verReporte) {
        this.verReporte = verReporte;
    }

    public boolean isVerPanelEncuestas() {
        return verPanelEncuestas;
    }

    public void setVerPanelEncuestas(boolean verPanelEncuestas) {
        this.verPanelEncuestas = verPanelEncuestas;
    }

    public String getRespSelectedDos() {
        return respSelectedDos;
    }

    public Atraccion getAtrEncontrada() {
        return atrEncontrada;
    }

    public void setAtrEncontrada(Atraccion atrEncontrada) {
        this.atrEncontrada = atrEncontrada;
    }

    public void setRespSelectedDos(String respSelectedDos) {
        this.respSelectedDos = respSelectedDos;
    }

    public String getSelectedItemAtraccionReporte() {
        return selectedItemAtraccionReporte;
    }

    public void setSelectedItemAtraccionReporte(String selectedItemAtraccionReporte) {
        this.selectedItemAtraccionReporte = selectedItemAtraccionReporte;
    }

    public boolean isRenderedCiclon() {
        return renderedCiclon;
    }

    public void setRenderedCiclon(boolean renderedCiclon) {
        this.renderedCiclon = renderedCiclon;
    }

    public boolean isRenderedHulk() {
        return renderedHulk;
    }

    public void setRenderedHulk(boolean renderedHulk) {
        this.renderedHulk = renderedHulk;
    }

    public boolean isRenderedComida() {
        return renderedComida;
    }

    public void setRenderedComida(boolean renderedComida) {
        this.renderedComida = renderedComida;
    }

    public Visitante getVisEncontrado() {
        return visEncontrado;
    }

    public resPregunta getRespPregUno() {
        return respPregUno;
    }

    public void setRespPregUno(resPregunta respPregUno) {
        this.respPregUno = respPregUno;
    }

    public resPregunta getRespPregDos() {
        return respPregDos;
    }

    public void setRespPregDos(resPregunta respPregDos) {
        this.respPregDos = respPregDos;
    }

    public resPregunta getRespPregTres() {
        return respPregTres;
    }

    public void setRespPregTres(resPregunta respPregTres) {
        this.respPregTres = respPregTres;
    }

    public resPregunta getRespPregCuatro() {
        return respPregCuatro;
    }

    public void setRespPregCuatro(resPregunta respPregCuatro) {
        this.respPregCuatro = respPregCuatro;
    }

    public resPregunta getRespPregCinco() {
        return respPregCinco;
    }

    public void setRespPregCinco(resPregunta respPregCinco) {
        this.respPregCinco = respPregCinco;
    }

    public Pregunta getPreguntaCIC1() {
        return preguntaCIC1;
    }

    public void setPreguntaCIC1(Pregunta preguntaCIC1) {
        this.preguntaCIC1 = preguntaCIC1;
    }

    public Pregunta getPreguntaCIC2() {
        return preguntaCIC2;
    }

    public void setPreguntaCIC2(Pregunta preguntaCIC2) {
        this.preguntaCIC2 = preguntaCIC2;
    }

    public Pregunta getPreguntaHUL1() {
        return preguntaHUL1;
    }

    public void setPreguntaHUL1(Pregunta preguntaHUL1) {
        this.preguntaHUL1 = preguntaHUL1;
    }

    public Pregunta getPreguntaHUL2() {
        return preguntaHUL2;
    }

    public void setPreguntaHUL2(Pregunta preguntaHUL2) {
        this.preguntaHUL2 = preguntaHUL2;
    }

    public Pregunta getPreguntaCOM() {
        return preguntaCOM;
    }

    public void setPreguntaCOM(Pregunta preguntaCOM) {
        this.preguntaCOM = preguntaCOM;
    }

    public void setVisEncontrado(Visitante visEncontrado) {
        this.visEncontrado = visEncontrado;
    }

    public String getRespSelected() {
        return respSelected;
    }

    public void setRespSelected(String respSelected) {
        this.respSelected = respSelected;
    }

    public ArbolBinVisitantes getArbolVisitantes() {
        return arbolVisitantes;
    }

    public void setArbolVisitantes(ArbolBinVisitantes arbolVisitantes) {
        this.arbolVisitantes = arbolVisitantes;
    }

    public arbolRespuestas getArbolPreguntaUno() {
        return arbolPreguntaUno;
    }

    public void setArbolPreguntaUno(arbolRespuestas arbolPreguntaUno) {
        this.arbolPreguntaUno = arbolPreguntaUno;
    }

    public arbolRespuestas getArbolPreguntaDos() {
        return arbolPreguntaDos;
    }

    public void setArbolPreguntaDos(arbolRespuestas arbolPreguntaDos) {
        this.arbolPreguntaDos = arbolPreguntaDos;
    }

    public arbolRespuestas getArbolPreguntaTres() {
        return arbolPreguntaTres;
    }

    public void setArbolPreguntaTres(arbolRespuestas arbolPreguntaTres) {
        this.arbolPreguntaTres = arbolPreguntaTres;
    }

    public arbolRespuestas getArbolPreguntaCuatro() {
        return arbolPreguntaCuatro;
    }

    public void setArbolPreguntaCuatro(arbolRespuestas arbolPreguntaCuatro) {
        this.arbolPreguntaCuatro = arbolPreguntaCuatro;
    }

    public arbolRespuestas getArbolPreguntaCinco() {
        return arbolPreguntaCinco;
    }

    public void setArbolPreguntaCinco(arbolRespuestas arbolPreguntaCinco) {
        this.arbolPreguntaCinco = arbolPreguntaCinco;
    }

    public List<Pregunta> getListaPreguntasCiclon() {
        return listaPreguntasCiclon;
    }

    public void setListaPreguntasCiclon(List<Pregunta> listaPreguntasCiclon) {
        this.listaPreguntasCiclon = listaPreguntasCiclon;
    }

    public List<Pregunta> getListaPreguntasHulk() {
        return listaPreguntasHulk;
    }

    public void setListaPreguntasHulk(List<Pregunta> listaPreguntasHulk) {
        this.listaPreguntasHulk = listaPreguntasHulk;
    }

    public List<Pregunta> getListaPreguntaComida() {
        return listaPreguntaComida;
    }

    public void setListaPreguntaComida(List<Pregunta> listaPreguntaComida) {
        this.listaPreguntaComida = listaPreguntaComida;
    }

    public List<resEncuesta> getListaEncuestasCiclon() {
        return listaEncuestasCiclon;
    }

    public void setListaEncuestasCiclon(List<resEncuesta> listaEncuestasCiclon) {
        this.listaEncuestasCiclon = listaEncuestasCiclon;
    }

    public List<resEncuesta> getListaEncuestasHulk() {
        return listaEncuestasHulk;
    }

    public void setListaEncuestasHulk(List<resEncuesta> listaEncuestasHulk) {
        this.listaEncuestasHulk = listaEncuestasHulk;
    }

    public List<resEncuesta> getListaEncuestasComida() {
        return listaEncuestasComida;
    }

    public void setListaEncuestasComida(List<resEncuesta> listaEncuestasComida) {
        this.listaEncuestasComida = listaEncuestasComida;
    }

    public resTodaEncuesta getEncuestasCiclon() {
        return encuestasCiclon;
    }

    public void setEncuestasCiclon(resTodaEncuesta encuestasCiclon) {
        this.encuestasCiclon = encuestasCiclon;
    }

    public resTodaEncuesta getEncuestasHulk() {
        return encuestasHulk;
    }

    public void setEncuestasHulk(resTodaEncuesta encuestasHulk) {
        this.encuestasHulk = encuestasHulk;
    }

    public resTodaEncuesta getEncuestasComida() {
        return encuestasComida;
    }

    public void setEncuestasComida(resTodaEncuesta encuestasComida) {
        this.encuestasComida = encuestasComida;
    }

    public List<Byte> getRespuestasLargas() {
        return respuestasLargas;
    }

    public void setRespuestasLargas(List<Byte> respuestasLargas) {
        this.respuestasLargas = respuestasLargas;
    }

    public List<Byte> getRespuestasCortas() {
        return respuestasCortas;
    }

    public void setRespuestasCortas(List<Byte> respuestasCortas) {
        this.respuestasCortas = respuestasCortas;
    }

    public String getBuscarVisitante() {
        return buscarVisitante;
    }

    public void setBuscarVisitante(String buscarVisitante) {
        this.buscarVisitante = buscarVisitante;
    }

    public boolean isVerEncuestas() {
        return verEncuestas;
    }

    public void setVerEncuestas(boolean verEncuestas) {
        this.verEncuestas = verEncuestas;
    }

    public String getSelectedItemAtraccion() {
        return selectedItemAtraccion;
    }

    public void setSelectedItemAtraccion(String selectedItemAtraccion) {
        this.selectedItemAtraccion = selectedItemAtraccion;
    }

    public List<Atraccion> getListaAtracciones() {
        return listaAtracciones;
    }

    public void setListaAtracciones(List<Atraccion> listaAtracciones) {
        this.listaAtracciones = listaAtracciones;
    }

    public boolean isVerVisitantes() {
        return verVisitantes;
    }

    public void setVerVisitantes(boolean verVisitantes) {
        this.verVisitantes = verVisitantes;
    }

    public Visitante getObjVisitante() {
        return objVisitante;
    }

    public void setObjVisitante(Visitante objVisitante) {
        this.objVisitante = objVisitante;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public boolean isVerIngresar() {
        return verIngresar;
    }

    public void setVerIngresar(boolean verIngresar) {
        this.verIngresar = verIngresar;
    }

    public List<Visitante> getArrayVisitante() {
        return arrayVisitante;
    }

    public void setArrayVisitante(List<Visitante> arrayVisitante) {
        this.arrayVisitante = arrayVisitante;
    }

    public List<Pais> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(List<Pais> listaPaises) {
        this.listaPaises = listaPaises;
    }

    /////////////////////////////////////////////////////////////////////
    ///Metodos para las encuestas y reportes/////////////////////////////
    ////////////////////////////////////////////////////////////////////
    public void determinarRendered() {
        if (selectedItemAtraccion.equals("Ciclon")) {
            renderedCiclon = true;
        } else if (selectedItemAtraccion.equals("Hulk")) {
            renderedHulk = true;
        } else {
            renderedComida = true;
        }
    }

    public void ocultarRendered() {
        renderedCiclon = false;
        renderedHulk = false;
        renderedComida = false;
    }

    public void crearRespuestas() {
        byte uno = 1;
        byte dos = 2;
        byte tres = 3;
        byte cuatro = 4;
        byte cinco = 5;
        byte seis = 1;
        byte siete = 2;
        byte ocho = 3;

        respuestasLargas.add(uno);
        respuestasLargas.add(dos);
        respuestasLargas.add(tres);
        respuestasLargas.add(cuatro);
        respuestasLargas.add(cinco);

        respuestasCortas.add(seis);
        respuestasCortas.add(siete);
        respuestasCortas.add(ocho);

    }

    public void ingresarDatos() {
        mostrarPanelEncuesta();
        determinarRendered();
        ocultarEncuesta();
    }

    public boolean comprobarExistente() {
        switch (selectedItemAtraccion) {
            case "Ciclon":
                if (arbolPreguntaUno.existe(arbolPreguntaUno.getRaiz(), arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante()) == true) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El visitante " + arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getNombre() + " ya ha realizado la encuesta."));
                    return true;
                }

            case "Hulk":
                if (arbolPreguntaTres.existe(arbolPreguntaTres.getRaiz(), arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante()) == true) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El visitante " + arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getNombre() + " ya ha realizado la encuesta."));
                    return true;
                }
            case "Comida":
                if (arbolPreguntaCinco.existe(arbolPreguntaCinco.getRaiz(), arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante()) == true) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El visitante " + arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getNombre() + " ya ha realizado la encuesta."));
                    return true;
                }
        }
        return false;
    }

    public void determinarReporte() {
        switch (selectedItemAtraccionReporte) {
            case "Ciclon":
                renderedCiclonReporte = true;
                break;
            case "Hulk":
                renderedHulkReporte = true;
                break;
            default:
                renderedComidaReporte = true;
                break;
        }
    }

    public void consultarReporte() {
        atrEncontrada = asignarAtraccion(selectedItemAtraccionReporte);
        determinarReporte();
    }

    public String contarPregUnoCiclon() {
        int uno, dos, tres, cuatro, cinco;
        uno = arbolPreguntaUno.contar(arbolPreguntaUno.getRaiz(), 1);
        dos = arbolPreguntaUno.contar(arbolPreguntaUno.getRaiz(), 2);
        tres = arbolPreguntaUno.contar(arbolPreguntaUno.getRaiz(), 3);
        cuatro = arbolPreguntaUno.contar(arbolPreguntaUno.getRaiz(), 4);
        cinco = arbolPreguntaUno.contar(arbolPreguntaUno.getRaiz(), 5);
        return "Respondieron 1: " + uno
                + '\n' + "Respondieron 2: " + dos
                + '\n' + "Respondieron 3: " + tres
                + '\n' + "Respondieron 4: " + cuatro
                + '\n' + "Respondieron 5: " + cinco;
    }

    public String contarPregDosCiclon() {
        int uno, dos, tres;
        uno = arbolPreguntaDos.contar(arbolPreguntaDos.getRaiz(), 1);
        dos = arbolPreguntaDos.contar(arbolPreguntaDos.getRaiz(), 2);
        tres = arbolPreguntaDos.contar(arbolPreguntaDos.getRaiz(), 3);

        return "Respondieron 1: " + uno
                + '\n' + "Respondieron 2: " + dos
                + '\n' + "Respondieron 3: " + tres;
    }

    public String contarPregUnoHulk() {
        int uno, dos, tres, cuatro, cinco;
        uno = arbolPreguntaTres.contar(arbolPreguntaTres.getRaiz(), 1);
        dos = arbolPreguntaTres.contar(arbolPreguntaTres.getRaiz(), 2);
        tres = arbolPreguntaTres.contar(arbolPreguntaTres.getRaiz(), 3);
        cuatro = arbolPreguntaTres.contar(arbolPreguntaTres.getRaiz(), 4);
        cinco = arbolPreguntaTres.contar(arbolPreguntaTres.getRaiz(), 5);
        return "Respondieron 1: " + uno
                + '\n' + "Respondieron 2: " + dos
                + '\n' + "Respondieron 3: " + tres
                + '\n' + "Respondieron 4: " + cuatro
                + '\n' + "Respondieron 5: " + cinco;

    }

    public String contarPregDosHulk() {
        int uno, dos, tres;
        uno = arbolPreguntaCuatro.contar(arbolPreguntaCuatro.getRaiz(), 1);
        dos = arbolPreguntaCuatro.contar(arbolPreguntaCuatro.getRaiz(), 2);
        tres = arbolPreguntaCuatro.contar(arbolPreguntaCuatro.getRaiz(), 3);

        return "Respondieron 1: " + uno
                + '\n' + "Respondieron 2: " + dos
                + '\n' + "Respondieron 3: " + tres;
    }

    public String contarPregComida() {
        int uno, dos, tres, cuatro, cinco;
        uno = arbolPreguntaCinco.contar(arbolPreguntaCinco.getRaiz(), 1);
        dos = arbolPreguntaCinco.contar(arbolPreguntaCinco.getRaiz(), 2);
        tres = arbolPreguntaCinco.contar(arbolPreguntaCinco.getRaiz(), 3);
        cuatro = arbolPreguntaCinco.contar(arbolPreguntaCinco.getRaiz(), 4);
        cinco = arbolPreguntaCinco.contar(arbolPreguntaCinco.getRaiz(), 5);

        return "Respondieron 1: " + uno
                + '\n' + "Respondieron 2: " + dos
                + '\n' + "Respondieron 3: " + tres
                + '\n' + "Respondieron 4: " + cuatro
                + '\n' + "Respondieron 5: " + cinco;
    }

    public Atraccion asignarAtraccionReportes(String nombreAtraccion) {
        Atraccion atraccionTemp = null;
        for (Atraccion atraccionAux : listaAtracciones) {
            if (atraccionAux.getDescripcion().equals(nombreAtraccion)) {
                atraccionTemp = atraccionAux;
                break;
            }
        }
        return atraccionTemp;
    }

    public void responderPregunta() {

        if (comprobarExistente() == false) {

            Byte respuestaPreguntaUno;
            respuestaPreguntaUno = Byte.valueOf(respSelected);
            Byte respuestaPreguntaDos;
            respuestaPreguntaDos = Byte.valueOf(respSelectedDos);

            switch (selectedItemAtraccion) {
                case "Ciclon":

                    if (arbolPreguntaUno.getRaiz() == null) {
                        arbolPreguntaUno.setRaiz(new NodoRespuesta(new RespuestaVisitante(respuestaPreguntaUno, arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante())));
                    } else {
                        arbolPreguntaUno.insertarRecursivo(arbolPreguntaUno.getRaiz(), new NodoRespuesta(new RespuestaVisitante(respuestaPreguntaUno, arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante())));
                    }

                    if (arbolPreguntaDos.getRaiz() == null) {
                        arbolPreguntaDos.setRaiz(new NodoRespuesta(new RespuestaVisitante(respuestaPreguntaDos, arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante())));
                    } else {
                        arbolPreguntaDos.insertarRecursivo(arbolPreguntaDos.getRaiz(), new NodoRespuesta(new RespuestaVisitante(respuestaPreguntaDos, arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante())));
                    }

                    break;
                case "Hulk":
                    if (arbolPreguntaTres.getRaiz() == null) {
                        arbolPreguntaTres.setRaiz(new NodoRespuesta(new RespuestaVisitante(respuestaPreguntaUno, arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante())));
                    } else {
                        arbolPreguntaTres.insertarRecursivo(arbolPreguntaTres.getRaiz(), new NodoRespuesta(new RespuestaVisitante(respuestaPreguntaUno, arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante())));
                    }

                    if (arbolPreguntaCuatro.getRaiz() == null) {
                        arbolPreguntaCuatro.setRaiz(new NodoRespuesta(new RespuestaVisitante(respuestaPreguntaDos, arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante())));
                    } else {
                        arbolPreguntaCuatro.insertarRecursivo(arbolPreguntaCuatro.getRaiz(), new NodoRespuesta(new RespuestaVisitante(respuestaPreguntaDos, arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante())));
                    }
                    break;
                case ("Comida"):
                    if (arbolPreguntaCinco.getRaiz() == null) {
                        arbolPreguntaCinco.setRaiz(new NodoRespuesta(new RespuestaVisitante(respuestaPreguntaUno, arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante())));
                    } else {
                        arbolPreguntaCinco.insertarRecursivo(arbolPreguntaCinco.getRaiz(), new NodoRespuesta(new RespuestaVisitante(respuestaPreguntaUno, arbolVisitantes.buscarVisitante(arbolVisitantes.getRaiz(), buscarVisitante).getIdVisitante())));
                    }
                    break;
            }

            ocultarRendered();
            ocultarPanelEncuesta();
            ocultarEncuesta();

        }

        ocultarRendered();
        ocultarPanelEncuesta();
        ocultarEncuesta();

    }

    public resEncuesta realizarEncuesta() {
        resEncuesta encuestaNueva = new resEncuesta("CIC_001", determinarAtraccion()); //LA ENCUESTA QUE RESPONDE EL USUARIO
        switch (selectedItemAtraccion) {
            case "Ciclon":
                listaEncuestasCiclon.add(encuestaNueva);
                break;
            case "Hulk":
                listaEncuestasHulk.add(encuestaNueva);
                break;
            default:
                listaEncuestasComida.add(encuestaNueva);
                break;
        }
        return encuestaNueva;
    }

    public List<Pregunta> determinarAtraccion() {
        if (selectedItemAtraccion.equals("Ciclon")) {
            return listaPreguntasCiclon;
        } else if (selectedItemAtraccion.equals("Hulk")) {
            return listaPreguntasHulk;
        } else {
            return listaPreguntaComida;
        }

    }

    public void crearPreguntas() {

        preguntaCIC1 = new Pregunta("Cumplio sus expectativas?", respPregUno);
        preguntaCIC2 = new Pregunta("La recomendaria?", respPregDos);
        preguntaHUL1 = new Pregunta("Las sensaciones generaron impacto y adrenalina?", respPregTres);
        preguntaHUL2 = new Pregunta("Subiria de nuevo?", respPregCuatro);
        preguntaCOM = new Pregunta("Valorar por favor servicios de comida?", respPregCinco);

        listaPreguntasCiclon.add(preguntaCIC1);
        listaPreguntasCiclon.add(preguntaCIC2);
        listaPreguntasHulk.add(preguntaHUL1);
        listaPreguntasHulk.add(preguntaHUL2);
        listaPreguntaComida.add(preguntaCOM);
    }

    public void crearAtracciones() {
        Atraccion ciclon = new Atraccion("Ciclon", "1", encuestasCiclon);
        Atraccion hulk = new Atraccion("Hulk", "2", encuestasHulk);
        Atraccion comida = new Atraccion("Comida", "3", encuestasComida);
        listaAtracciones.add(ciclon);
        listaAtracciones.add(hulk);
        listaAtracciones.add(comida);
    }

    public Atraccion asignarAtraccion(String nombreAtraccion) {
        Atraccion atraccionTemp = null;
        for (Atraccion atraccionAux : listaAtracciones) {
            if (atraccionAux.getDescripcion().equals(nombreAtraccion)) {
                atraccionTemp = atraccionAux;
                break;
            }
        }
        return atraccionTemp;
    }

    ///////Fin de metodos de las encuestas y los reportes////////////////
    /////////////////////////////////////////////////////////////////////
    ///Metodos para los visitantes//////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
    public void crearPaises() {
        Pais alemania = new Pais("Alemania", "ALM");
        Pais argentina = new Pais("Argentina", "AGT");
        Pais brasil = new Pais("Brasil", "BRL");
        Pais colombia = new Pais("Colombia", "CLM");

        //Paises para asignarle a un visitante nuevo
        listaPaises.add(alemania);
        listaPaises.add(argentina);
        listaPaises.add(brasil);
        listaPaises.add(colombia);
    }

    public int peso() {
        tamanio = arbolVisitantes.peso(arbolVisitantes.getRaiz());

        return tamanio;
    }

    public void insertarVisitante() {
        //Borrar lista para evitar duplicados
        arrayVisitante.clear();

        //Crear objeto visitante
        Visitante objVis = new Visitante();

        //Asignar pais
        objVis.setPais(asignarPais(selectedItem));

        //Asignar ID
        String id = "";
        id = objVis.getPais().getNombreCorto() + Integer.toString(1 + buscarPais(arbolVisitantes.getRaiz(), objVis.getPais()));
        objVis.setIdVisitante(id);

        //Asignar nombre
        objVis.setNombre(objVisitante.getNombre());

        if (arbolVisitantes.getRaiz() == null) {
            arbolVisitantes.setRaiz(new NodoVisitante(objVis));

        } else {
            arbolVisitantes.insertarRecursivo(arbolVisitantes.getRaiz(), new NodoVisitante(objVis));

        }

        //Llenar lista para el dataTable
        arrayVisitante = arbolVisitantes.llenarLista(arbolVisitantes.getRaiz(), arrayVisitante);

        //Ordenar lista alfabeticamente
        ordenarVisitantes();

        //Ocultar panel de ingresar visitante
        verIngresar = false;
    }

    public Pais asignarPais(String nombrePais) {
        Pais paisTemp = null;
        for (Pais paisAux : listaPaises) {
            if (paisAux.getNombre().equals(nombrePais)) {
                paisTemp = paisAux;
                break;
            }
        }
        return paisTemp;
    }

    public int buscarPais(NodoVisitante nodoAux, Pais paisAux) {
        if (nodoAux != null) {
            if (nodoAux.getDatos().getPais() == paisAux) {
                return (1 + buscarPais(nodoAux.getIzquierda(), paisAux) + buscarPais(nodoAux.getDerecha(), paisAux));
            } else {
                return (0 + buscarPais(nodoAux.getIzquierda(), paisAux) + buscarPais(nodoAux.getDerecha(), paisAux));
            }
        } else {
            return 0;
        }

    }

    public void ordenarVisitantes() {
        List<String> listaNombres = new ArrayList<>();
        List<Visitante> listaVisTemp = new ArrayList<>();

        for (Visitante visAux : arrayVisitante) {
            listaNombres.add(visAux.getNombre());
        }

        Collections.sort(listaNombres);

        for (String nombreAux : listaNombres) {
            listaVisTemp.add(buscarObjeto(nombreAux));
        }

        arrayVisitante = listaVisTemp;
    }

    public Visitante buscarObjeto(String nombre) {
        Visitante visTemp = null;
        for (Visitante visAux : arrayVisitante) {
            if (visAux.getNombre().equals(nombre)) {
                visTemp = visAux;
                break;
            }
        }
        return visTemp;
    }

    ///////Fin de metodos de los visitates////////////////////
 

    public void verIngresar() {
        verIngresar = true;
    }

    public void ocultarIngresar() {
        verIngresar = false;
    }

    public void mostrarVisitantes() {
        verVisitantes = true;
    }

    public void ocultarVisitantes() {
        verVisitantes = false;
    }

    public void mostrarEncuesta() {
        verEncuestas = true;
    }

    public void ocultarEncuesta() {
        verEncuestas = false;
    }

    public void mostrarPanelEncuesta() {
        verPanelEncuestas = true;
    }

    public void ocultarPanelEncuesta() {
        verPanelEncuestas = false;
        ocultarRendered();
    }

    public void mostrarReportes() {
        verReporte = true;
    }

    public void ocultarReportes() {
        verReporte = false;
        renderedCiclonReporte = false;
        renderedHulkReporte = false;
        renderedComidaReporte = false;
    }
}
