/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoSegundoCorte.controlador;

import ProyectoSegundoCorte.modelo.NodoEneario;
import ProyectoSegundoCorte.modelo.Pais;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author BROTHER
 */
@Named(value = "arbolEnearioControlador")
@SessionScoped
public class ArbolEnearioControlador implements Serializable {

    /**
     * Creates a new instance of ArbolEnearioControlador
     */
    public ArbolEnearioControlador() {
        llenarListaPaises();
        llenarListaCiudades();
        llenarListaAtracciones();
        llenarListaMeses();
        llenarArbolEneario();
        crearRespuestas();
    }

    //Crear arbol eneario
    private ArbolEneario miArbolEneario = new ArbolEneario();

    //Crear raiz arbol eneario
    NodoEneario raizEneario = new NodoEneario(new cDatos("000", "Diverti2"));

    //Crear paises
    cDatos alemania = new cDatos("001", "Alemania");
    cDatos argentina = new cDatos("002", "Argentina");
    cDatos brasil = new cDatos("003", "Brasil");
    List<cDatos> listaPaises = new ArrayList<>();

    //Crear ciudades
    cDatos dortmund = new cDatos("101", "Dortmund");
    cDatos munich = new cDatos("102", "Munich");
    cDatos buenosAires = new cDatos("103", "Buenos Aires");
    cDatos avellaneda = new cDatos("104", "Avellaneda");
    cDatos saopaulo = new cDatos("105", "Sao Paulo");
    cDatos rio = new cDatos("106", "Rio de Janeiro");
    List<cDatos> ciudadesAlemania = new ArrayList<>();
    List<cDatos> ciudadesArgentina = new ArrayList<>();
    List<cDatos> ciudadesBrasil = new ArrayList<>();

    //Crear atracciones
    cDatos apocalipsis = new cDatos("201", "Apocalipsis");
    cDatos barco = new cDatos("202", "Barco Pirata");
    cDatos carousel = new cDatos("203", "Carrousel");
    cDatos castillo = new cDatos("204", "Castillo del terror");
    cDatos centrox = new cDatos("205", "Centrox");
    cDatos ciclon = new cDatos("206", "Ciclon");
    cDatos hulk = new cDatos("207", "Hulk");
    cDatos karts = new cDatos("208", "Karts");
    cDatos martillo = new cDatos("209", "Martillo");
    cDatos montaña = new cDatos("210", "Montaña Rusa");
    cDatos octopus = new cDatos("211", "Octopus");
    cDatos supershot = new cDatos("212", "Supershot");
    List<cDatos> atraccionesDortmund = new ArrayList<>();
    List<cDatos> atraccionesMunich = new ArrayList<>();
    List<cDatos> atraccionesAvellaneda = new ArrayList<>();
    List<cDatos> atraccionesBuenosAires = new ArrayList<>();
    List<cDatos> atraccionesSaoPaulo = new ArrayList<>();
    List<cDatos> atraccionesRioJaneiro = new ArrayList<>();

    //Crear meses
    cDatos enero = new cDatos("01", "Enero");
    cDatos febrero = new cDatos("02", "Febrero");
    cDatos marzo = new cDatos("03", "Marzo");
    cDatos abril = new cDatos("04", "Abril");
    cDatos mayo = new cDatos("05", "Mayo");
    cDatos junio = new cDatos("06", "Junio");
    cDatos julio = new cDatos("07", "Julio");
    cDatos agosto = new cDatos("08", "Agosto");
    cDatos septiembre = new cDatos("09", "Septiembre");
    cDatos octubre = new cDatos("10", "Octubre");
    cDatos noviembre = new cDatos("11", "Noviembre");
    cDatos diciembre = new cDatos("12", "Diciembre");
    List<cDatos> listaMeses = new ArrayList<>();

    //Crear atributos para las operaciones
    private String paisSeleccionado = "";
    private String ciudadSeleccionada = "";
    private String atraccionSeleccionada = "";
    private String visitanteSeleccionado = "";
    private String mesSeleccionado = "";
    List<cDatos> listaCiudades = new ArrayList<>();
    private cDatos visitanteNuevo = new cDatos();
    List<cDatos> listaVisitantes = new ArrayList<>();
    List<cDatos> listaAtracciones = new ArrayList<>();
    private boolean renderedEncuesta = false;
    private List<cDatos> respuestas = new ArrayList<>();
    private String respuestaVisitante1 = "";
    private String respuestaVisitante2 = "";
    private String respuestaVisitante3 = "";
    private String respuestaVisitante4 = "";
    private String respuestaVisitante5 = "";
    private int contador = 1;
    private boolean renderedVisitantes = false;
    private boolean renderedDataTable = false;

    //Getters & Setters

    public String getRespuestaVisitante1() {
        return respuestaVisitante1;
    }

    public void setRespuestaVisitante1(String respuestaVisitante1) {
        this.respuestaVisitante1 = respuestaVisitante1;
    }

    public String getRespuestaVisitante2() {
        return respuestaVisitante2;
    }

    public void setRespuestaVisitante2(String respuestaVisitante2) {
        this.respuestaVisitante2 = respuestaVisitante2;
    }

    public String getRespuestaVisitante3() {
        return respuestaVisitante3;
    }

    public void setRespuestaVisitante3(String respuestaVisitante3) {
        this.respuestaVisitante3 = respuestaVisitante3;
    }

    public String getRespuestaVisitante4() {
        return respuestaVisitante4;
    }

    public void setRespuestaVisitante4(String respuestaVisitante4) {
        this.respuestaVisitante4 = respuestaVisitante4;
    }

    public String getRespuestaVisitante5() {
        return respuestaVisitante5;
    }

    public void setRespuestaVisitante5(String respuestaVisitante5) {
        this.respuestaVisitante5 = respuestaVisitante5;
    }

    
    
    public boolean isRenderedDataTable() {
        return renderedDataTable;
    }

    public void setRenderedDataTable(boolean renderedDataTable) {
        this.renderedDataTable = renderedDataTable;
    }
    
    public boolean isRenderedVisitantes() {
        return renderedVisitantes;
    }

    public void setRenderedVisitantes(boolean renderedVisitantes) {
        this.renderedVisitantes = renderedVisitantes;
    }
    
    
    public List<cDatos> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<cDatos> respuestas) {
        this.respuestas = respuestas;
    }

    public String getVisitanteSeleccionado() {
        return visitanteSeleccionado;
    }

    public void setVisitanteSeleccionado(String visitanteSeleccionado) {
        this.visitanteSeleccionado = visitanteSeleccionado;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean isRenderedEncuesta() {
        return renderedEncuesta;
    }

    public void setRenderedEncuesta(boolean renderedEncuesta) {
        this.renderedEncuesta = renderedEncuesta;
    }

    public List<cDatos> getAtraccionesDortmund() {
        return atraccionesDortmund;
    }

    public void setAtraccionesDortmund(List<cDatos> atraccionesDortmund) {
        this.atraccionesDortmund = atraccionesDortmund;
    }

    public List<cDatos> getAtraccionesMunich() {
        return atraccionesMunich;
    }

    public void setAtraccionesMunich(List<cDatos> atraccionesMunich) {
        this.atraccionesMunich = atraccionesMunich;
    }

    public List<cDatos> getAtraccionesAvellaneda() {
        return atraccionesAvellaneda;
    }

    public void setAtraccionesAvellaneda(List<cDatos> atraccionesAvellaneda) {
        this.atraccionesAvellaneda = atraccionesAvellaneda;
    }

    public List<cDatos> getAtraccionesBuenosAires() {
        return atraccionesBuenosAires;
    }

    public void setAtraccionesBuenosAires(List<cDatos> atraccionesBuenosAires) {
        this.atraccionesBuenosAires = atraccionesBuenosAires;
    }

    public List<cDatos> getAtraccionesSaoPaulo() {
        return atraccionesSaoPaulo;
    }

    public void setAtraccionesSaoPaulo(List<cDatos> atraccionesSaoPaulo) {
        this.atraccionesSaoPaulo = atraccionesSaoPaulo;
    }

    public List<cDatos> getAtraccionesRioJaneiro() {
        return atraccionesRioJaneiro;
    }

    public void setAtraccionesRioJaneiro(List<cDatos> atraccionesRioJaneiro) {
        this.atraccionesRioJaneiro = atraccionesRioJaneiro;
    }

    public List<cDatos> getListaVisitantes() {
        return listaVisitantes;
    }

    public void setListaVisitantes(List<cDatos> listaVisitantes) {
        this.listaVisitantes = listaVisitantes;
    }

    public cDatos getVisitanteNuevo() {
        return visitanteNuevo;
    }

    public void setVisitanteNuevo(cDatos visitanteNuevo) {
        this.visitanteNuevo = visitanteNuevo;
    }

    public List<cDatos> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<cDatos> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public String getPaisSeleccionado() {
        return paisSeleccionado;
    }

    public void setPaisSeleccionado(String paisSeleccionado) {
        this.paisSeleccionado = paisSeleccionado;
    }

    public String getCiudadSeleccionada() {
        return ciudadSeleccionada;
    }

    public void setCiudadSeleccionada(String ciudadSeleccionada) {
        this.ciudadSeleccionada = ciudadSeleccionada;
    }

    public String getAtraccionSeleccionada() {
        return atraccionSeleccionada;
    }

    public void setAtraccionSeleccionada(String atraccionSeleccionada) {
        this.atraccionSeleccionada = atraccionSeleccionada;
    }

    public List<cDatos> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(List<cDatos> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public List<cDatos> getCiudadesAlemania() {
        return ciudadesAlemania;
    }

    public void setCiudadesAlemania(List<cDatos> ciudadesAlemania) {
        this.ciudadesAlemania = ciudadesAlemania;
    }

    public List<cDatos> getCiudadesArgentina() {
        return ciudadesArgentina;
    }

    public void setCiudadesArgentina(List<cDatos> ciudadesArgentina) {
        this.ciudadesArgentina = ciudadesArgentina;
    }

    public List<cDatos> getCiudadesBrasil() {
        return ciudadesBrasil;
    }

    public void setCiudadesBrasil(List<cDatos> ciudadesBrasil) {
        this.ciudadesBrasil = ciudadesBrasil;
    }

    public List<cDatos> getListaAtracciones() {
        return listaAtracciones;
    }

    public void setListaAtracciones(List<cDatos> listaAtracciones) {
        this.listaAtracciones = listaAtracciones;
    }

    public cDatos getApocalipsis() {
        return apocalipsis;
    }

    public void setApocalipsis(cDatos apocalipsis) {
        this.apocalipsis = apocalipsis;
    }

    public cDatos getBarco() {
        return barco;
    }

    public void setBarco(cDatos barco) {
        this.barco = barco;
    }

    public cDatos getCarousel() {
        return carousel;
    }

    public void setCarousel(cDatos carousel) {
        this.carousel = carousel;
    }

    public cDatos getCastillo() {
        return castillo;
    }

    public void setCastillo(cDatos castillo) {
        this.castillo = castillo;
    }

    public cDatos getCentrox() {
        return centrox;
    }

    public void setCentrox(cDatos centrox) {
        this.centrox = centrox;
    }

    public cDatos getCiclon() {
        return ciclon;
    }

    public void setCiclon(cDatos ciclon) {
        this.ciclon = ciclon;
    }

    public cDatos getHulk() {
        return hulk;
    }

    public void setHulk(cDatos hulk) {
        this.hulk = hulk;
    }

    public cDatos getKarts() {
        return karts;
    }

    public void setKarts(cDatos karts) {
        this.karts = karts;
    }

    public cDatos getMartillo() {
        return martillo;
    }

    public void setMartillo(cDatos martillo) {
        this.martillo = martillo;
    }

    public cDatos getMontaña() {
        return montaña;
    }

    public void setMontaña(cDatos montaña) {
        this.montaña = montaña;
    }

    public cDatos getOctopus() {
        return octopus;
    }

    public void setOctopus(cDatos octopus) {
        this.octopus = octopus;
    }

    public cDatos getSupershot() {
        return supershot;
    }

    public void setSupershot(cDatos supershot) {
        this.supershot = supershot;
    }

    public List<cDatos> getListaMeses() {
        return listaMeses;
    }

    public void setListaMeses(List<cDatos> listaMeses) {
        this.listaMeses = listaMeses;
    }

    public String getMesSeleccionado() {
        return mesSeleccionado;
    }

    public void setMesSeleccionado(String mesSeleccionado) {
        this.mesSeleccionado = mesSeleccionado;
    }

    public ArbolEneario getMiArbolEneario() {
        return miArbolEneario;
    }

    public void setMiArbolEneario(ArbolEneario miArbolEneario) {
        this.miArbolEneario = miArbolEneario;
    }

    public NodoEneario getRaizEneario() {
        return raizEneario;
    }

    public void setRaizEneario(NodoEneario raizEneario) {
        this.raizEneario = raizEneario;
    }

    public cDatos getAlemania() {
        return alemania;
    }

    public void setAlemania(cDatos alemania) {
        this.alemania = alemania;
    }

    public cDatos getArgentina() {
        return argentina;
    }

    public void setArgentina(cDatos argentina) {
        this.argentina = argentina;
    }

    public cDatos getBrasil() {
        return brasil;
    }

    public void setBrasil(cDatos brasil) {
        this.brasil = brasil;
    }

    public cDatos getEnero() {
        return enero;
    }

    public void setEnero(cDatos enero) {
        this.enero = enero;
    }

    public cDatos getFebrero() {
        return febrero;
    }

    public void setFebrero(cDatos febrero) {
        this.febrero = febrero;
    }

    public cDatos getMarzo() {
        return marzo;
    }

    public void setMarzo(cDatos marzo) {
        this.marzo = marzo;
    }

    public cDatos getAbril() {
        return abril;
    }

    public void setAbril(cDatos abril) {
        this.abril = abril;
    }

    public cDatos getMayo() {
        return mayo;
    }

    public void setMayo(cDatos mayo) {
        this.mayo = mayo;
    }

    public cDatos getJunio() {
        return junio;
    }

    public void setJunio(cDatos junio) {
        this.junio = junio;
    }

    public cDatos getJulio() {
        return julio;
    }

    public void setJulio(cDatos julio) {
        this.julio = julio;
    }

    public cDatos getAgosto() {
        return agosto;
    }

    public void setAgosto(cDatos agosto) {
        this.agosto = agosto;
    }

    public cDatos getSeptiembre() {
        return septiembre;
    }

    public void setSeptiembre(cDatos septiembre) {
        this.septiembre = septiembre;
    }

    public cDatos getOctubre() {
        return octubre;
    }

    public void setOctubre(cDatos octubre) {
        this.octubre = octubre;
    }

    public cDatos getNoviembre() {
        return noviembre;
    }

    public void setNoviembre(cDatos noviembre) {
        this.noviembre = noviembre;
    }

    public cDatos getDiciembre() {
        return diciembre;
    }

    public void setDiciembre(cDatos diciembre) {
        this.diciembre = diciembre;
    }

    public cDatos getDortmund() {
        return dortmund;
    }

    public void setDortmund(cDatos dortmund) {
        this.dortmund = dortmund;
    }

    public cDatos getMunich() {
        return munich;
    }

    public void setMunich(cDatos munich) {
        this.munich = munich;
    }

    public cDatos getBuenosAires() {
        return buenosAires;
    }

    public void setBuenosAires(cDatos buenosAires) {
        this.buenosAires = buenosAires;
    }

    public cDatos getAvellaneda() {
        return avellaneda;
    }

    public void setAvellaneda(cDatos avellaneda) {
        this.avellaneda = avellaneda;
    }

    public cDatos getSaopaulo() {
        return saopaulo;
    }

    public void setSaopaulo(cDatos saopaulo) {
        this.saopaulo = saopaulo;
    }

    public cDatos getRio() {
        return rio;
    }

    public void setRio(cDatos rio) {
        this.rio = rio;
    }

    public void llenarArbolEneario() {
        //Crear raiz (nivel 0)
        miArbolEneario.setRaiz(raizEneario);

        //Crear paises (nivel 1)
        crearPaisesEneario();

        //Crear ciudades (nivel 2)
        crearCiudadesEneario();

        //Crear atracciones (nivel 3)
        crearAtraccionesEneario();
    }

    public void crearPaisesEneario() {
        miArbolEneario.insertarNodo("000", alemania);
        miArbolEneario.insertarNodo("000", argentina);
        miArbolEneario.insertarNodo("000", brasil);
    }

    public void crearCiudadesEneario() {
        miArbolEneario.insertarNodo("001", dortmund);
        miArbolEneario.insertarNodo("001", munich);
        miArbolEneario.insertarNodo("002", avellaneda);
        miArbolEneario.insertarNodo("002", buenosAires);
        miArbolEneario.insertarNodo("003", rio);
        miArbolEneario.insertarNodo("003", saopaulo);
    }

    public void crearAtraccionesEneario() {
        miArbolEneario.insertarNodo("101", apocalipsis);
        miArbolEneario.insertarNodo("101", barco);
        miArbolEneario.insertarNodo("102", carousel);
        miArbolEneario.insertarNodo("102", castillo);
        miArbolEneario.insertarNodo("103", centrox);
        miArbolEneario.insertarNodo("103", ciclon);
        miArbolEneario.insertarNodo("104", hulk);
        miArbolEneario.insertarNodo("104", karts);
        miArbolEneario.insertarNodo("105", martillo);
        miArbolEneario.insertarNodo("105", montaña);
        miArbolEneario.insertarNodo("106", octopus);
        miArbolEneario.insertarNodo("106", supershot);

    }

    public void llenarListaPaises() {
        listaPaises.add(alemania);
        listaPaises.add(argentina);
        listaPaises.add(brasil);
    }

    public void llenarListaCiudades() {
        ciudadesAlemania.add(dortmund);
        ciudadesAlemania.add(munich);
        ciudadesArgentina.add(avellaneda);
        ciudadesArgentina.add(buenosAires);
        ciudadesBrasil.add(saopaulo);
        ciudadesBrasil.add(rio);
    }

    public void llenarListaAtracciones() {
        atraccionesDortmund.add(apocalipsis);
        atraccionesDortmund.add(barco);
        atraccionesMunich.add(carousel);
        atraccionesMunich.add(castillo);
        atraccionesBuenosAires.add(centrox);
        atraccionesBuenosAires.add(ciclon);
        atraccionesAvellaneda.add(hulk);
        atraccionesAvellaneda.add(karts);
        atraccionesSaoPaulo.add(martillo);
        atraccionesSaoPaulo.add(montaña);
        atraccionesRioJaneiro.add(octopus);
        atraccionesRioJaneiro.add(supershot);
    }

    public void llenarListaMeses() {
        listaMeses.add(enero);
        listaMeses.add(febrero);
        listaMeses.add(marzo);
        listaMeses.add(abril);
        listaMeses.add(mayo);
        listaMeses.add(junio);
        listaMeses.add(julio);
        listaMeses.add(agosto);
        listaMeses.add(septiembre);
        listaMeses.add(octubre);
        listaMeses.add(noviembre);
        listaMeses.add(diciembre);
    }

    public void recorrerArbol() {
        miArbolEneario.recorrerArbol(miArbolEneario.getRaiz());
//        System.out.println(miArbolEneario.getRaiz().toString());
    }

    public cDatos buscarMes(String mes) {
        cDatos mesTemp = null;
        for (cDatos mesAux : listaMeses) {
            if (mesAux.getDescripcion().equals(mes)) {
                mesTemp = mesAux;
                break;
            }
        }
        return mesTemp;
    }

    public cDatos buscarVisitante(String visitante) {
        cDatos visitanteTemp = null;
        for (cDatos visitanteAux : listaVisitantes) {
            if (visitanteAux.getDescripcion().equals(visitante)) {
                visitanteTemp = visitanteAux;
                break;
            }
        }
        return visitanteTemp;
    }

    public cDatos buscarPais(String pais) {
        cDatos paisTemp = null;
        for (cDatos paisAux : listaPaises) {
            if (paisAux.getDescripcion().equals(pais)) {
                paisTemp = paisAux;
                break;
            }
        }
        return paisTemp;
    }

    public cDatos buscarAtraccion(String atraccion) {
        cDatos atraccionTemp = null;
        for (cDatos atraccionAux : listaAtracciones) {
            if (atraccionAux.getDescripcion().equals(atraccion)) {
                atraccionTemp = atraccionAux;
                break;
            }
        }
        return atraccionTemp;
    }
    
       public cDatos buscarRespuesta(String respuesta) {
        cDatos respuestaTemp = null;
        for (cDatos respuestaAux : respuestas) {
            if (respuestaAux.getDescripcion().equals(respuesta)) {
                respuestaTemp = respuestaAux;
                break;
            }
        }
        return respuestaTemp;
    }

    public void determinarCiudad() {

        if (paisSeleccionado.equals("Alemania")) {
            listaCiudades = ciudadesAlemania;
        } else if (paisSeleccionado.equals("Argentina")) {
            listaCiudades = ciudadesArgentina;
        } else if (paisSeleccionado.equals("Brasil")) {
            listaCiudades = ciudadesBrasil;
        }

    }

    public void determinarAtraccion() {
        if (ciudadSeleccionada.equals("Dortmund")) {
            listaAtracciones = atraccionesDortmund;
        } else if (ciudadSeleccionada.equals("Munich")) {
            listaAtracciones = atraccionesMunich;
        } else if (ciudadSeleccionada.equals("Buenos Aires")) {
            listaAtracciones = atraccionesBuenosAires;
        } else if (ciudadSeleccionada.equals("Avellaneda")) {
            listaAtracciones = atraccionesAvellaneda;
        } else if (ciudadSeleccionada.equals("Sao Paulo")) {
            listaAtracciones = atraccionesSaoPaulo;
        } else if (ciudadSeleccionada.equals("Rio de Janeiro")) {
            listaAtracciones = atraccionesRioJaneiro;
        }
    }

    public void ingresarMes() {
        //Insertar mes en el arbol
        miArbolEneario.insertarNodo(buscarAtraccion(atraccionSeleccionada).getId(), buscarMes(mesSeleccionado));
    }

    public void ingresarVisitante() {
        //Crear objeto visitante
        cDatos objVisitante = new cDatos();

        //Asignar ID
        objVisitante.setId("" + contador);
        contador++;

        //Asignar nombre
        objVisitante.setDescripcion(visitanteNuevo.getDescripcion());

        //Ingresar visitante en el arbol
        miArbolEneario.insertarNodo(buscarMes(mesSeleccionado).getId(), objVisitante);

        //Llenar lista para el dataTable
        listaVisitantes.add(objVisitante);

        //Ordenar lista de visitantes alfabeticamente
        ordenarVisitantes();
        
        //Ocultar panel de visitantes
        ocultarVisitantes();

    }

    public void ordenarVisitantes() {
        List<String> listaNombres = new ArrayList<>();
        List<cDatos> listaVisTemp = new ArrayList<>();

        for (cDatos visAux : listaVisitantes) {
            listaNombres.add(visAux.getDescripcion());
        }

        Collections.sort(listaNombres);

        for (String nombreAux : listaNombres) {
            listaVisTemp.add(buscarObjeto(nombreAux));
        }

        listaVisitantes = listaVisTemp;
    }

    public cDatos buscarObjeto(String nombre) {
        cDatos visTemp = null;
        for (cDatos visAux : listaVisitantes) {
            if (visAux.getDescripcion().equals(nombre)) {
                visTemp = visAux;
                break;
            }
        }
        return visTemp;
    }

    public void crearRespuestas() {
        cDatos uno = new cDatos("", "1");
        cDatos dos = new cDatos("", "2");
        cDatos tres = new cDatos("", "3");
        cDatos cuatro = new cDatos("", "4");
        cDatos cinco = new cDatos("", "5");
        respuestas.add(uno);
        respuestas.add(dos);
        respuestas.add(tres);
        respuestas.add(cuatro);
        respuestas.add(cinco);

    }

    public void responderPregunta() {
        miArbolEneario.insertarNodo(buscarVisitante(visitanteSeleccionado).getId(), buscarRespuesta(respuestaVisitante1));
        miArbolEneario.insertarNodo(buscarVisitante(visitanteSeleccionado).getId(), buscarRespuesta(respuestaVisitante2));
        miArbolEneario.insertarNodo(buscarVisitante(visitanteSeleccionado).getId(), buscarRespuesta(respuestaVisitante3));
        miArbolEneario.insertarNodo(buscarVisitante(visitanteSeleccionado).getId(), buscarRespuesta(respuestaVisitante4));
        miArbolEneario.insertarNodo(buscarVisitante(visitanteSeleccionado).getId(), buscarRespuesta(respuestaVisitante5));
        ocultarEncuesta();
        vaciarCampos();
    }
    
    public void vaciarCampos(){
        paisSeleccionado = "";
        ciudadSeleccionada = "";
        atraccionSeleccionada = "";
        mesSeleccionado = "";
        visitanteSeleccionado = "";
        respuestaVisitante1 = "";
        respuestaVisitante2 = "";
        respuestaVisitante3 = "";
        respuestaVisitante4 = "";
        respuestaVisitante5 = "";
    }

    public void mostrarEncuesta() {
        renderedEncuesta = true;
    }

    public void ocultarEncuesta() {
        renderedEncuesta = false;
    }
    
    public void mostrarVisitantes(){
        renderedVisitantes = true;
    }
    
    public void ocultarVisitantes(){
        renderedVisitantes = false;
    }
    
     public void mostrarDataTable(){
        renderedDataTable = true;
    }
    
    public void ocultarDataTable(){
        renderedDataTable = false;
    }

}
