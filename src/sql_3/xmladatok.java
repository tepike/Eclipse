package sql_3;
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
			Element dd=c.createElement("Versenyzok");
			c.appendChild(dd);
			
			
			//1
			Element d=c.createElement("Versenyzo");
			dd.appendChild(d);			
			Element n1=c.createElement("Nev");
			n1.appendChild(c.createTextNode("Ved Elek"));
			d.appendChild(n1);	
			
			Element n2=c.createElement("Szarmazasihely");
			n2.appendChild(c.createTextNode("Oroszország"));
			d.appendChild(n2);		
			
			Element n3=c.createElement("Eletkor");
			n3.appendChild(c.createTextNode("30"));
			d.appendChild(n3);		
			
			Element n4=c.createElement("Pontszam");
			n4.appendChild(c.createTextNode("250"));
			d.appendChild(n4);
			
			//2
			Element e=c.createElement("Versenyzo");
			dd.appendChild(e);			
			Element n5=c.createElement("Nev");
			n5.appendChild(c.createTextNode("Dzsuzepp Elek"));
			e.appendChild(n5);		
			
			Element n6=c.createElement("Szarmazasihely");
			n6.appendChild(c.createTextNode("Olaszország"));
			e.appendChild(n6);	
			
			Element n7=c.createElement("Eletkor");
			n7.appendChild(c.createTextNode("25"));
			e.appendChild(n7);
			
			Element n8=c.createElement("Pontszam");
			n8.appendChild(c.createTextNode("315"));
			e.appendChild(n8);
			
			//3
			Element f=c.createElement("Versenyzo");
			dd.appendChild(f);			
			Element n9=c.createElement("Nev");
			n9.appendChild(c.createTextNode("Herg Elek"));
			f.appendChild(n9);		
			
			Element n10=c.createElement("Szarmazasihely");
			n10.appendChild(c.createTextNode("Portugália"));
			f.appendChild(n10);	
			
			Element n11=c.createElement("Eletkor");
			n11.appendChild(c.createTextNode("24"));
			f.appendChild(n11);
			
			Element n12=c.createElement("Pontszam");
			n12.appendChild(c.createTextNode("159"));
			f.appendChild(n12);
			
			//4
			Element g=c.createElement("Versenyzo");
			dd.appendChild(g);			
			Element n13=c.createElement("Nev");
			n13.appendChild(c.createTextNode("Kerep Elek"));
			g.appendChild(n13);		
			
			Element n14=c.createElement("Szarmazasihely");
			n14.appendChild(c.createTextNode("Macedónia"));
			g.appendChild(n14);	
			
			Element n15=c.createElement("Eletkor");
			n15.appendChild(c.createTextNode("36"));
			g.appendChild(n15);
			
			Element n16=c.createElement("Pontszam");
			n16.appendChild(c.createTextNode("210"));
			g.appendChild(n16);
			
			//5
			Element h=c.createElement("Versenyzo");
			dd.appendChild(h);			
			Element n17=c.createElement("Nev");
			n17.appendChild(c.createTextNode("Sprint Elek"));
			h.appendChild(n17);		
			
			Element n18=c.createElement("Szarmazasihely");
			n18.appendChild(c.createTextNode("Magyarország"));
			h.appendChild(n18);	
			
			Element n19=c.createElement("Eletkor");
			n19.appendChild(c.createTextNode("29"));
			h.appendChild(n19);
			
			Element n20=c.createElement("Pontszam");
			n20.appendChild(c.createTextNode("223"));
			h.appendChild(n20);
			
			//6
			Element i=c.createElement("Versenyzo");
			dd.appendChild(i);			
			Element n21=c.createElement("Nev");
			n21.appendChild(c.createTextNode("Per Elek"));
			i.appendChild(n21);		
			
			Element n22=c.createElement("Szarmazasihely");
			n22.appendChild(c.createTextNode("Magyarország"));
			i.appendChild(n22);	
			
			Element n23=c.createElement("Eletkor");
			n23.appendChild(c.createTextNode("28"));
			i.appendChild(n23);
			
			Element n24=c.createElement("Pontszam");
			n24.appendChild(c.createTextNode("236"));
			i.appendChild(n24);
			

			
			



			
			

			
		
			

			
			
			TransformerFactory tf=TransformerFactory.newInstance();
			Transformer t=tf.newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			
			DOMSource s=new DOMSource(c);
			StreamResult r=new StreamResult(new File("Versenyzők.xml"));
			t.transform(s, r);
			System.out.println("Kész");
	       
	       
	       // Node cars = c.getFirstChild();

	        
	        
	        
	        
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

	

        

        }


}





