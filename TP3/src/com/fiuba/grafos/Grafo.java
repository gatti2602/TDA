package com.fiuba.grafos;

import java.util.*;

/**
 * Grafo con las siguientes características:
 * - No dirigido
 * - No pesado
 * - Multigrafo (múltiples aristas paralelas)
 */
public class Grafo {

    /**
     * Cada elemento contiene la lista de arsitas del vertice
     * referenciado
     */
    private ArrayList<Arista> aristas;
    private int cantidadDeVertices;

    public Grafo(int vertices) {
        this.aristas = new ArrayList<>();
        this.cantidadDeVertices = vertices;
    }

    public Integer cantidadDeAristas() {
        return this.aristas.size();
    }


    public Integer cantidadDeVertices() {
        return cantidadDeVertices;
    }

    public List<Arista> getAristas() {
        return this.aristas;
    }

    /**
     * Devuelve una arista del grafo de manera aleatoria
     */
    public Arista getAristaAleatoria() {
        Integer numeroArista = new Random().nextInt(this.cantidadDeVertices);
        return this.aristas.get(numeroArista);
    }

    /**
     * Agrega una Arista al grafo.
     */
    public void agregarArista(String nodoInicio, String nodoFin) {
        Arista nuevaArista = new Arista(nodoInicio, nodoFin, 0);
        this.aristas.add(nuevaArista);
    }
}
