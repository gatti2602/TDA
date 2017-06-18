package com.fiuba;

import com.fiuba.algoritmos.Karger;
import com.fiuba.grafos.GeneradorDeGrafos;
import com.fiuba.grafos.Grafo;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("------------------------------------");
        System.out.println("\uD83D\uDE80 \uD83D\uDE80 TP1 Teoría de Algoritmos \uD83D\uDE80 \uD83D\uDE80");
        System.out.println("------------------------------------");
        System.out.println();
        System.out.println("Elige el número de vértices del grafo:");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int numeroDeVertices = Integer.parseInt(scanner.nextLine());
        System.out.println();

        Grafo grafo = GeneradorDeGrafos.generarMultigrafoConexo(numeroDeVertices);

        System.out.println("Generado un grafo con " + grafo.cantidadDeVertices() + " vertices y " + grafo.cantidadDeAristas() + " aristas.");
        System.out.println();

        System.out.println("Karger");
        System.out.println("------");
        resolveKarger(grafo);
        System.out.println();

        System.out.println();
        System.out.println("\uD83D\uDC7E \uD83D\uDC7E Fin! \uD83D\uDC7E \uD83D\uDC7E");
    }

    public static void resolveKarger(Grafo grafo) {
        Karger algoritmo = new Karger();

        long tiempoDeInicio = System.nanoTime();
        algoritmo.getCorteMinimo(grafo);
        long tiempoDelAlgoritmo = System.nanoTime() - tiempoDeInicio;

        System.out.println(
            "Karger con n=" + grafo.cantidadDeVertices() +
            ". Tiempo de Ejecucion: " + TimeUnit.NANOSECONDS.toMillis(tiempoDelAlgoritmo) + " mSeg."
        );
    }
}
