package com.fiuba.algoritmos;

import com.fiuba.grafos.Arista;
import com.fiuba.grafos.Digrafo;

import java.util.*;

/**
 * Created by marianovazquez on 6/4/17.
 */
public class BellmanFord implements ShortestPathAlgorithm {

    private Digrafo digrafo;

    public BellmanFord(Digrafo digrafo) {
        this.digrafo = digrafo;
    }

    /**
     * Aplica el algoritmo de BellmanFord para obtener el camino mínimo entre dos
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
        Map<Integer, Integer> distancias = new HashMap<>();
        Map<Integer, Integer> padres = new HashMap<>();

        for (int i = 0; i < this.digrafo.cuentaDeVertices(); i++) {
            distancias.put(i, 999999999);
            padres.put(i, null);
        }

        distancias.put(src, 0);

        for (int i = 0; i < this.digrafo.cuentaDeVertices() - 1; i++) {
            this.digrafo.getAristas().forEach(arista -> {
                int origen = arista.getSrc();
                int destino = arista.getDst();

                if (distancias.get(origen) + arista.getPeso() < distancias.get(destino)) {
                    distancias.put(destino, distancias.get(origen) + arista.getPeso());
                    padres.put(destino, origen);
                }
            });
        }

        // Chequeamos que no haya ciclos negativos
        boolean tieneCiclosNegativos = false;
        this.digrafo.getAristas().forEach(arista -> {
            int origen = arista.getSrc();
            int destino = arista.getDst();

            if (distancias.get(origen) + arista.getPeso() < distancias.get(destino)) {
                System.out.print("El grafo contiene ciclos negativos");
            }
        });

        if (tieneCiclosNegativos) {
            return new ArrayList<>();
        }

        return this.getCaminoMasCorto(src, dest, padres);
    }

    private List<Integer> getCaminoMasCorto(int src, int dest, Map<Integer, Integer> padres) {
        List<Integer> toReturn = new ArrayList<Integer>();
        Integer current = dest;

        while (current != null && !toReturn.contains(current)) {
            toReturn.add(current);
            current = padres.get(current);
        }

        Collections.reverse(toReturn);
        return toReturn;
    }
}
