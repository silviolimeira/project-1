package com.sl.swing.pag169;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;

public class GuiPedido extends JPanel {

    DecimalFormat df = new DecimalFormat("#,###.00");

    //principal
    private JPanel pnPrincipal;
    private JButton btRemover, btAdicionar;
    private JLabel lbNumero, lbTotal, lbProduto, lbPrecoUnitario, lbQuantidade;
    private JTextField tfNumero, tfTotal, tfProduto, tfPrecoUnitario, tfQuantidade;

    //subform
    private JPanel pnTable;
    private JScrollPane scrollPane;
    private JTable table;

    public GuiPedido() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {

        df.setMinimumFractionDigits(2);
        df.setMinimumFractionDigits(2);

        //subform
        pnTable = new JPanel(new BorderLayout());
        pnTable.setBorder(new TitledBorder("Itens do pedido"));
        scrollPane = new JScrollPane();

        //principal

        setLayout(null);
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);

        //principal-edição
        lbProduto = new JLabel("Produto");
        lbQuantidade = new JLabel("Quantidade");
        lbPrecoUnitario = new JLabel("Preço Uniário");
        lbNumero = new JLabel("Numero do Pedido");
        lbTotal = new JLabel("Total do pedido:");
        tfProduto = new JTextField();
        tfPrecoUnitario = new JTextField();
        tfQuantidade = new JTextField();
        tfNumero = new JTextField();
        tfTotal = new JTextField();
        tfTotal.setEnabled(false);
        tfTotal.setHorizontalAlignment(JTextField.RIGHT);

        //principal-dimensionamento

        lbProduto.setBounds(15,40,100,25);
        lbQuantidade.setBounds(225,40,100,25);
        lbPrecoUnitario.setBounds(310,40,100,25);
        lbNumero.setBounds(15,10,120,25);
        lbTotal.setBounds(278,360,100,25);
        tfProduto.setBounds(15,65,200,25);
        tfQuantidade.setBounds(225,65,50,25);
        tfPrecoUnitario.setBounds(310,65,80,25);
        tfNumero.setBounds(130,10,50,25);
        tfTotal.setBounds(375,360,100,25);

        //principal-botões controle
        btAdicionar = new JButton("Adicionar");
        btAdicionar.setToolTipText("Adiciona um item ao pedido");
        btRemover = new JButton("Remover");
        btRemover.setToolTipText("Remove os itens selecionados");
        pnPrincipal.add(btAdicionar);
        pnPrincipal.add(btRemover);


        //principal-painel
        pnPrincipal.setBounds(0,0,500,400);
        pnPrincipal.add(lbNumero);
        pnPrincipal.add(tfNumero);
        pnPrincipal.add(lbTotal);
        pnPrincipal.add(tfTotal);
        pnPrincipal.add(lbProduto);
        pnPrincipal.add(tfProduto);
        pnPrincipal.add(lbQuantidade);
        pnPrincipal.add(tfQuantidade);
        pnPrincipal.add(lbPrecoUnitario);
        pnPrincipal.add(tfPrecoUnitario);

        btAdicionar.setBounds(15,100,100,22);
        btRemover.setBounds(125,100,100,22);


        //principal-subform

        DefaultTableModel tableModel = new DefaultTableModel(
                new String[] { "Produto", "Quantidade", "Preço Un.", "Total"}, 0) {
            public boolean isCellEditable(int row, int col) {
                if (col == 3) {
                    return false;
                }
                return true;
            }
        };
        table = new JTable(tableModel);
        DefaultTableCellRenderer alinhaDireita = new DefaultTableCellRenderer();
        alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);



        add(pnPrincipal);
    }

    private void definirEventos() {

    }

}
