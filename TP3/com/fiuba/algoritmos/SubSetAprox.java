package com.fiuba.algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class SubSetAprox {

    private int n;
    private int t;
    private ArrayList<Integer> S;
    private float e;
    private Random rand = new Random();

    private int exactSubsetSum;
    private int aproxSubsetSum;

    public ResultadoSubsetSum getResultadoSubset(int n, int t) {
        this.n = n;
        this.t = t;
        this.e=(float)0.40;

        // Genero el conjunto S
        this.S=this.genS(n);

        this.exactSubsetSum = this.exactSubsetSum(S, t);
        this.aproxSubsetSum = this.aproxSubsetSum(S, t, e);

        return new ResultadoSubsetSum(exactSubsetSum, aproxSubsetSum);
    }

    /*
     * Genera una lista aleatoria de enteros positivos sin duplicados
     */
    private  ArrayList<Integer> genS(int n){
        this.n=n;
        S= new ArrayList<>();
        while (S.size() < n) {
            int random = rand.nextInt(n+11);

            // Contains tiene complejidad O(n)
            if (!S.contains(random)) {
                S.add(random);

            }
        }

        return S;
    }

    /*
     *  Retorna una lista que será la union de l1 y l2 ordenandola
     *  y deshaciendose de duplicados.
     */
    private ArrayList mergeList(ArrayList<Integer> L1,ArrayList<Integer> L2 ){
        Collections.sort(L2);
        Collections.sort(L1);
        ArrayList<Integer> L1c=L1;
        L1c.removeAll(L2);
        L1c.addAll(L2);
        Collections.sort(L1c);
        return L1c;
    }

    /*
     * Suma un entero a cada elemento de una lista
     */
    public ArrayList<Integer> sumList(ArrayList<Integer> List, int a){
        ArrayList<Integer> sList=new ArrayList<>();
        for (int i = 0; i < List.size(); i++) {
            sList.add(List.get(i)+a);
        }
        return sList;
    }

    /*
     * Implementación del algoritmo exactSubsetSum del libro,
     * haciendo uso de mergelist y sumlist.
     */
    private int exactSubsetSum(ArrayList<Integer> S, int t){
        this.S=S;
        this.t=t;
        int n= S.size();

        String str="";
        ArrayList<ArrayList<Integer>> L;
        L=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> Laux=new ArrayList<Integer>();
        Laux.add(0);
        L.add(Laux);

        for (int i = 1; i <= n; i++) {

            L.add(mergeList(L.get(i-1), sumList(L.get(i-1), S.get(i-1))));
            Iterator<Integer> it = L.get(i-1).iterator();

            // Nos deshacemos de las sumas mayores a t
            while (it.hasNext()) {
                Integer integer = it.next();
                if (integer >t) {
                    it.remove();
                }
            }
        }

        return Collections.max(L.get(L.size()-1));
    }

    /*
     * Recorta la lista suministrada de acuerdo a un parametro de aproximación
     */
    private ArrayList<Integer> trimList(ArrayList<Integer> long_list, float p){

        int m=long_list.size();
        ArrayList<Integer> t_list= new ArrayList<Integer>();

        t_list.add(long_list.get(0));
        int last= long_list.get(0);
        for (int i = 2; i <= m; i++) {
            if(long_list.get(i-1)>=(last*(1+p))){
                t_list.add(long_list.get(i-1));
                last=long_list.get(i-1);
            }
        }
        return t_list;
    }

    /*
     * Realiza el mismo procedimiento de exactSubsetSum, pero implementa
     * la funcion trim que recorta la lista deacuerdo a un parametro de aproximación.
     */
    private int aproxSubsetSum(ArrayList<Integer> S, int t, float e){
        this.S=S;
        this.e=e;
        this.t=t;
        int n= S.size();

        ArrayList<ArrayList<Integer>> L;
        L=new ArrayList<>();
        ArrayList<Integer> Laux = new ArrayList<Integer>();
        Laux.add(0);
        L.add(Laux);

        for (int i = 1; i <= n; i++) {

            L.add(mergeList(L.get(i-1), sumList(L.get(i-1), S.get(i-1))));

            // Nos deshacemos de las sumas mayores a t
            Iterator<Integer> it = L.get(i-1).iterator();
            while (it.hasNext()) {
                Integer integer = it.next();
                if (integer >t) {
                    it.remove();
                }
            }

            L.set(i, trimList(L.get(i), e/(2*n)));
        }
        return Collections.max(L.get(L.size()-1));
    }

    private String arrToString(ArrayList<Integer> a){
        String str="";
        for (int i = 0; i <= a.size()-1; i++) {
            str+= a.get(i).toString() + " ";
        }
        return str;
    }
}