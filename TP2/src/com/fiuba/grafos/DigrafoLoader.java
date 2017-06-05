package com.fiuba.grafos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by marianovazquez on 6/4/17.
 */
public class DigrafoLoader {

    public static Digrafo loadDigrafo(String nombreDelGrafo) {
        String nombreArchivo = "data/" + nombreDelGrafo + ".txt";
        Path pathArchivo = Paths.get(nombreArchivo);
        Digrafo digrafo = null;

        try {
            List<String> lineas = Files.readAllLines(pathArchivo);
            int vertices = Integer.parseInt(lineas.get(0));
            int aristas = Integer.parseInt(lineas.get(1));
            digrafo = new Digrafo(vertices);

            for (int j = 0; j < aristas; j++) {
                String[] aristaInfo = lineas.get(j + 2).split("\\s+");
                digrafo.agregarArista(
                    Integer.parseInt(aristaInfo[0]),
                    Integer.parseInt(aristaInfo[1]),
                    Integer.parseInt(aristaInfo[2])
                );
            }
        } catch(IOException e) {
            System.out.println("Problema al leer el grafo " + nombreDelGrafo);
        }

        return digrafo;
    }
}
