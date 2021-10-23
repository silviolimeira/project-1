package com.sl.swing.pag.oitenta.e.sete;

import javax.swing.*;
import java.util.*;

// Ref: https://howtodoinjava.com/java-8-tutorial/

public class SomaMaiorMenor {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<Integer>();
        Integer soma = 0;
        Integer maior = Integer.MIN_VALUE;
        Integer menor = Integer.MAX_VALUE;


        for (int i = 0; i < 10; i++) {

            String aux = JOptionPane.showInputDialog(null, String.format("Entre com o %d) numero de 10: ", i), "Entre com um número", JOptionPane.INFORMATION_MESSAGE);
            Integer numero = Integer.parseInt(aux);
            numeros.add(numero);
            soma += numero;

        }

        for (Integer numero : numeros) {
            if (numero > maior) maior = numero;
            if (numero < menor) menor = numero;
        }

        System.out.println("Quantidade de numeros: " + numeros.size());
        System.out.println(String.format("Soma dos numeros: %d", soma));
        System.out.println(String.format("Numero menor: %d", menor));
        System.out.println(String.format("Numero maior: %d", maior));



        /* Usando stream and comparator */
        /* ============================ */

        Comparator<Integer> numeroComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        };
        Optional<Integer> menorNumero = numeros.stream().min(numeroComparator);
        Optional<Integer> maiorNumero = numeros.stream().max(numeroComparator);
        // ref: https://www.baeldung.com/java-stream-reduce
        Integer somaNumeros = numeros.stream().reduce(0, Integer::sum);

        System.out.println(String.format("menorNumero menor: %d", menorNumero.get()));
        System.out.println(String.format("maiorNumero maior: %d", maiorNumero.get()));
        System.out.println(String.format("total: %d", somaNumeros));

        JOptionPane.showMessageDialog(null, String.format("Menor numero: %d\nMaior numero: %d\nSoma dos numeros: %d\n", menorNumero.get(), maiorNumero.get(), somaNumeros), "Menor, Maior e Soma dos Números", JOptionPane.INFORMATION_MESSAGE);
    }

}
