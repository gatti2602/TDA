package com.fiuba;

import com.fiuba.algoritmos.Karger;
import com.fiuba.algoritmos.ResultadoSubsetSum;
import com.fiuba.algoritmos.SubSetAprox;
import com.fiuba.grafos.Arista;
import com.fiuba.grafos.GeneradorDeGrafos;
import com.fiuba.grafos.Grafo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("------------------------------------");
        System.out.println("\uD83D\uDE80 \uD83D\uDE80 TP1 Teoría de Algoritmos \uD83D\uDE80 \uD83D\uDE80");
        System.out.println("------------------------------------");
        System.out.println();

        int algoritmoElegido = elegirAlgoritmo();
        System.out.println();

        switch (algoritmoElegido) {
            case 1:
                System.out.println("SubsetAprox");
                System.out.println("-----------");
                resolveSubsetAprox();
                break;
            default:
            case 2:
                System.out.println("Karger");
                System.out.println("------");
                resolveKarger();
                break;
        }

        System.out.println();
        System.out.println("\uD83D\uDC7E \uD83D\uDC7E Fin! \uD83D\uDC7E \uD83D\uDC7E");
    }

    public static int elegirAlgoritmo() {
        System.out.println("Elige el algoritmo a resolver");
        System.out.println();
        System.out.println("1. SubsetAprox");
        System.out.println("2. Karger");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void resolveSubsetAprox() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor de n:");
        System.out.println();
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println();

        System.out.println("Ingrese el valor de t:");
        System.out.println();
        int t = Integer.parseInt(scanner.nextLine());
        System.out.println();

        SubSetAprox algoritmo= new SubSetAprox();

        long tiempoDeInicio = System.nanoTime();
        ResultadoSubsetSum resultado = algoritmo.getResultadoSubset(n, t);
        long tiempoDelAlgoritmo = System.nanoTime() - tiempoDeInicio;

        System.out.println(
            "SubsetAprox con n=" + n + " y t=" + t +
            ". Resultado: (aprox) " + resultado.getAproxSubsetSum() + " (exacto) " + resultado.getExactSubsetSum() +
            ". Tiempo de Ejecucion: " + TimeUnit.NANOSECONDS.toMillis(tiempoDelAlgoritmo) + " mSeg."
        );
    }

    public static void resolveKarger() {
        System.out.println("Elige el número de vértices del grafo:");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int numeroDeVertices = Integer.parseInt(scanner.nextLine());
        System.out.println();

        Grafo grafo = GeneradorDeGrafos.generarMultigrafoConexo(numeroDeVertices);

        System.out.println("Generado un grafo con " + grafo.cantidadDeVertices() + " vertices y " + grafo.cantidadDeAristas() + " aristas.");
        System.out.println();

        Karger algoritmo = new Karger();

        long tiempoDeInicio = System.nanoTime();
        List<Arista> corteMinimo = algoritmo.getCorteMinimo(grafo);
        long tiempoDelAlgoritmo = System.nanoTime() - tiempoDeInicio;

        System.out.println(
            "Karger con n=" + grafo.cantidadDeVertices() +
            ". Resultado: " + Arrays.toString(corteMinimo.toArray()) +
            ". Tiempo de Ejecucion: " + TimeUnit.NANOSECONDS.toMillis(tiempoDelAlgoritmo) + " mSeg."
        );
    }
}
