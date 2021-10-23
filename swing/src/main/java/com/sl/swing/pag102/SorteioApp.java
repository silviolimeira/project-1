package pag102;

import javax.swing.*;

public class SorteioApp {

    public static void main(String[] args) {

        Sorteio s = new Sorteio();
        JOptionPane.showMessageDialog(null, String.format("Janeiro - Item sorteado: %s", s.sorteio()), "Sorteio ", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, String.format("Fevereiro - Item sorteado: %s", s.sorteio()), "Sorteio ", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, String.format("Março - Item sorteado: %s", s.sorteio()), "Sorteio ", JOptionPane.INFORMATION_MESSAGE);

    }

}

class Sorteio {

    String[] brindes = { "Torradeira", "Frigideira", "Kit Churrasco", "Kit Confeitaria", "Kit hortifruti"};

    public Sorteio() { }

    public String sorteio() {
        int itemSorteado = (int) ((Math.random() * (brindes.length - 0)) + 0);
        return brindes[itemSorteado];
    }

}

