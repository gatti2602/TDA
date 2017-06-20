package com.fiuba.algoritmos;

import com.fiuba.grafos.Arista;
import com.fiuba.grafos.Grafo;

import java.util.List;

public class Karger {

    /**
     * Aplica el Algoritmo de Karger para obtener el corte mínimo
     * en un grafo conectado con una mejor probabilidad de éxito.
     * - La cantidad de iteraciones de este método es de N = [n^2 * (n- 1)]/2
     */
    public List<Arista> getCorteMinimo(Grafo grafo) {
        int cantidadDeRepeticiones = this.getCantidadDeRepeticiones(grafo);
        List<Arista> corteMinimo = null;
        for (int i = 0; i < cantidadDeRepeticiones; i++) {
            List<Arista> nuevoCorteMinimo = this.adivinarCorteMinimo(grafo);

            if (corteMinimo == null || corteMinimo.size() > nuevoCorteMinimo.size()) {
                corteMinimo = nuevoCorteMinimo;
            }
        }
        return corteMinimo;
    }

    public List<Arista> adivinarCorteMinimo(Grafo grafo) {
        Grafo grafoActual = grafo;
        while (grafoActual.cantidadDeVertices() > 2) {
            // Obtengo una arista de manera aleatoria -> {u,v}
            Arista aristaAleatoria = grafo.getAristaAleatoria();

            // Creo un nuevo grafo G2 en base a las aristas del anterior
            // pero con los siguientes cambios:
            // - Un vértice menos --> v2 = v1 -1
            // - Eliminando las aristas que vayan de 'u' a 'v' -> {u,v}
            // - Reemplazando los ejes de la forma {u,w} o {v,w} en {uv, w}
            Grafo nuevoGrafo = new Grafo(grafoActual.cantidadDeVertices() - 1);
            String verticeUnificado = aristaAleatoria.getInicio() + aristaAleatoria.getFin();

            grafoActual.getAristas().forEach(arista -> {

                // Agrego las aristas que no tienen que ver con la nueva
                if (!aristaAleatoria.getInicio().equals(arista.getInicio())
                    && !aristaAleatoria.getInicio().equals(arista.getFin())
                    && !aristaAleatoria.getFin().equals(arista.getInicio())
                    && !aristaAleatoria.getFin().equals(arista.getFin())) {
                    nuevoGrafo.agregarArista(arista.getInicio(), arista.getFin());
                    return;
                }

                // Reemplazando los ejes de la forma {u,w} o {v,w} en {uv, w}
                if (arista.getInicio().equals(aristaAleatoria.getInicio()) || arista.getInicio().equals(aristaAleatoria.getFin())) {
                    nuevoGrafo.agregarArista(verticeUnificado, arista.getFin());
                    return;
                }

                // Reemplazando los ejes de la forma {w, u} o {w,v} en {w, uv}
                if (arista.getFin().equals(aristaAleatoria.getInicio()) || arista.getFin().equals(aristaAleatoria.getFin())) {
                    nuevoGrafo.agregarArista(arista.getInicio(), verticeUnificado);
                    return;
                }
            });

            grafoActual = nuevoGrafo;
        }
        return grafoActual.getAristas();
    }

    private int getCantidadDeRepeticiones(Grafo grafo) {
        double n = (double)grafo.cantidadDeVertices();
        return (int) Math.ceil((Math.pow(n, 2) * (n-(double)1)) / (double)2);
    }
}
