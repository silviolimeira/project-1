package com.sl.swing.pag169;

import javax.swing.*;
import java.awt.*;

public class GuiLabel extends JPanel {

    private JLabel label1, label2, label3, label4;
    private ImageIcon imageIcon;

    public GuiLabel() {
        inicilizarComponentes();
    }

    public void inicilizarComponentes() {
        setLayout(new GridLayout(4,1));
        imageIcon = new ImageIcon("java.png");
        setBackground(new Color(100,200,100));
        label1 = new JLabel("   Aprendendo", JLabel.LEFT);
        label1.setForeground(Color.white);
        label2 = new JLabel(imageIcon);
        label3 = new JLabel("Inserir   ", JLabel.RIGHT);
        label3.setForeground(Color.blue);
        label4 = new JLabel("Label e imagens", imageIcon, JLabel.CENTER);
        label4.setFont(new Font("Serif", Font.BOLD, 20));
        label4.setForeground(Color.black);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
    }

}
