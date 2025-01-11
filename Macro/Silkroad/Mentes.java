package Silkroad;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;

public class Mentes {

    static int felvetel_index = 0;

    public static void Mentes_Letrehozas() throws ParserConfigurationException, TransformerException {

        System.out.println("Mentes parancs elindítva");

        // A fájl kiválasztása a fájlválasztóval
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setDialogTitle("Válassza ki a mentési helyet");
        fileChooser.setSelectedFile(new File("Silkroad_Macro.xml")); // Alapértelmezett fájlnév
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML", "xml");
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        // A felhasználó által választott fájl
        int result = fileChooser.showSaveDialog(Main.frame);



        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document xml = builder.newDocument();

        // Gyökérelem létrehozása
        Element Gyoker = xml.createElement("Makró");
        xml.appendChild(Gyoker);

        // Tárolt adatok hozzáadása
        for (JLabel label : Main.Felvett_macro_Skill_megjelenit) {
            String gomb = label.getText();
            //System.out.println("Felvett label ki irasa");
            //System.out.println(label.getText());
            Main.Rogzites.add(new Felvetel(Integer.parseInt(gomb),
                    Double.parseDouble(Main.Felvett_macro_Ido_megjelenit.get(felvetel_index).getText())));

            Element taroltAdat = xml.createElement("Tárolt_adat");
            Gyoker.appendChild(taroltAdat);

            Element skill = xml.createElement("Skill_gomb");
            skill.appendChild(xml.createTextNode(gomb));
            taroltAdat.appendChild(skill);

            Element ido = xml.createElement("Várakozási_idő");
            ido.appendChild(xml.createTextNode(Main.Felvett_macro_Ido_megjelenit.get(felvetel_index).getText()));
            taroltAdat.appendChild(ido);

            // Debug kiírás minden elemhez

            felvetel_index++;
        }




        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile(); // A választott fájl

            // Debug kimenet a fájl elérési útra
            System.out.println("Kiválasztott fájl: " + selectedFile.getAbsolutePath());

            // Itt folytathatod a mentési folyamatot
            try {
                // XML dokumentum létrehozása
                saveToXML(xml, selectedFile); // Feltételezve, hogy van egy saveToXML metódus

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("A mentés megszakítva.");
        }
        
        System.out.println("Mentés kész.");
    }

    private static org.w3c.dom.Document createXMLDocument() {
        // Itt implementálhatod az XML dokumentum létrehozását
        // Ez lehet ugyanaz a kód, amit korábban használtál az XML generálásához
        return null; // Csak példa
    }

    private static void saveToXML(org.w3c.dom.Document xml, File file) throws IOException, TransformerException {
        // Itt implementálhatod az XML fájl mentését a megfelelő fájlba
        // Ugyanaz a kód, amit a fájl mentésére használtál
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        DOMSource source = new DOMSource(xml);
        StreamResult result2 = new StreamResult(file); // Itt a fájlválasztó által választott fájlt használjuk
        transformer.transform(source, result2);

        System.out.println("Fájl sikeresen mentve: " + file.getAbsolutePath());
    }
}
