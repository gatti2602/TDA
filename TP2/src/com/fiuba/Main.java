package com.fiuba;

import com.fiuba.algoritmos.BellmanFord;
import com.fiuba.algoritmos.Dijkstra;
import com.fiuba.algoritmos.FloydWarshall;
import com.fiuba.grafos.Digrafo;
import com.fiuba.grafos.GeneradorDeDigrafos;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("------------------------------------");
        System.out.println("\uD83D\uDE80 \uD83D\uDE80 TP1 Teoría de Algoritmos \uD83D\uDE80 \uD83D\uDE80");
        System.out.println("------------------------------------");
        System.out.println();
        System.out.println("Elige el número de vértices del digrafo completo:");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int numeroDeVertices = Integer.parseInt(scanner.nextLine());
        System.out.println();

        Random random = new Random();
        int origen = random.nextInt(numeroDeVertices) + 1;
        int destino = random.nextInt(numeroDeVertices) + 1;

        while (origen == destino) {
            destino = random.nextInt(numeroDeVertices) + 1;
        }

        Digrafo digrafo = GeneradorDeDigrafos.generarDigrafoCompleto(numeroDeVertices);

        System.out.println("Bellman Ford");
        System.out.println("------------");
        resolveBellmanFord(digrafo,origen, destino);
        System.out.println();

        System.out.println("Dijkstra");
        System.out.println("--------");
        resolveDijkstra(digrafo,origen, destino);
        System.out.println();

        System.out.println("Floyd Warshall");
        System.out.println("--------------");
        resolveFloydWarshall(digrafo,origen, destino);
        System.out.println();

        System.out.println();
        System.out.println("\uD83D\uDC7E \uD83D\uDC7E Fin! \uD83D\uDC7E \uD83D\uDC7E");
    }

    public static void resolveBellmanFord(Digrafo digrafo, int origen, int destino) {
        BellmanFord algoritmo = new BellmanFord(digrafo);

        long tiempoDeInicio = System.nanoTime();
        List<Integer> caminoMásCorto = algoritmo.getShortestPath(origen, destino);
        long tiempoDelAlgoritmo = System.nanoTime() - tiempoDeInicio;

        System.out.println(
            "BellmanFord con n=" + digrafo.cuentaDeVertices() +
            ". Tiempo de Ejecucion: " + TimeUnit.NANOSECONDS.toMillis(tiempoDelAlgoritmo) + " mSeg."
        );
    }

    public static void resolveDijkstra(Digrafo digrafo, int origen, int destino) {
        Dijkstra algoritmo = new Dijkstra(digrafo);

        long tiempoDeInicio = System.nanoTime();
        List<Integer> caminoMásCorto = algoritmo.getShortestPath(origen, destino);
        long tiempoDelAlgoritmo = System.nanoTime() - tiempoDeInicio;

        System.out.println(
            "Dijkstra con n=" + digrafo.cuentaDeVertices() +
            ". Tiempo de Ejecucion: " + TimeUnit.NANOSECONDS.toMillis(tiempoDelAlgoritmo) + " mSeg."
        );
    }

    public static void resolveFloydWarshall(Digrafo digrafo, int origen, int destino) {
        FloydWarshall algoritmo = new FloydWarshall(digrafo);

        long tiempoDeInicio = System.nanoTime();
        List<Integer> caminoMásCorto = algoritmo.getShortestPath(origen, destino);
        long tiempoDelAlgoritmo = System.nanoTime() - tiempoDeInicio;

        System.out.println(
            "FloydWarshall con n=" + digrafo.cuentaDeVertices() +
            ". Tiempo de Ejecucion: " + TimeUnit.NANOSECONDS.toMillis(tiempoDelAlgoritmo) + " mSeg."
        );
    }
}
