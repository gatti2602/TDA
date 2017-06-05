package com.fiuba.galeShapley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by lt5420 on 22/04/2017.
 */
public class Randomizer {
    public static ArrayList<Integer> CreateRandomVector(Integer m, Integer randMin, Integer randMax){
        Random r = new Random();
        ArrayList<Integer> aux = new ArrayList<>(m);
        int min = randMin != null ? randMin : 0;
        int max = randMax != null ? randMax : Integer.MAX_VALUE;

        for (int j=0;j<m;j++) {
            int randomValue = r.nextInt(max + 1 - min) + min;
            aux.add(randomValue);
        }
        return aux;
    }

    public static HashMap<Integer,ArrayList<Integer>> CreateRandomUniqueMatrix(Integer n, Integer m){
        HashMap<Integer, ArrayList<Integer>> matrix = new HashMap<>(n);
        for (int i=0; i<n;i++)
            matrix.put(i,Randomizer.CreateRandomUniqueVector(m));
        return matrix;
    }

    public static ArrayList<Integer> CreateRandomUniqueVector(Integer n){
        ArrayList<Integer> aux = new ArrayList<>();
        for(int i=0; i<n;i++)
            aux.add(i);
        Collections.shuffle(aux);
        return aux;
    }
}


