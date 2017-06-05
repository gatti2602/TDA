package com.fiuba.grafos;

import java.util.*;

/**
 * Created by gatti2602 on 09/04/17.
 * Implementa la clase Digrafo inmutable.
 * Representa los vertices como una entrada en la lista de adyacencia
 * Cada vertice se representa por una lista de Aristas. Los vertices empiezan en 0
 * El digrafo es no pesado.
 */
public class Digrafo {

    /**
     * Cada elemento contiene la lista de arsitas del vertice
     * referenciado
     */
    private ArrayList<HashMap<Integer, Arista>> adjList;
    private int cuentaAristas = 0;
    private int cuentaVertices;

    public Digrafo(int vertices) {
        this.adjList = new ArrayList<>(vertices);
        this.cuentaVertices = vertices;

        for (int i = 0; i < vertices; i++) {
            this.adjList.add(new HashMap<>());
        }
    }

    /**
     * Devuelve la cantidad de Vertices del Digrafo
     */
    public Integer cuentaDeVertices() {
        return cuentaVertices;
    }

    /**
     * Devuelve la cantidad de Aristas del Grafoo
     */
    public Integer cuentaDeAristas() {
        return cuentaAristas;
    }

    /**
     * Devuelve un iterador sobre la lista de adyacencia del vertice indicado.
     * Devuelve null si el vertice no existe
     */
    public Iterator<Arista> getAdjList(int vertice) {
        if (vertice >= adjList.size())
            return null;

        return adjList.get(vertice).values().iterator();

    }

    /**
     * Devuelve las aristas del grafo
     */
    public List<Arista> getAristas() {
        List<Arista> toReturn = new ArrayList<>();
        this.adjList.forEach(adjList -> toReturn.addAll(adjList.values()));

        return toReturn;
    }

    /**
     * Devuelve las aristas del grafo
     */
    public List<Arista> getAristas(int vertice) {
        return new ArrayList<Arista>(this.adjList.get(vertice).values());
    }



    /**
     * Agrega una Arista si el src esta dentro de los vertices del grafo y la arista no existe
     */
    public void agregarArista(int src, int dst, int peso) {

        if (src >= cuentaVertices || dst >= cuentaVertices)
            return;

        Arista previa = adjList.get(src).put(dst, new Arista(src, dst, peso));
        if (previa == null)
            cuentaAristas++;
    }
}
