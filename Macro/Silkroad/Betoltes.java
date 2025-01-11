package Silkroad;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Betoltes {

    public static void Betoltes_Letrehozasa() {
        System.out.println("Betoltesi protokoll elinditva");
        Felvetel.Felvett_Gombok.remove(Felvetel.scrollPane);
        Felvetel.Felvett_Gombok.repaint();
        Main.frame.revalidate();
        Main.frame.repaint();

        // Fájlválasztó létrehozása
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Válassza ki az XML fájlt");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML", "xml");
        fileChooser.setFileFilter(filter);
        fileChooser.setSelectedFile(new File("Silkroad_Macro.xml"));

        // Fájl kiválasztás
        int result = fileChooser.showOpenDialog(Main.frame);  // Az ablak főkerete helyett null, ha nincsenek paraméterek

        if (result == JFileChooser.APPROVE_OPTION) {
            // A felhasználó által kiválasztott fájl
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Kiválasztott fájl: " + selectedFile.getAbsolutePath());

            // Az XML fájl betöltése
            loadXMLFile(selectedFile);
        } else {
            System.out.println("Nincs fájl kiválasztva.");
        }

    }

    // XML fájl betöltése
    private static void loadXMLFile(File file) {
    	try {
    		Felvetel.Felvett_Gombok.removeAll();
    		Main.Felvett_macro_Skill_megjelenit.clear();
    		Main.Felvett_macro_Ido_megjelenit.clear();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	boolean torolve=false;
        try {
            // XML fájl beolvasása
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream(file));

            // Az XML fájl feldolgozása
            System.out.println("XML fájl sikeresen beolvasva.");
            
            // Gyökérelem lekérése
            NodeList nList = document.getElementsByTagName("Tárolt_adat");
            System.out.println("For ciklus iditas: ");
            for (int i = 0; i < nList.getLength(); i++) {
            	System.out.println("For ciklus: "+i);
                Node nNode = nList.item(i);

                // Gombok és idők kinyerése az XML-ből
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element eElement = (org.w3c.dom.Element) nNode;
                    
                    String gomb = eElement.getElementsByTagName("Skill_gomb").item(0).getTextContent();
                    String ido = eElement.getElementsByTagName("Várakozási_idő").item(0).getTextContent();


                    // Az adatokat hozzáadjuk a felülethez

                    	System.out.println("Gomb felvetel index: "+i);
                    	JLabel Skill= new JLabel();
                        Skill.setText(gomb);
                        JLabel Ido= new JLabel();
                        Ido.setText(ido);
                        

                        	System.err.println("else  ="+Main.Felvett_macro_Skill_megjelenit.size());{
                            Main.Felvett_macro_Skill_megjelenit.add(Skill);
                        	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setBounds(30, Main.Felvett_macro_Skill_megjelenit.size()* 30, 100, 30);
                        	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
                        	Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1).setForeground(Color.red);
                    	
                        	Main.Felvett_macro_Ido_megjelenit.add(Ido);
                        	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setBounds(100, Main.Felvett_macro_Ido_megjelenit.size() * 30, 100, 30);
                        	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setFont(new Font("Arial", 0, 20));
                        	Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1).setForeground(Color.red);
                            System.out.println("Beolvasott gomb else ag: "+gomb);
                            System.out.println("Beolvasott ido else ag: "+ido);
						}
                        	
                        	
                        	Felvetel.Felvett_Gombok.add(Main.Felvett_macro_Skill_megjelenit.get(Main.Felvett_macro_Skill_megjelenit.size()-1));
                        	Felvetel.Felvett_Gombok.add(Main.Felvett_macro_Ido_megjelenit.get(Main.Felvett_macro_Ido_megjelenit.size()-1));
                        	
                        	Felvetel.Felvett_Gombok.repaint();
                        	Main.frame.repaint(); 
                    }
                    
                    
                }
            


            // UI frissítése, hogy megjelenjenek az új adatok
            Felvetel.Felvett_Gombok.repaint();
            Main.frame.repaint();

        } catch (IOException | SAXException e) {
            System.err.println("Hiba történt az XML fájl betöltésekor: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Hiba történt a fájl betöltésekor: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

    // Létrehoz egy új JLabel-t a gomb és idő tartalmával
    private static javax.swing.JLabel createLabel(String gomb, String ido) {
        javax.swing.JLabel label = new javax.swing.JLabel();
        label.setText("Gomb: " + gomb + " Idő: " + ido);
        label.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 16));
        return label;
    }
}
