package com.fiuba.grafos;

/**
 * Created by gatti2602 on 09/04/17.
 * Arista Dirigida.
 * Contiene campos src y dst inmutables al crear la arista.
 */
public class Arista {

    private String inicio, fin;
    private int peso;

    Arista(String inicio, String fin, int peso) {
        this.inicio = inicio;
        this.fin = fin;
        this.peso = peso;
    }

    public String getInicio() {
        return this.inicio;
    }

    public String getFin() {
        return this.fin;
    }

    public Integer getPeso() {
        return this.peso;
    }
}
