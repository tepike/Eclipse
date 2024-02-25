package feladat3;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class main {
    private static final String FILE_NAME = "tanulok.xml";
    private static final String[] SPORTAGAK = {"futas", "uszas", "kosarlabda", "foci"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            File file = new File(FILE_NAME);
            Document doc;
            if (file.exists()) {
                doc = builder.parse(file);
            } else {
                doc = builder.newDocument();
                Element rootElement = doc.createElement("tanulok");
                doc.appendChild(rootElement);
            }

            while (true) {
                System.out.println("Valasszon muveletet:");
                System.out.println("1. Uj tanulo rogzitese");
                System.out.println("2. Tanulok listazasa");
                System.out.println("3. Kilepes");
                int valasztas = scanner.nextInt();
                scanner.nextLine(); 

                switch (valasztas) {
                    case 1:
                        ujTanulo(doc, scanner);
                        break;
                    case 2:
                        listazTanulok(doc);
                        break;
                    case 3:
                        // Kilépés és XML fájl mentése
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(new File(FILE_NAME));
                        transformer.transform(source, result);
                        System.out.println("Kilepes");
                        return;
                    default:
                        System.out.println("Hibas valasztas! Kerem valasszon ujra.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ujTanulo(Document doc, Scanner scanner) {
        try {
            Element tanulokElem = (Element) doc.getFirstChild();
            Element tanuloElem = doc.createElement("tanulo");

            System.out.println("Adja meg a tanulo nevet:");
            String nev = scanner.nextLine();
            Element nevElem = doc.createElement("nev");
            nevElem.appendChild(doc.createTextNode(nev));
            tanuloElem.appendChild(nevElem);

            System.out.println("Adja meg a tanulo osztalyat:");
            String osztaly = scanner.nextLine();
            Element osztalyElem = doc.createElement("osztaly");
            osztalyElem.appendChild(doc.createTextNode(osztaly));
            tanuloElem.appendChild(osztalyElem);

            System.out.println("Adja meg a tanulo testsulyat:");
            int testsuly = Integer.parseInt(scanner.nextLine());
            Element testsulyElem = doc.createElement("testsuly");
            testsulyElem.appendChild(doc.createTextNode(String.valueOf(testsuly)));
            tanuloElem.appendChild(testsulyElem);

            System.out.println("Adja meg a tanulo eletkorat:");
            int eletkor = Integer.parseInt(scanner.nextLine());
            Element eletkorElem = doc.createElement("eletkor");
            eletkorElem.appendChild(doc.createTextNode(String.valueOf(eletkor)));
            tanuloElem.appendChild(eletkorElem);

            String sportag = valasztSportag(scanner);
            Element sportagElem = doc.createElement("sportag");
            sportagElem.appendChild(doc.createTextNode(sportag));
            tanuloElem.appendChild(sportagElem);

            tanulokElem.appendChild(tanuloElem);
            System.out.println("Tanulo sikeresen rogzitve!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listazTanulok(Document doc) {
        NodeList tanulok = doc.getElementsByTagName("tanulo");
        System.out.println("Tanulok:");
        for (int i = 0; i < tanulok.getLength(); i++) {
            Element tanulo = (Element) tanulok.item(i);
            String nev = tanulo.getElementsByTagName("nev").item(0).getTextContent();
            String osztaly = tanulo.getElementsByTagName("osztaly").item(0).getTextContent();
            int testsuly = Integer.parseInt(tanulo.getElementsByTagName("testsuly").item(0).getTextContent());
            int eletkor = Integer.parseInt(tanulo.getElementsByTagName("eletkor").item(0).getTextContent());
            String sportag = tanulo.getElementsByTagName("sportag").item(0).getTextContent();
            System.out.println("Nev: " + nev + ", Osztaly: " + osztaly + ", Testsily: " + testsuly +
                    ", Eletkor: " + eletkor + ", Sportag: " + sportag);
        }
    }

    private static String valasztSportag(Scanner scanner) {
        System.out.println("Valasszon sportagat:");
        for (int i = 0; i < SPORTAGAK.length; i++) {
            System.out.println((i+1) + ". " + SPORTAGAK[i]);
        }
        int sportagValasztas = Integer.parseInt(scanner.nextLine());
        if (sportagValasztas >= 1 && sportagValasztas <= SPORTAGAK.length) {
            return SPORTAGAK[sportagValasztas - 1];
        } else {
            System.out.println("Hibas sportag valasztas! Kerem valasszon ujra.");
            return valasztSportag(scanner);
        }
    }
}
