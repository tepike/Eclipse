package Grafikus1;
import javax.swing.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Megjelenites2 extends JFrame {
    private static  int versenyzolista=5;
    private static  int currentIndex = -1;
    private JTextArea chatBox;

    Megjelenites2() {
       

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(10, 300, 100, 40);
        add(backBtn);

        JButton nextBtn = new JButton("Next");
        nextBtn.setBounds(250, 300, 100, 40);
        add(nextBtn);

        chatBox = new JTextArea();
        chatBox.setBounds(30, 50, 300, 200);
        chatBox.setEditable(false);
        chatBox.setText("Versenyzők beolvasásához kattints a tovább gombra");
        add(chatBox);

        setSize(400, 500);
        setLayout(null);
        setVisible(true);

        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent mindegy) {
                if (currentIndex > 0) {
                    currentIndex--;
                    chatBox.setText(""+currentIndex);
                }
            }
        });

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent mindegy) {
                if (currentIndex < versenyzolista) {
                    currentIndex++;

                    chatBox.setText(""+currentIndex);
                }
            }
        });
    }

    public static void main(String[] args) {
    	new Megjelenites2();
    }

}
