package com.fiuba.grafos;

import java.util.Random;

/**
 * Created by marianovazquez on 6/4/17.
 */
public class GeneradorDeDigrafos {
    public static Digrafo generarDigrafoCompleto(int numeroDeVertices) {
        Digrafo digrafo = new Digrafo(numeroDeVertices);

        for (int origen = 0; origen < numeroDeVertices; origen++) {
            for (int destino = 0; destino < numeroDeVertices; destino++) {
                if (origen != destino) {
                    // Genero un peso random entre 1 y 100 para la arista
                    int peso = new Random().nextInt(100) + 1;
                    digrafo.agregarArista(origen, destino, peso);
                }
            }
        }

        return digrafo;
    }
}
