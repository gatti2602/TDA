package com.fiuba.algoritmos;

/**
 * Created by Nico on 19/6/2017.
 */
public class InvalidParameterException extends RuntimeException {

    private String razon;

    InvalidParameterException(String razon) {
        super();
        this.razon = razon;
    }
}

