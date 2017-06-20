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
        for (Integer i = 0; i < numeroDeVertices - 1; i++) {
            grafo.agregarArista(i.toString(), new Integer(i + 1).toString());
            numeroDeAristas--;
        }

        // Luego agregamos aristas de manera random
        // hasta llegar a las 2*n aristas
        Random random = new Random();
        while (numeroDeAristas > 0) {
            Integer nodoInicio = random.nextInt(numeroDeVertices);
            Integer nodoFin = random.nextInt(numeroDeVertices);
            grafo.agregarArista(nodoInicio.toString(), nodoFin.toString());
            numeroDeAristas--;
        }

        return grafo;
    }
}
