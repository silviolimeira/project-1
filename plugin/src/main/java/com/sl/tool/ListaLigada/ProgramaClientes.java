package com.sl.tool.ListaLigada;

import java.util.LinkedList;

public class ProgramaClientes {

    public static void main(String[] args) {

        ListaLigada<Cliente> clientes = new ListaLigada<>();

        Cliente c1 = new Cliente("123", "João");
        clientes.adicionar(c1);
        Cliente c2 = new Cliente("124", "Juca");
        clientes.adicionar(c2);
        Cliente c3 = new Cliente("125", "José");
        clientes.adicionar(c3);

        for (int i = 0; i < clientes.getTamanho(); i++) {
            System.out.println(clientes.get(i).getValor());
        }

        System.out.println("Removendo cliente Juca");
        clientes.remover(c2);

        for (int i = 0; i < clientes.getTamanho(); i++) {
            System.out.println(clientes.get(i).getValor());
        }

        System.out.println("Removendo cliente João");
        clientes.remover(c1);

        for (int i = 0; i < clientes.getTamanho(); i++) {
            System.out.println(clientes.get(i).getValor());
        }

        System.out.println("\n==============================================================");
        System.out.println("Tamanho: " + clientes.getTamanho());
        System.out.println("============================================================-=\n");

        // Lista ligada do Java
        LinkedList<Cliente> clientes2 = new LinkedList<>();

    }

}
