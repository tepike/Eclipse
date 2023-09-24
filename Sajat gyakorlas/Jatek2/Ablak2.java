//1
package Jatek2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ablak2 extends JFrame {
    private JPanel menuPanel;
    private JPanel gamePanel;
    private JPanel settingsPanel;
    private JTextField chatBox;

    Ablak2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        getContentPane().setBackground(Color.CYAN);
        getContentPane().setLayout(new FlowLayout());


        chatBox = new JTextField();
        chatBox.setLayout(null);
        getContentPane().add(chatBox);
        chatBox.setBounds(150, 150, 600, 30); // Állítsd be a chatbox méretét és helyét
        chatBox.setEditable(true);
        chatBox.setText("Panel1");
        
        

        menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, 784, 561);
        getContentPane().add(menuPanel);

        gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 784, 561);
        gamePanel.setVisible(false);
        getContentPane().add(gamePanel);

        settingsPanel = new JPanel();
        settingsPanel.setBounds(0, 0, 784, 561);
        settingsPanel.setVisible(false);
        getContentPane().add(settingsPanel);

        
        JButton btnNewGame = new JButton("Új játék");
        btnNewGame.setBounds(318, 202, 150, 57);
        menuPanel.add(btnNewGame);

        btnNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuPanel.setVisible(false);
                gamePanel.setVisible(true);
                chatBox.setText("Panel1");
            }
        });

        JButton btnSettings = new JButton("Beállítások");
        btnSettings.setBounds(318, 288, 150, 57);
        menuPanel.add(btnSettings);

        btnSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuPanel.setVisible(false);
                settingsPanel.setVisible(true);
                chatBox.setText("Panel2");
            }
        });

        JButton btnBackGame = new JButton("Vissza");
        btnBackGame.setBounds(318, 500, 150, 57);
        gamePanel.add(btnBackGame);

        btnBackGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gamePanel.setVisible(false);
                menuPanel.setVisible(true);
                chatBox.setText("Panel1");
            }
        });

        JButton btnBackSettings = new JButton("Vissza");
        btnBackSettings.setBounds(318, 500, 150, 57);
        settingsPanel.add(btnBackSettings);

        btnBackSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settingsPanel.setVisible(false);
                menuPanel.setVisible(true);
                chatBox.setText("Panel1");
            }
        });

      
        add(chatBox);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ablak2();
    }
}
