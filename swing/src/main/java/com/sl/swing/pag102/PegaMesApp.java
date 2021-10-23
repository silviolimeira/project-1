package com.sl.swing.pag102;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PegaMesApp {

    static class PegaMes {

        Date data;

        public PegaMes() { }

        public void pegaMes() {

            String aux = JOptionPane.showInputDialog(null, "Entre com uma data no formato (dd/mm/yyyy): ", "Entre com uma data", JOptionPane.INFORMATION_MESSAGE);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            try {
                data = sdf.parse(aux);
                String dataStr = sdf.format(data);
                Integer mes = Integer.parseInt(sdf.format(data).substring(3,5));
                JOptionPane.showMessageDialog(null, String.format("Data Fornecida: %s\nNúmero do mes: %d", sdf.format(data), mes), "Número do mês", JOptionPane.INFORMATION_MESSAGE);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        PegaMes pm = new PegaMes();
        pm.pegaMes();

    }

}
