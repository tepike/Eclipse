package sql_3;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


import java.io.File;
import javax.xml.parsers.*;


public class xml {
	public static void main(String[] args) {
		try {
			
			File inputFile=new File("Versenyzők.xml");
			DocumentBuilderFactory a=DocumentBuilderFactory.newInstance();
			DocumentBuilder b=a.newDocumentBuilder();
			Document c=b.parse(inputFile);
			c.getDocumentElement().normalize();
			System.out.println(c.getDocumentElement().getNodeName());
			NodeList versenyzolista=c.getElementsByTagName("Versenyzo");
			System.out.println("Versenyzok szama:"+versenyzolista.getLength());
			for (int i=0;i<versenyzolista.getLength();i++) {
				
				Node d=versenyzolista.item(i);
				
				Element e=(Element) d;
				System.out.println("Versenyzo neve:"+e.getElementsByTagName("Nev").item(0).getTextContent());
				System.out.println("Versenyzo orszaga:"+e.getElementsByTagName("Szarmazasihely").item(0).getTextContent());
				System.out.println("Versenyzo eletkora:"+e.getElementsByTagName("Eletkor").item(0).getTextContent());
				System.out.println("Versenyzo pontszama:"+e.getElementsByTagName("Pontszam").item(0).getTextContent());
			}
		}
		catch(Exception f) {
			f.printStackTrace();
		}
				
	}
}



