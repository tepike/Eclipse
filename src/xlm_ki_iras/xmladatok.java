package xlm_ki_iras;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class xmladatok {

	public static void main(String[] args) {


		try {
			DocumentBuilderFactory a=DocumentBuilderFactory.newInstance();
			DocumentBuilder b=a.newDocumentBuilder();
			Document c=b.newDocument();

			
			
			Element Gyoker=c.createElement("Bevasarlas");
			c.appendChild(Gyoker);
			
			Element bolt1=c.createElement("Aldi");
			Gyoker.appendChild(bolt1);
			Attr kiegeszito=c.createAttribute("Azonosito");
			kiegeszito.setValue("523");
			bolt1.setAttributeNode(kiegeszito);
			

			

			Element kategoria1=c.createElement("Ruhazat");
			
			bolt1.appendChild(kategoria1);
			Element Termek1=c.createElement("Termek");
			Termek1.appendChild(c.createTextNode("Adidas"));
			kategoria1.appendChild(Termek1);
			Element Termek2=c.createElement("Termek");
			Termek2.appendChild(c.createTextNode("Nike"));
			kategoria1.appendChild(Termek2);

			
			
			
			Element kategoria2=c.createElement("Elelmiszer");
			
			bolt1.appendChild(kategoria2);
			Element Termek_Elelmiszer1=c.createElement("Termek");
			Termek_Elelmiszer1.appendChild(c.createTextNode("Meleg"));
			kategoria2.appendChild(Termek_Elelmiszer1);
			Element Termek_Elelmiszer2=c.createElement("Termek");
			Termek_Elelmiszer2.appendChild(c.createTextNode("Hideg"));
			kategoria2.appendChild(Termek_Elelmiszer2);

			
			
			
			Element kategoria3=c.createElement("Egyeb");
			
			bolt1.appendChild(kategoria3);
			Element Termek_Egyeb1=c.createElement("Termek");
			Termek_Egyeb1.appendChild(c.createTextNode("Tisztitoszer"));
			kategoria3.appendChild(Termek_Egyeb1);
			Element Termek_Egyeb2=c.createElement("Termek");
			Termek_Egyeb2.appendChild(c.createTextNode("Higienia"));
			kategoria3.appendChild(Termek_Egyeb2);

			
			
			Element bolt2=c.createElement("Lidl");
			Gyoker.appendChild(bolt2);
			Attr kiegeszito2=c.createAttribute("Azonosito");
			kiegeszito2.setValue("956");
			bolt2.setAttributeNode(kiegeszito2);
			
			
			Element kategoria_lidl1=c.createElement("Ruhazat");
			
			bolt2.appendChild(kategoria_lidl1);
			Element Termek_Lidl1=c.createElement("Termek");
			Termek_Lidl1.appendChild(c.createTextNode("Fila"));
			kategoria_lidl1.appendChild(Termek_Lidl1);
			Element Termek_Lidl2=c.createElement("Termek");
			Termek_Lidl2.appendChild(c.createTextNode("O'neil"));
			kategoria_lidl1.appendChild(Termek_Lidl2);
			

			
			
			TransformerFactory tf=TransformerFactory.newInstance();
			Transformer t=tf.newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			
			DOMSource s=new DOMSource(c);
			StreamResult r=new StreamResult(new File("kezeles.xml"));
			t.transform(s, r);
			System.out.println("Kész");
	       
	       
	       // Node cars = c.getFirstChild();
	        Node Lidl = c.getElementsByTagName("Lidl").item(0);
	        

	        NamedNodeMap attr = Lidl.getAttributes();
	        Node nodeAttr = attr.getNamedItem("Azonosito");
	        nodeAttr.setTextContent("Bigyo");


	        NodeList list = Lidl.getChildNodes();
	        
	        for (int temp = 0; temp < list.getLength(); temp++) {
	           Node node = list.item(temp);
	            
	              Element eElement = (Element) node;
	              if ("Termek".equals(eElement.getNodeName())) {
	                 if("Fila".equals(eElement.getTextContent())) {
	                    eElement.setTextContent("Puma");
	                 }
	                 if("O'neil".equals(eElement.getTextContent()))
	                    eElement.setTextContent("Keni");
	              }
	           }
	        
	        
	        
	        
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

	

        

        }


}





