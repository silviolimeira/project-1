package com.sl.swing.pag169;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GuiLista extends JPanel {

    private JButton btCalcular;
    private JLabel lbValor;
    private JTextField tfValor, tfValorDesconto;
    private JList liDesconto;
    private JScrollPane spLista;

    public GuiLista() {
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setLayout(null);
        String[] liDescontoItems = {"10%", "20%", "30%", "40%", "50%"};
        btCalcular = new JButton("Calcular");
        lbValor = new JLabel("Valor");
        tfValor = new JTextField(5);
        liDesconto = new JList(liDescontoItems);
        tfValorDesconto = new JTextField(5);
        spLista = new JScrollPane(liDesconto);
        btCalcular.setToolTipText("Faz o cálculo");
        btCalcular.setMnemonic(KeyEvent.VK_C);
        lbValor.setBounds(35,05,100,25);
        tfValor.setBounds(35,30,100,25);
        spLista.setBounds(35,60,100,35);
        btCalcular.setBounds(35,120,90,25);
        tfValorDesconto.setBounds(35,150,100,25);
        add(btCalcular);
        add(lbValor);
        add(tfValor);
        add(spLista);
        add(tfValorDesconto);
    }

    public void definirEventos() {

        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfValor.getText().equals("")) {
                    tfValor.requestFocus();
                    return;
                }
                try {

                    float valor = Float.parseFloat(tfValor.getText());

                    if (liDesconto.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(null, "Selecione um item da lista", "Erro", JOptionPane.ERROR_MESSAGE);
                        spLista.requestFocus();
                    }

                    float desconto = 0.9f;
                    if (liDesconto.getSelectedIndex() == 1) {
                        desconto = 0.8f;
                    } else if (liDesconto.getSelectedIndex() == 2) {
                        desconto = 0.7f;
                    } else if (liDesconto.getSelectedIndex() == 3) {
                        desconto = 0.6f;
                    } else if (liDesconto.getSelectedIndex() == 4) {
                        desconto = 0.5f;
                    }
                    tfValorDesconto.setText(String.format("%.02f", valor * desconto));

                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Forneça apenas números", "Erro", JOptionPane.ERROR_MESSAGE);
                    tfValor.requestFocus();
                }
            }
        });

    }

}
