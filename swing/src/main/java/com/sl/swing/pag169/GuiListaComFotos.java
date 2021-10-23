package com.sl.swing.pag169;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GuiListaComFotos extends JPanel {

    private JList lsFotos;
    private DefaultListModel dlm;
    private ImageIcon imageIcon;
    private JScrollPane sp;
    private JLabel lbImagem;


    public GuiListaComFotos() {
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setLayout(null);
        dlm = new DefaultListModel();
        for (int i = 1; i <=2; i++) {
            dlm.addElement("Imagem" + i);
        }
        lsFotos = new JList(dlm);
        sp = new JScrollPane(lsFotos);
        sp.setBounds(50,40,70,150);
        imageIcon = new ImageIcon();
        lbImagem = new JLabel(imageIcon);
        lbImagem.setBounds(150,30,180,180);
        add(sp);
        add(lbImagem);
    }

    public void definirEventos() {

        lsFotos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                imageIcon = new ImageIcon(String.format("%s.png",lsFotos.getSelectedValue()));
                lbImagem.setIcon(imageIcon);
            }
        });

    }

}
