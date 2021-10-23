package com.sl.swing.pag169;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCombo extends JPanel {

    private JComboBox cbEstados;
    private JLabel lbEstados;
    private JButton btMostrar;

    public GuiCombo() {
        inicializaComponentes();
        definirEventos();
    }

    public void inicializaComponentes() {
        setLayout(null);
        String[] cbEstadosItems = {"Espirito Santo", "Minas Gerais", "Rio de Janeiro", "São Paulo"};
        cbEstados = new JComboBox(cbEstadosItems);
        lbEstados = new JLabel("Estados do sudeste");
        btMostrar = new JButton("Mostrar");
        add(lbEstados);
        add(cbEstados);
        add(btMostrar);
        lbEstados.setBounds(25,15,150,25);
        cbEstados.setBounds(25,40,150,25);
        btMostrar.setBounds(25,75,100,25);
    }

    public void definirEventos() {

        btMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Índice Selecionado: " + cbEstados.getSelectedIndex() +
                        "\nTexto Selecionado: " + cbEstados.getSelectedItem());
            }
        });

    }


}
