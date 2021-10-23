package com.sl.swing.pag169;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiDialogMessage extends JPanel {

    private ImageIcon imageIcon;
    private JComboBox cbCaixas;

    public GuiDialogMessage() {
        inicializarComponentes();
        definirEventos();
    }


    private void inicializarComponentes() {
        setLayout(null);
        imageIcon = new ImageIcon("imagem1.png");
        String[] cbCaixasItens = {"Pergunta", "Informação", "Alerta", "Erro", "definida pelo usuário", "Somente Mensagem"};
        cbCaixas = new JComboBox(cbCaixasItens);
        cbCaixas.setBounds(25, 40, 150, 25);
        add(cbCaixas);
    }


    private void definirEventos() {

        cbCaixas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (cbCaixas.getSelectedIndex()) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Estou aprendendo Java?",
                                "Pergunta", JOptionPane.QUESTION_MESSAGE);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Gravação Ok.",
                                "Informação", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Cuidado",
                                "Alerta", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Ocorreu algum erro",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Usando um gif animado",
                                "Personalizado", JOptionPane.INFORMATION_MESSAGE,
                                imageIcon);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Caixa de mensagem simples",
                                "Somente mensagem", JOptionPane.PLAIN_MESSAGE);
                        break;

                }

            }
        });

    }

}
