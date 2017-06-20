package com.fiuba.algoritmos;


public class ResultadoSubsetSum {
    private int exactSubsetSum;
    private int aproxSubsetSum;

    public ResultadoSubsetSum(int exact, int aprox) {
        this.exactSubsetSum = exact;
        this.aproxSubsetSum = aprox;
    }

    public int getExactSubsetSum() { return this.exactSubsetSum; }
    public int getAproxSubsetSum() { return this.aproxSubsetSum; }
}
