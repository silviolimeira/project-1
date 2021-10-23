package com.sl.swing.pag169;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {

    private JTextField tfLogin;
    private JLabel lbSenha;
    private JLabel lbLogin;
    private JButton btLogar;
    private JButton btCancelar;
    private JPasswordField pfSenha;
    private static Login frame;

    public Login() {
        iniciaComponents();
        definirEventos();
    }

    private void definirEventos() {

        btLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senha = String.valueOf(pfSenha.getPassword());
                if (tfLogin.getText().equals("") && senha.equals("")) {
                    frame.setVisible(false);
                    GuiMenuPrincipal.abrir();
                } else {
                    JOptionPane.showMessageDialog(null, "Login ou Senha incorretos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void iniciaComponents() {
        setTitle("Login no Sistema");
        setBounds(0,0,250,200);
        setLayout(null);
        tfLogin = new JTextField(5);
        pfSenha = new JPasswordField(5);
        lbSenha = new JLabel("Senha:");
        lbLogin = new JLabel("Login:");
        btLogar = new JButton("Logar");
        btCancelar = new JButton("Cancelar");
        tfLogin.setBounds(100,30,120,25);
        lbLogin.setBounds(30,30,80,25);
        lbSenha.setBounds(30,75,80,25);
        pfSenha.setBounds(100,75,120,25);
        btLogar.setBounds(20,120,100,25);
        btCancelar.setBounds(125,120,100,25);
        add(lbLogin);
        add(tfLogin);
        add(lbSenha);
        add(pfSenha);
        add(btLogar);
        add(btCancelar);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new Login();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((tela.width - frame.getSize().width) / 2,
                        (tela.height - frame.getHeight()) / 2);
                frame.setVisible(true);
            }
        });

    }

}
