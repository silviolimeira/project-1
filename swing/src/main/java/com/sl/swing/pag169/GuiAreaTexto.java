package com.sl.swing.pag169;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAreaTexto extends JPanel {

    private JTextField tfCampo;
    private JTextArea taTexto;
    private JScrollPane scrollPane;
    private JButton btLimpar;

    private final static String novaLinha = "\n";

    public GuiAreaTexto() {
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setLayout(null);
        tfCampo = new JTextField();
        //taTexto = new JTextArea(5,20);
        taTexto = new JTextArea("Teste", 5, 20);
        taTexto.setEditable(false);
        btLimpar = new JButton(new ImageIcon("borracha.png"));
        scrollPane = new JScrollPane(taTexto);
        tfCampo.setBounds(25,15,150,25);
        scrollPane.setBounds(25,45,300,120);
        btLimpar.setBounds(25,170,300,300);
        //taTexto.setBounds(25,30, 150,100);
        add(tfCampo);
        add(scrollPane);
        add(btLimpar);
    }

    public void definirEventos() {

        tfCampo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCampo.selectAll();
                String txt = tfCampo.getText() + novaLinha;
                taTexto.append(tfCampo.getText() + novaLinha);
                taTexto.setCaretPosition(taTexto.getDocument().getLength());
            }
        });

        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCampo.setText("");
                taTexto.setText("");
            }
        });
    }

}
