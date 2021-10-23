package com.sl.swing.pag169;

import javax.swing.*;
import java.awt.event.*;

public class GuiBotao extends JPanel {

    private JButton btMensagem, btTeimoso;
    private ImageIcon imageIcon;

    public GuiBotao() {
        inicializarComponents();
        definirEventos();
    }

    public void inicializarComponents() {
        setLayout(null);
        imageIcon = new ImageIcon("java.png");
        btMensagem = new JButton("Mensagem", imageIcon);
        btMensagem.setBounds(50,20,140, 38);
        btMensagem.setMnemonic(KeyEvent.VK_M);
        btMensagem.setToolTipText("Clique aqui para ver a mensagem");
        btTeimoso = new JButton("Teimoso");
        btTeimoso.setBounds(50,70,100,25);
        add(btMensagem);
        add(btTeimoso);
    }

    public void definirEventos() {

        btMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Botão Mensagem", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        btTeimoso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão teimoso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btTeimoso.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btTeimoso.setBounds(50,120,100,25);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btTeimoso.setBounds(50,70,100,25);
            }
        });
    }




}
