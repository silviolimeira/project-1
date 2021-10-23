package com.sl.swing.pag169;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiMenuPrincipal extends JFrame {

    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnExemplos;
    private JMenuItem miSair, miBotao, miCaixaOpcao, miRadio, miLabel, miLista, miListaComFotos,
        miCombo, miAreaTexto, miDialogMessage, miGuiPedido;

    public GuiMenuPrincipal() {
        inicializarComponents();
        definirEventos();
    }

    private void inicializarComponents() {
        setTitle("Men Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic('A');
        mnExemplos = new JMenu("Exemplos");
        mnExemplos.setMnemonic('E');
        miSair = new JMenuItem("Sair");
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        miBotao = new JMenuItem("Botão");
        miCaixaOpcao = new JMenuItem("Caixa de opção");
        miRadio = new JMenuItem("Radio");
        miLabel = new JMenuItem("Label");
        miLista = new JMenuItem("Lista");
        miListaComFotos = new JMenuItem("Lista com fotos");
        miCombo = new JMenuItem("Combo");
        miAreaTexto = new JMenuItem("Area de texto");
        miDialogMessage = new JMenuItem("GuiDialogMessage");
        miGuiPedido = new JMenuItem("Gui Pedido");
        mnArquivo.add(miSair);
        mnExemplos.add(miBotao);
        mnExemplos.add(miCaixaOpcao);
        mnExemplos.add(miRadio);
        mnExemplos.add(miLabel);
        mnExemplos.add(miLista);
        mnExemplos.add(miListaComFotos);
        mnExemplos.add(miCombo);
        mnExemplos.add(miAreaTexto);
        mnExemplos.add(miDialogMessage);
        mnExemplos.add(miGuiPedido);
        mnBarra.add(mnArquivo);
        mnBarra.add(mnExemplos);
        setJMenuBar(mnBarra);
    }

    private void definirEventos() {

        miSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        miBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiBotao botao = new GuiBotao();
                contentPane.removeAll();
                contentPane.add(botao);
                contentPane.validate();
            }
        });

        miCaixaOpcao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCaixaOpcao guiCaixaOpcao = new GuiCaixaOpcao();
                contentPane.removeAll();
                contentPane.add(guiCaixaOpcao);
                contentPane.validate();
            }
        });

        miRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiRadio guiRadio = new GuiRadio();
                contentPane.removeAll();
                contentPane.add(guiRadio);
                contentPane.validate();
            }
        });

        miLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLabel guiLabel = new GuiLabel();
                contentPane.removeAll();
                contentPane.add(guiLabel);
                contentPane.validate();
            }
        });

        miLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLista guiLista = new GuiLista();
                contentPane.removeAll();
                contentPane.add(guiLista);
                contentPane.validate();
            }
        });

        miListaComFotos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiListaComFotos guiListaComFotos = new GuiListaComFotos();
                contentPane.removeAll();
                contentPane.add(guiListaComFotos);
                contentPane.validate();
            }
        });

        miCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCombo guiCombo = new GuiCombo();
                contentPane.removeAll();
                contentPane.add(guiCombo);
                contentPane.validate();
            }
        });

        miAreaTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAreaTexto guiAreaTexto = new GuiAreaTexto();
                contentPane.removeAll();
                contentPane.add(guiAreaTexto);
                contentPane.validate();
            }
        });

        miDialogMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDialogMessage guiDialogMessage = new GuiDialogMessage();
                contentPane.removeAll();
                contentPane.add(guiDialogMessage);
                contentPane.validate();
            }
        });

        miGuiPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiPedido guiPedido = new GuiPedido();
                contentPane.removeAll();
                contentPane.add(guiPedido);
                contentPane.validate();
            }
        });



    }

    public static void abrir() {
        GuiMenuPrincipal frame = new GuiMenuPrincipal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((tela.width - (frame.getSize().width)) / 2,
                (tela.height - (frame.getSize().height)) / 2);
        frame.setVisible(true);
    }
}
