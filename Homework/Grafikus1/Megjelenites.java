package Grafikus1;
import javax.swing.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Megjelenites extends JFrame {
    private NodeList versenyzolista;
    private int currentIndex = 0;
    private JTextArea chatBox;

    Megjelenites(NodeList versenyzolista) {
        this.versenyzolista = versenyzolista;
        
        JButton nextBtn = new JButton("Next");
        nextBtn.setBounds(250, 300, 100, 40);
        add(nextBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(10, 300, 100, 40);
        add(backBtn);



        chatBox = new JTextArea();
        chatBox.setBounds(30, 50, 300, 200);
        chatBox.setEditable(false);
        add(chatBox);
        displayCurrentData();
        

        //Ablak adatok megadása mivel extends JFrame megvolt csak így.
        setSize(400, 500);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        
        //Ablak megnyitásának elhelyezése int-ben.
        setLocationRelativeTo(null);
        //setLocation(500,100);
        

        

        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent mindegy) {
                if (currentIndex > 0) {
                    currentIndex--;
                    displayCurrentData();
                }
            }
        });

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < versenyzolista.getLength()) {
                    currentIndex++;
                    displayCurrentData();
                }
            }
        });
    }

    private void displayCurrentData() {
        if (currentIndex >= 0 && currentIndex < versenyzolista.getLength()) {
            Node versenyzo = versenyzolista.item(currentIndex);
            if (versenyzo.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) versenyzo;
                String nev = eElement.getElementsByTagName("Nev").item(0).getTextContent();
                String orszag = eElement.getElementsByTagName("Szarmazasihely").item(0).getTextContent();
                String eletkor = eElement.getElementsByTagName("Eletkor").item(0).getTextContent();
                String pontszam = eElement.getElementsByTagName("Pontszam").item(0).getTextContent();

                String data = "Versenyzo neve: " + nev + "\n" +
                              "Versenyzo orszaga: " + orszag + "\n" +
                              "Versenyzo eletkora: " + eletkor + "\n" +
                              "Versenyzo pontszama: " + pontszam + "\n\n";

                chatBox.setText(data);
            }
        }
    }
    

    public static void main(String[] args) {
        try {
            File inputFile = new File("Versenyzők.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();
            NodeList versenyzolista = document.getElementsByTagName("Versenyzo");

            SwingUtilities.invokeLater(() -> new Megjelenites(versenyzolista));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
