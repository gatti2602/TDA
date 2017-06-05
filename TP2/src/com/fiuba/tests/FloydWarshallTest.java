package com.fiuba.tests;

import com.fiuba.algoritmos.FloydWarshall;
import com.fiuba.grafos.Digrafo;
import com.fiuba.grafos.DigrafoLoader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by marianovazquez on 6/4/17.
 */
public class FloydWarshallTest {

    @Test
    public void getShortestPath_d1() {
        Digrafo digrafo = DigrafoLoader.loadDigrafo("d1");
        FloydWarshall algoritmo = new FloydWarshall(digrafo);

        List<Integer> result1 = algoritmo.getShortestPath(0, 1);
        List<Integer> expected1 = new ArrayList<Integer>(Arrays.asList(0, 1));
        assertEquals(expected1, result1);

        List<Integer> result2 = algoritmo.getShortestPath(0, 2);
        List<Integer> expected2 = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        assertEquals(expected2, result2);

        List<Integer> result3 = algoritmo.getShortestPath(1, 0);
        List<Integer> expected3 = new ArrayList<Integer>(Arrays.asList(1, 2, 0));
        assertEquals(expected3, result3);
    }

    @Test
    public void getShortestPath_d2() {
        Digrafo digrafo = DigrafoLoader.loadDigrafo("d2");
        FloydWarshall algoritmo = new FloydWarshall(digrafo);

        List<Integer> result1 = algoritmo.getShortestPath(0, 1);
        List<Integer> expected1 = new ArrayList<Integer>(Arrays.asList(0, 1));
        assertEquals(expected1, result1);

        List<Integer> result2 = algoritmo.getShortestPath(0, 2);
        List<Integer> expected2 = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        assertEquals(expected2, result2);

        List<Integer> result3 = algoritmo.getShortestPath(2, 3);
        List<Integer> expected3 = new ArrayList<Integer>(Arrays.asList(2, 1, 0, 3));
        assertEquals(expected3, result3);
    }
}