package com.sl.swing.pag.oitenta.e.sete;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ImprimePorSexo {

    enum Sexo {

        MASCULINO('M'), FEMININO('F');

        public char sexo;

        Sexo(char sexo) {
            this.sexo = sexo;
        }
    }

    public static void main(String[] args) {


        class Pessoa {

            public Pessoa() { }

            String nome;
            String sexo;

            @Override
            public String toString() {
                return "Pessoa{" +
                        "\tnome='" + nome + ',' +
                        "\tsexo=" + sexo +
                        "}";
            }
        }

//        Pessoa p = new Pessoa();
//        p.nome = "Silvio";
//        p.sexo = Sexo.MASCULINO;
//        System.out.println("Pessoa: " + p.toString());

        String[][] pessoas = new String[5][2];
        for (int i = 0; i < 5; i++) {
            Pessoa p = new Pessoa();
            p.nome = JOptionPane.showInputDialog(null, String.format("Entre com o nome da %d) pessoa de 5:", i), "Entre com o nome", JOptionPane.INFORMATION_MESSAGE);
            p.sexo = JOptionPane.showInputDialog(null, String.format("Entre com o sexo da %d) pessoa de 5:", i), "Entre com o nome", JOptionPane.INFORMATION_MESSAGE);
            pessoas[i][0] = p.nome;
            pessoas[i][1] = p.sexo;
        }

        String aux = JOptionPane.showInputDialog(null, "Listar as pessoas do sexo: ", "Listagem de pessoas por sexo", JOptionPane.INFORMATION_MESSAGE);

        for (int i = 0; i < 5; i++) {
            Pessoa p = new Pessoa();
            p.nome = pessoas[i][0];
            p.sexo = pessoas[i][1];
            if (p.sexo.equalsIgnoreCase(aux)) {
                System.out.println(p.toString());
            }
        }




    }
}
