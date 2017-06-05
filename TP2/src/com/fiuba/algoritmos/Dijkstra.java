package com.fiuba.algoritmos;

import com.fiuba.grafos.Arista;
import com.fiuba.grafos.Digrafo;

import java.util.*;

/**
 * Created by marianovazquez on 6/4/17.
 */
public class Dijkstra implements ShortestPathAlgorithm {

    private Digrafo digrafo;

    public Dijkstra(Digrafo digrafo) {
        this.digrafo = digrafo;
    }

    /**
     * Aplica el algoritmo de Dijkstra para obtener el camino mínimo entre dos
     * vértices del grafo.
     *
     * @param   src   el id del vértice de origen.
     * @param   dest  el id del vértice de destino.
     * @return  una lista con los vértices que conforman el camino, incluyendo
     *          el origen y el destino.
     * @throws IllegalArgumentException si algún id de vértice es inválido.
     */
    @Override
    public List<Integer> getShortestPath(int src, int dest) {
        PriorityQueue<Integer> colaDePrioridad = new PriorityQueue<>();
        Map<Integer, Integer> distancias = new HashMap<>();
        Map<Integer, Integer> padres = new HashMap<>();

        for (int i = 0; i < this.digrafo.cuentaDeVertices(); i++) {
            distancias.put(i, 999999999);
            padres.put(i, null);
        }

        distancias.put(src, 0);
        colaDePrioridad.add(src);

        while (!colaDePrioridad.isEmpty()) {
            int vertice = colaDePrioridad.poll();
            Iterator<Arista> aristas = this.digrafo.getAdjList(vertice);

            while (aristas.hasNext()) {
                Arista arista = aristas.next();
                int origen = arista.getSrc();
                int destino = arista.getDst();

                if (distancias.get(origen) + arista.getPeso() < distancias.get(destino)) {
                    distancias.put(destino, distancias.get(origen) + arista.getPeso());
                    padres.put(destino, origen);
                    colaDePrioridad.remove(origen);
                    colaDePrioridad.add(destino);
                }
            }
        }

        return this.getCaminoMasCorto(dest, padres);
    }

    private int getNodoConMinimaDistancia(Set<Integer> nodosNoVisitados, Map<Integer, Integer> distancias) {
        Integer nodoMinimo = null;

        for (int nodoNoVisitado : nodosNoVisitados) {
            if (nodoMinimo == null) {
                nodoMinimo = nodoNoVisitado;
            } else {
                if (distancias.get(nodoNoVisitado) < distancias.get(nodoMinimo)) {
                    nodoMinimo = nodoNoVisitado;
                }
            }
        }

        return nodoMinimo;
    }

    private List<Integer> getCaminoMasCorto(int dest, Map<Integer, Integer> padres) {
        List<Integer> toReturn = new ArrayList<Integer>();
        Integer current = dest;

        while (current != null) {
            toReturn.add(current);
            current = padres.get(current);
        }

        Collections.reverse(toReturn);
        return toReturn;
    }
}
