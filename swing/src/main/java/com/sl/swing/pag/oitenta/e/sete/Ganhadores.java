package com.sl.swing.pag.oitenta.e.sete;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Ganhadores {

    public static void processaGanhadores(String[] nomes, Integer[] ganhadores) {

        Integer i = 0;
        while (i < ganhadores.length) {
            Integer ganhador = (int) ((Math.random() * (nomes.length - 0)) + 0);
            if (Arrays.stream(ganhadores).anyMatch(ganhador::equals)) {
                continue;
            }
            ganhadores[i++] = ganhador;
        }

    }


    public static void main(String[] args) {

        System.out.println("Ganhador");

        //String[] nomes = {"um", "dois", "tres", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez"};
        String[] nomes = new String[10];
        for (int i = 0; i < 10; i++) {
            nomes[i] = JOptionPane.showInputDialog(String.format("Forneca o %d) nome: ", i));
        }

        Integer ganhadores[] = new Integer[2];
        processaGanhadores(nomes, ganhadores);
        Integer indice = 0;
        for (Integer x : ganhadores) {
            System.out.println(String.format("%d) Ganhador: %s", ++indice, nomes[x]));
        }

    }

}
