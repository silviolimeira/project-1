package com.sl.tool;

import com.sun.source.util.Plugin;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.reflect.*;
import javax.swing.*;

public class AplicacaoExtensivel extends JFrame implements ActionListener {
  JPanel panelNorth, panelPlugin;
  JFileChooser fileChooser;
  File file;
  JButton buttonLoadImage, buttonLoadPlugin;
  BufferedImage image;
  Plugin plugin;

  public AplicacaoExtensivel() {
    super("Aplicação Extensível");
    buttonLoadImage = new JButton("Carregar Imagem");
    buttonLoadImage.addActionListener(this);
    buttonLoadPlugin = new JButton("Carregar Plugin");
    buttonLoadPlugin.addActionListener(this);
    getContentPane().setLayout(new BorderLayout());
    panelPlugin = new JPanel();
    panelNorth = new JPanel();
    getContentPane().add(panelNorth, BorderLayout.NORTH);
    panelNorth.add(buttonLoadImage);
    panelNorth.add(buttonLoadPlugin);
    setSize(800, 800);
    setVisible(true);
  }

  public void setImage(BufferedImage a_image) {
    image = a_image;
  }

  public BufferedImage getImage() {
    return image;
  }

  public void paint(Graphics g) {
    super.paint(g);
    g.drawImage(image, 10, 100, null);
  }

  public static void main(String args[]) {
    AplicacaoExtensivel ae = new AplicacaoExtensivel();
  }

  public void actionPerformed(ActionEvent e) {
    fileChooser = new JFileChooser(new File("./"));
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.showOpenDialog(null);

    if (e.getSource() == buttonLoadImage) {
      try {
        image = ImageIO.read(fileChooser.getSelectedFile());
      }
      catch (IOException ioexception) {
        // Tratar
      }
    }
    else if (e.getSource() == buttonLoadPlugin) {
      try {
        String l_path = fileChooser.getSelectedFile().getName();
        l_path = l_path.substring(0, l_path.indexOf('.'));
        Class l_class = Class.forName(l_path);
        Constructor l_constructor = l_class.getConstructor();
        plugin = (Plugin) l_constructor.newInstance();
        //plugin.setApplication(this);
        //plugin.setPanel(panelPlugin);
        //plugin.();
        getContentPane().add(panelPlugin, BorderLayout.SOUTH);
        validate();
      }
      catch (Exception exception) {
        // Tratar
      }
    }
    repaint();
  }
};