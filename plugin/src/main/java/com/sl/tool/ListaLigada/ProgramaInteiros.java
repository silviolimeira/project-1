package com.sl.tool.ListaLigada;

public class ProgramaInteiros {

    public static void main(String[] args) {

        System.out.println("\n==============================================================");

        ListaLigada<Integer> numeros = new ListaLigada<Integer>();

        numeros.adicionar(3);
        numeros.adicionar(4);
        numeros.adicionar(5);

        for (int i = 0; i < numeros.getTamanho(); i++) {
            System.out.println(numeros.get(i).getValor());
        }

        System.out.println("Removendo 4");
        numeros.remover(4);

        for (int i = 0; i < numeros.getTamanho(); i++) {
            System.out.println(numeros.get(i).getValor());
        }

        System.out.println("Removendo 3");
        numeros.remover(3);

        for (int i = 0; i < numeros.getTamanho(); i++) {
            System.out.println(numeros.get(i).getValor());
        }

        System.out.println("Removendo 5");
        numeros.remover(5);

        for (int i = 0; i < numeros.getTamanho(); i++) {
            System.out.println(numeros.get(i).getValor());
        }

        System.out.println("\n==============================================================");
        System.out.println("Tamanho: " + numeros.getTamanho());
        System.out.println("============================================================-=\n");


    }

}
