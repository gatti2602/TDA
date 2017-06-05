package com.fiuba.algoritmos;

import java.util.List;

/**
 * Created by marianovazquez on 6/4/17.
 */
public interface ShortestPathAlgorithm {

    /**
     * Devuelve el camino mínimo entre dos vértices del grafo.
     *
     * @param   src   el id del vértice de origen.
     * @param   dest  el id del vértice de destino.
     * @return  una lista con los vértices que conforman el camino, incluyendo
     *          el origen y el destino.
     * @throws IllegalArgumentException si algún id de vértice es inválido.
     */
    public List<Integer> getShortestPath(int src, int dest);

}
