package com.fiuba.algoritmos;

import com.fiuba.grafos.Digrafo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marianovazquez on 6/4/17.
 */
public class FloydWarshall implements ShortestPathAlgorithm {

    private Digrafo digrafo;

    public FloydWarshall(Digrafo digrafo) {
        this.digrafo = digrafo;
    }

    @Override
    public List<Integer> getShortestPath(int src, int dest) {
        double[][] distancias = new double[this.digrafo.cuentaDeVertices()][this.digrafo.cuentaDeVertices()];
        Integer[][] siguientes = new Integer[this.digrafo.cuentaDeVertices()][this.digrafo.cuentaDeVertices()];

        for (int i = 0; i < this.digrafo.cuentaDeVertices(); i++) {
            for (int j = 0; j < this.digrafo.cuentaDeVertices(); j++) {
                distancias[i][j] = i == j ? 0 : 999999999;
                siguientes[i][j] = null;
            }
        }

        this.digrafo.getAristas().forEach(arista -> {
            int origen = arista.getSrc();
            int destino = arista.getDst();

            distancias[origen][destino] = arista.getPeso();
            siguientes[origen][destino] = destino;
        });

        for (int k = 0; k < this.digrafo.cuentaDeVertices(); k++) {
            for (int i = 0; i < this.digrafo.cuentaDeVertices(); i++) {
                for (int j = 0; j < this.digrafo.cuentaDeVertices(); j++) {
                    if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        siguientes[i][j] = siguientes[i][k];
                    }
                }
            }
        }

        return this.getCaminoMasCorto(src, dest, siguientes);
    }

    private List<Integer> getCaminoMasCorto(int src, int dest, Integer[][] siguientes) {
        ArrayList<Integer> toReturn = new ArrayList<>();

        if (siguientes[src][dest] == null) {
            return toReturn;
        }

        int current = src;
        toReturn.add(current);

        while (current != dest) {
            current = siguientes[current][dest];
            toReturn.add(current);
        }

        return toReturn;
    }
}

