package com.fiuba.galeShapley;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by marianovazquez on 5/30/17.
 */
public class Reductor {

    public static ArrayList<HashMap<Integer, ArrayList<Integer>>> generateEquivalents(HashMap<Integer, ArrayList<Integer>> preferenciasPretendientes, HashMap<Integer, ArrayList<Integer>> preferenciasOferentes, ArrayList<Integer> vacantesOferentes) {

        HashMap<Integer, ArrayList<Integer>> nuevasPreferenciasPretendientes = new HashMap<>(preferenciasPretendientes);
        HashMap<Integer, ArrayList<Integer>> nuevasPreferenciasOferentes = new HashMap<>(preferenciasOferentes);

        for (int i = 0; i < vacantesOferentes.size(); i++) {
            ArrayList<Integer> nuevasPreferenciasOferente = nuevasPreferenciasOferentes.get(i);
            int cantidadDeVacantes = vacantesOferentes.get(i);

            // Creo una copia de la preferencia de oferente por cada vacante (ej: 5 vacantes, 5 copias)
            for (int j = 0; j < cantidadDeVacantes - 1; j++) {
                int nuevoOferente = nuevasPreferenciasOferentes.size();
                nuevasPreferenciasOferentes.put(nuevoOferente, new ArrayList<>(nuevasPreferenciasOferente));

                // Luego, en cada lista de preferencias agrego este nuevo oferente junto al viejo
                final int idOferente = i;
                nuevasPreferenciasPretendientes.forEach((key, value) -> {
                    value.add(value.indexOf(idOferente) + 1, nuevoOferente);
                });
            }
        }

        // Chequeo si pretendientes < oferentes y creo pretendientes ficticios, si es el caso
        if (nuevasPreferenciasPretendientes.size() < nuevasPreferenciasOferentes.size()) {
            Reductor.agregarEntidadesFicticias(nuevasPreferenciasPretendientes, nuevasPreferenciasOferentes);
        }

        // Chequeo si pretendientes > oferentes y creo oferentes ficticios, si es el caso
        if (nuevasPreferenciasPretendientes.size() > nuevasPreferenciasOferentes.size()) {
            Reductor.agregarEntidadesFicticias(nuevasPreferenciasOferentes, nuevasPreferenciasPretendientes);
        }

        ArrayList<HashMap<Integer, ArrayList<Integer>>> result = new ArrayList<>();
        result.add(nuevasPreferenciasPretendientes);
        result.add(nuevasPreferenciasOferentes);
        return result;
    }

    private static void agregarEntidadesFicticias(HashMap<Integer, ArrayList<Integer>> coleccionMenor, HashMap<Integer, ArrayList<Integer>> coleccionMayor) {
        // Agrego tantas entidades ficticias como necesite
        int cantidadDeEntidadesFicticias = coleccionMayor.size() - coleccionMenor.size();

        for (int i = 0; i < cantidadDeEntidadesFicticias; i++) {
            int idEntidadFicticia = coleccionMenor.size();
            ArrayList<Integer> preferenciasPretendienteFicticio = new ArrayList<>(coleccionMenor.get(0));
            coleccionMenor.put(idEntidadFicticia, preferenciasPretendienteFicticio);

            // Le doy la menor prioridad a todas las entidades ficticias en la otra coleccion
            coleccionMayor.forEach((key, value) -> {
                value.add(idEntidadFicticia);
            });
        }
    }
}
