package com.sl.swing.pag102;

import javax.swing.*;

public class BuscasApp {

    public static void main(String[] args) {

        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        String[] palavras = {"um", "dois", "três", "sexo", "cinco", "seis"};

        Buscas buscas = new Buscas();
        int numero = 10;
        if (buscas.buscaNumero(numero, numeros)) {
            JOptionPane.showMessageDialog(null, String.format("Número %d encontrado.", numero), "Número encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, String.format("Número %d não encontrado.", numero), "Número encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
        numero = 13;
        if (buscas.buscaNumero(numero, numeros)) {
            JOptionPane.showMessageDialog(null, String.format("Número %d encontrado.", numero), "Número encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, String.format("Número %d não encontrado.", numero), "Número encontrado", JOptionPane.INFORMATION_MESSAGE);
        }

        // busca palavra
        JOptionPane.showMessageDialog(null, String.format("%s a palavra foi encontrada.", buscas.buscaPalavra(palavras)), "Palavra encontrada.", JOptionPane.INFORMATION_MESSAGE);


    }

}

class Buscas {

    public Buscas() { }

    boolean buscaNumero(int numero, int[] vetor) {
        for (int num : vetor) {
            if (numero == num) return true;
        }
        return false;
    }

    String buscaPalavra(String[] palavras) {

        for (String s : palavras) {
            if (s.equalsIgnoreCase("sexo")) return "SIM";
        }
        return "NÃO";
    }

}
