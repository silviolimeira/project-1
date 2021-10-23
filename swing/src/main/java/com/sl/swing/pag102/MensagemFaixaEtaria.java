package pag102;

import javax.swing.*;

public class MensagemFaixaEtaria {

    public static void main(String[] args) {

        FaixaEtaria fe = new FaixaEtaria();

        String aux = JOptionPane.showInputDialog(null, "Entre com a idade: ", "Retorna mensagem da faixa etaria", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, String.format("Sua é %d, pela sua idade você é considerado %s.",
                Integer.parseInt(aux),
                fe.mensagemFaixaEtaria(Integer.parseInt(aux))));

    }
}
