package com.sl.tool.ListaLigada;

public class Programa {

    public static void main(String[] args) {

        System.out.println("\n==============================================================\n");

        ListaLigada<String> lista = new ListaLigada<String>();
        lista.adicionar("AC");
        lista.adicionar("BA");
        lista.adicionar("CE");
        lista.adicionar("DF");

        System.out.println("Primeiro: " + lista.getPrimeiro().getValor());
        System.out.println("Ultimo: " + lista.getUltimo().getValor());

        System.out.println(lista.get(0).getValor());
        System.out.println(lista.get(1).getValor());
        System.out.println(lista.get(2).getValor());
        System.out.println(lista.get(3).getValor());

        // Remover elemento DF
        lista.remover("DF");
        System.out.println("Removeu estado DF");
        lista.adicionar("SP");
        System.out.println("Adicionou estado SP");

        lista.remover("AC");
        lista.remover("BA");
        lista.remover("CE");
        lista.remover("SP");

        System.out.println("Adicionou estado RJ");
        lista.adicionar("RJ");

        for (int i = 0; i < lista.getTamanho(); i++) {
            System.out.println(lista.get(i).getValor());
        }

        System.out.println("\n==============================================================");
        System.out.println("Tamanho: " + lista.getTamanho());
        System.out.println("============================================================-=\n");
    }
}
