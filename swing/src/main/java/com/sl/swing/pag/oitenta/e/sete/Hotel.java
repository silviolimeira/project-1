package com.sl.swing.pag.oitenta.e.sete;

import javax.swing.*;
import java.util.ArrayList;

public class Hotel {

    enum Situacao {

        OCUPADO(1), LIVRE(0), MANUTENCAO(3), LIMPEZA(2);

        public int situacao;

        Situacao(int situacao) {
            this.situacao = situacao;
        }
    }

    public static void main(String[] args) {

        final Integer ANDARES = 4;
        final Integer QUARTOS_POR_ANDAR = 10;

        class Apartamento {

            Integer numero;
            Situacao situacao;
            String nomeCliente;

            public Apartamento() { }

            public Apartamento(Integer numero, Situacao situacao, String nomeCliente) {
                this.numero = numero;
                this.situacao = situacao;
                this.nomeCliente = nomeCliente;
            }

            @Override
            public String toString() {
                return "Apartamento{" +
                        "numero=" + numero +
                        ", situacao=" + situacao +
                        ", nomeCliente='" + nomeCliente + '\'' +
                        '}';
            }
        }

        class Bloco {

            Apartamento[][] bloco;

            public Bloco() {
                bloco = new Apartamento[5][10];
                for (int y = 0; y < ANDARES; y++) {
                    for (int x = 0; x < QUARTOS_POR_ANDAR; x++) {
                        bloco[y][x] = new Apartamento(y * 100 + ((x + 1) * 10), Situacao.LIVRE, "John Doe");
                    }
                }
            }

            public void imprimirListaQuartos() {
                StringBuilder relatorio = new StringBuilder();
                for (int y = 0; y < ANDARES; y++) {
                    for (int x = 0; x < QUARTOS_POR_ANDAR; x++) {
                        bloco[y][x].toString();
                        relatorio.append(bloco[y][x].toString() + "\n");
                    }
                }
                JOptionPane.showMessageDialog(null, relatorio, "Lista de Quartos", JOptionPane.INFORMATION_MESSAGE);
            }

            public void definirOcupacao(Apartamento apartamento) {

                int y = apartamento.numero / 100;
                int x = apartamento.numero % 100 / 10 - 1;
                apartamento.situacao = Situacao.OCUPADO;
                bloco[y][x] = apartamento;

            }
        }

        Bloco bloco = new Bloco();

        String aux = "";
        do {
            aux = JOptionPane.showInputDialog(null, String.format("%s\n%s\n%s\nEntre com a opção: ",
                    "1 - Imprimir lista de quartos",
                    "2 - Definir Ocupacao",
                    "3 - Sair"), "Sistema de Controle de Reservas", JOptionPane.INFORMATION_MESSAGE);
            switch (aux) {
                case "1":
                    bloco.imprimirListaQuartos();
                    break;
                case "2":
                    Apartamento ap = new Apartamento();
                    ap.nomeCliente = JOptionPane.showInputDialog(null, "Entre com o nome do cliente: ", "Definir Ocupação", JOptionPane.INFORMATION_MESSAGE);
                    aux = JOptionPane.showInputDialog(null, "Entre com o número do apartamento: ", "Definir Ocupação", JOptionPane.INFORMATION_MESSAGE);
                    ap.numero = Integer.parseInt(aux);
                    bloco.definirOcupacao(ap);
                    break;
                case "3":
                    aux = JOptionPane.showInputDialog(null, "Deseja sair (digite sim):", "Deseja Sair", JOptionPane.INFORMATION_MESSAGE);
                    if (aux.equalsIgnoreCase("sim")) {
                        JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema de controle de reservas.");
                        System.exit(0);
                    }
                    break;
            }

        } while (aux != "3");

        System.exit(0);

    }

}
