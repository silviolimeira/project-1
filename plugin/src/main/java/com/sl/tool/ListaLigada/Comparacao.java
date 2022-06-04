package com.sl.tool.ListaLigada;

import java.util.ArrayList;

public class Comparacao {

    public static void main(String[] args) {

        ListaLigada<Integer> lista = new ListaLigada<>();

        ArrayList<Integer> vetor = new ArrayList<>();

        // Adicionar elementos
        int limite = 100000;
        long tempoInicial = System.currentTimeMillis();
        long tempoFinal;
        for (int i = 0; i < limite; i++) {
            vetor.add(i);
        }
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo de adição de elementos no vetor:");
        System.out.println(tempoFinal - tempoInicial);

        tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < limite; i++) {
            lista.adicionar(i);
        }
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo de adição de elementos na lista:");
        System.out.println(tempoFinal - tempoInicial);

        // Ler elementos
        tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < limite; i++) {
            vetor.get(i);
        }
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo de leitura de elementos no vetor:");
        System.out.println(tempoFinal - tempoInicial);

        tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < limite; i++) {
            lista.get(i);
        }
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo de leitura de elementos na lista:");
        System.out.println(tempoFinal - tempoInicial);

    }

}
