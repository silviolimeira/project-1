package com.sl.swing.pag169;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiRadio extends JPanel {

    private JLabel lbSexo;
    private JButton btVerificar;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup buttonGroup;

    public GuiRadio() {
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setLayout(null);
        btVerificar = new JButton("Verificar");
        rbMasculino = new JRadioButton("Masculino");
        lbSexo = new JLabel("Selecione o sexo:");
        rbFeminino = new JRadioButton("Feminino");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rbMasculino);
        buttonGroup.add(rbFeminino);
        btVerificar.setBounds(55,105,100,20);
        rbMasculino.setBounds(55,45,100,25);
        lbSexo.setBounds(55,10,100,25);
        rbFeminino.setBounds(55,70,100,25);
        rbMasculino.setSelected(true);
        add(btVerificar);
        add(rbMasculino);
        add(lbSexo);
        add(rbFeminino);
    }

    public void definirEventos() {
        btVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbMasculino.isSelected()) {
                    JOptionPane.showMessageDialog(null,"Masculino selecionado");
                } else if (rbFeminino.isSelected()) {
                    JOptionPane.showMessageDialog(null,"Feminino selecionado");
                }
            }
        });
    }

}
