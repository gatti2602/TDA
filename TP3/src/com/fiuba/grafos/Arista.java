package com.fiuba.grafos;

/**
 * Created by gatti2602 on 09/04/17.
 * Arista Dirigida.
 * Contiene campos src y dst inmutables al crear la arista.
 */
public class Arista {

    private Integer src, dst, peso;

    Arista(Integer src, Integer dst, Integer peso) {
        this.src = src;
        this.dst = dst;
        this.peso = peso;
    }

    public Integer getSrc() {
        return this.src;
    }

    public Integer getDst() {
        return this.dst;
    }

    public Integer getPeso() {
        return this.peso;
    }
}
