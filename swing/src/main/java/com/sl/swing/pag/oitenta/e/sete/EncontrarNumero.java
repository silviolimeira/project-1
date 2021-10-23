package com.sl.swing.pag.oitenta.e.sete;

import javax.swing.*;
import java.util.Arrays;

public class EncontrarNumero {

    public static void main(String[] args) {

        int numeros[][] = new int[20][50];

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 50; y++) {
                Integer numeroAleatorio = (int) ((Math.random() * (1000 - 0)) + 1);
                numeros[x][y] = numeroAleatorio;
            }
        }

        String aux = JOptionPane.showInputDialog(null, String.format("Entre com o número: "), "Entre com um número para localizar", JOptionPane.INFORMATION_MESSAGE);
        final int num = Integer.parseInt(aux);
        boolean sair = false;
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 50; y++) {
                if (numeros[x][y] == num) {
                    JOptionPane.showMessageDialog(null, String.format("O número foi encontrado na posicao[%d][%d]: ", x, y), "Número encontrado", JOptionPane.INFORMATION_MESSAGE);
                    sair = true;
                    break;
                }
                if (sair == true) break;
                System.out.println(String.format("[%d][%d]=%d,", x, y, numeros[x][y]));
            }
        }

        System.exit(0);


    }

}
