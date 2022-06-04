package com.sl.tool;

import com.sl.tool.AplicacaoExtensivel;
import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class Resize implements Plugin, ChangeListener {
  AplicacaoExtensivel appExtensivel;
  JPanel panel;
  JLabel label;
  JSlider slider;
  BufferedImage sourceImage;

  public void setApplication(AplicacaoExtensivel a_app) {
    appExtensivel = a_app;
  }

  public void setPanel(JPanel a_panel) {
    panel = a_panel;
  }

  public void load() {
    label = new JLabel("Redimensionar:");
    slider = new JSlider(SwingConstants.HORIZONTAL, 1, 401, 100);
    slider.setMajorTickSpacing(5);
    slider.addChangeListener(this);
    panel.add(label);
    panel.add(slider);
    sourceImage = null;
  }

  public void stateChanged(ChangeEvent e) {
    double l_factor = slider.getValue() / 100.0;
    if (sourceImage == null) {
      sourceImage = appExtensivel.getImage();
    }
    BufferedImage l_img = new BufferedImage(
        (int) (sourceImage.getWidth() * l_factor), (int) (sourceImage
            .getHeight() * l_factor), BufferedImage.TYPE_INT_RGB);
    Graphics2D l_buf = l_img.createGraphics();
    l_buf.drawImage(sourceImage, 0, 0,
        (int) (sourceImage.getWidth() * l_factor), (int) (sourceImage
            .getHeight() * l_factor), null);
    appExtensivel.setImage(l_img);
    appExtensivel.repaint();
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public void init(JavacTask task, String... args) {

  }

  public static void main(String[] args) {
    System.out.println("Hello Resize");
  }

};
