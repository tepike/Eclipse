package xmlcuccok;

import java.util.Scanner;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ModifyXmlFileDemo {


   public static void main(String argv[]) {
	   Scanner input= new Scanner(System.in);
	   String beker_nev="";
	   System.out.print("Versenyzo neve:");
	   beker_nev = input.nextLine();

      try {
         File inputFile = new File("Versenyzők.xml");
         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
         Document doc = docBuilder.parse(inputFile);
         Node Versenyzok = doc.getFirstChild();
         for(int i = 0; i < 5; i++) {
         Node Versenyzo = doc.getElementsByTagName("Versenyzo").item(i);
        


         // loop the supercar child node
         NodeList list = Versenyzo.getChildNodes();
         System.out.println("For ciklus indul");
         for (int temp = 0; temp < list.getLength(); temp++) {
            Node node = list.item(temp);
            //System.out.print(node);
            //System.out.print();
            if (node.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) node;
               if ("Nev".equals(eElement.getNodeName())) {
            	   System.out.println("Talalt 'Nev' alapu gyereket ");
                  if(beker_nev.equals(eElement.getTextContent())) {
                     //eElement.getTextContent("");                	  //System.out.println("Versenyzo neve:"+eElement.getElementsByTagName("Nev").item(0).getTextContent());
                	  System.out.print(list.item(3).getTextContent());
                  }
                  
               }
            }
         }
         }
         NodeList childNodes = Versenyzok.getChildNodes();



         // write the content on console
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         System.out.println("-----------Beolvasas kesz-----------");
         StreamResult consoleResult = new StreamResult(System.out);
         //transformer.transform(source, consoleResult);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
