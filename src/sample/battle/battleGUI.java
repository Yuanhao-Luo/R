package sample.battle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class battleGUI extends JFrame {
    JPanel panel;
    JLabel label;
    ImageIcon background;

    public battleGUI() {

        background = new ImageIcon("D:\\R\\images\\battle\\background.png");
        label = new JLabel(background);
        panel = new JPanel();
        panel.add(label);

        this.add(panel);
        this.setVisible(true);
        this.setSize(1025, 770);

    }

}


