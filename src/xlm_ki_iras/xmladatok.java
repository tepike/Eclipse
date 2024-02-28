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

			// A tanulóknak rögzítik a nevét, osztályát, testsúlyát, életkorát, sportágát. 
			
			Element Gyoker=c.createElement("Tanulok");
			c.appendChild(Gyoker);
			
			Element bolt1=c.createElement("Tanulo");
			Gyoker.appendChild(bolt1);	

			Element kategoria1=c.createElement("Diak");
			
			bolt1.appendChild(kategoria1);
			Element Termek1=c.createElement("Osztaly");
			Termek1.appendChild(c.createTextNode("Adidas"));
			kategoria1.appendChild(Termek1);
			Element Termek2=c.createElement("Tagozat");
			Termek2.appendChild(c.createTextNode("Nike"));
			kategoria1.appendChild(Termek2);
			
			Element Termek3=c.createElement("Termek");
			Termek3.appendChild(c.createTextNode("Nike"));
			kategoria1.appendChild(Termek3);

			

			
			
			TransformerFactory tf=TransformerFactory.newInstance();
			Transformer t=tf.newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			
			DOMSource s=new DOMSource(c);
			StreamResult r=new StreamResult(new File("kezeles.xml"));
			t.transform(s, r);
			System.out.println("Kész van");
	      
	        
	        
	        
	        
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

	

        

        }


}





