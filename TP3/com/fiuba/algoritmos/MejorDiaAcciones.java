package com.fiuba.algoritmos;

/**
 * Created by Nico on 19/6/2017.
 */
public class MejorDiaAcciones {

    private int diaCompra = 0;
    private int diaVenta = 0;
    private int montoGanancia = 0;

    public MejorDiaAcciones(int[] valorDia) {

        int posibleDiaCompraFuturo = 0;
        if (valorDia.length < 1) {
            throw new InvalidParameterException("Longitud de Dias debe ser mayor a 0");
        }
        //Bucle FOR ejecuta n iteraciones, las operaciones internas son todas O(1) => Bucle es O(n)
        for (int i = 0; i < valorDia.length; i++) {
            if (valorDia[i] < valorDia[posibleDiaCompraFuturo]) { //Como el valor es menor al posible candidato a canjear, este se vuelve un mejor candidato y lo reemplaza.
                posibleDiaCompraFuturo = i;
            } else { //Si gano valor de venta o si el candidato me hace mejorar la ganancia entonces conmuto los dias
                if (valorDia[i] > valorDia[diaVenta] || ganancia(posibleDiaCompraFuturo, i, valorDia) > montoGanancia) {
                    diaCompra = posibleDiaCompraFuturo;
                    diaVenta = i;
                    montoGanancia = valorDia[diaVenta] - valorDia[diaCompra];
                }
            }
        }
    }

    private int ganancia(int diaCompra, int diaVenta, int[] valorDia) {
        return valorDia[diaVenta] - valorDia[diaCompra];
    }

    public int getDiaCompra() {
        return diaCompra;
    }

    public int getDiaVenta() {
        return diaVenta;
    }

    public int getMontoGanancia() {
        return montoGanancia;
    }
}
