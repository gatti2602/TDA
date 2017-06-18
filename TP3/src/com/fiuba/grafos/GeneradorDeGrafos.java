package com.fiuba.grafos;

import java.util.Random;

public class GeneradorDeGrafos {

    /*
     * Dados un parámetros n genere un grafo conexo no dirigido de n vértices y 2n aristas.
     */
    public static Grafo generarMultigrafoConexo(int numeroDeVertices) {
        Grafo grafo = new Grafo(numeroDeVertices);
        int numeroDeAristas = 2 * numeroDeVertices;

        // Primero convertimos el grafo en conexo
        // (existe un camino entre cualquier par de nodos)
        // (conecto a todos los vértices entre si)
        for (int i = 0; i < numeroDeVertices - 1; i++) {
            grafo.agregarArista(i, i + 1);
            numeroDeAristas--;
        }

        // Luego agregamos aristas de manera random
        // hasta llegar a las 2*n aristas
        Random random = new Random();
        while (numeroDeAristas > 0) {
            int nodoInicio = random.nextInt(numeroDeVertices);
            int nodoFin = random.nextInt(numeroDeVertices);
            grafo.agregarArista(nodoInicio, nodoFin);
            numeroDeAristas--;
        }

        return grafo;
    }
}
