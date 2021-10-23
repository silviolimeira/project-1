package com.sl.swing.pag102;

import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MediaApp {

    public static void main(String[] args) {
        MediaNotas mn = new MediaNotas();
        mn.media(4.5f, 4.5f);
        mn.media(3.0f, 3.0f, 2.0f);
        mn.media(8.0f, 8.0f, 8.0f, 8.0f);

    }

}

class Nota {
    Float nota;

    public Nota() {}

    public Nota(Float nota) {
        this.nota = nota;
    }

    public Float getNota() {
        return nota;
    }
}

class MediaNotas {

    List<Nota> notas;

    public MediaNotas() {
        notas = new ArrayList<>();
    }

    public void addNota(Float nota) {
        notas.add(new Nota(nota));
    }

    public Float[] getNotas() {

        Float[] list = notas.stream()
                .map(x -> x.getNota())
                .toArray(Float[]::new);

        return list;
    }

    public Float getTotal() {
        return Arrays.stream(getNotas()).reduce(0f, Float::sum);
    }

    public void calcMedia() {

        Float total = getTotal();
        Float media = getTotal() / notas.size();

        JOptionPane.showMessageDialog(null, String.format("Total: %.2f\nMédia: %.2f\nTotal de notas: %d", total, media, notas.size()), "Total", JOptionPane.INFORMATION_MESSAGE);

    }

    public void media(Float nota1, Float nota2) {

        MediaNotas mediaNotas = new MediaNotas();

        mediaNotas.addNota(nota1);
        mediaNotas.addNota(nota2);

        mediaNotas.calcMedia();

    }

    public void media(Float nota1, Float nota2, Float nota3) {

        MediaNotas mediaNotas = new MediaNotas();

        mediaNotas.addNota(nota1);
        mediaNotas.addNota(nota2);
        mediaNotas.addNota(nota3);

        mediaNotas.calcMedia();

    }

    public void media(Float nota1, Float nota2, Float nota3, Float nota4) {

        MediaNotas mediaNotas = new MediaNotas();

        mediaNotas.addNota(nota1);
        mediaNotas.addNota(nota2);
        mediaNotas.addNota(nota3);
        mediaNotas.addNota(nota4);

        mediaNotas.calcMedia();

    }



}
